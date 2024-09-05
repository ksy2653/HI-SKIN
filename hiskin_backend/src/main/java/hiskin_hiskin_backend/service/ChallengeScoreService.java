package hiskin_hiskin_backend.service;

import hiskin_hiskin_backend.domain.ChallengeScore;
import hiskin_hiskin_backend.repository.ChallengeScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChallengeScoreService {
    @Autowired
    private ChallengeScoreRepository challengeScoreRepository;

    public void saveChallengeScore(String userId, int totalScore) {
        ChallengeScore challengeScore = new ChallengeScore();
        challengeScore.setUserId(userId);
        challengeScore.setScore(totalScore);
        challengeScore.setDate(LocalDate.now());
        challengeScoreRepository.save(challengeScore);
    }

    public List<ChallengeScore> getChallengeScoresByDate(String userId, LocalDate date) {
        return challengeScoreRepository.findByUserIdAndDateOrderByDateDesc(userId, date);
    }

    public List<Integer> getRecentChallengeScores(String userId) {
        // 해당 사용자의 챌린지 점수를 날짜 역순으로 최근 7개까지 가져오는 로직을 여기에 추가
        // 챌린지 점수가 7개 미만이면 null값으로 설정
        Pageable pageable = PageRequest.of(0, 7, Sort.by("date")
                .descending().and(Sort.by("id").descending()));

        List<ChallengeScore> recentChallengeScores = challengeScoreRepository.findByUserIdOrderByDateDesc(userId, pageable);

        List<Integer> responseList = new ArrayList<>(Collections.nCopies(7, null));

        // 가져온 챌린지 점수를 responseList에 채움
        for (int i = 0; i < recentChallengeScores.size(); i++) {
            responseList.set(i, recentChallengeScores.get(i).getScore());
        }

        return responseList;
    }
}
