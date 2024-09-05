package hiskin_hiskin_backend.controller;

import hiskin_hiskin_backend.domain.ChallengeScore;
import hiskin_hiskin_backend.dto.ChallengeResponseDTO;
import hiskin_hiskin_backend.dto.ChallengeScoreDTO;
import hiskin_hiskin_backend.service.ChallengeScoreService;
import hiskin_hiskin_backend.service.ChallengeService;
import hiskin_hiskin_backend.util.LoggedInUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private ChallengeScoreService challengeScoreService;
    @Autowired
    private LoggedInUserHolder loggedInUserHolder;

    @PostMapping("/challenge")
    public ResponseEntity<Map<String, Object>> calculateScore(@RequestBody ChallengeResponseDTO response) {
        int totalScore = challengeService.calculateTotalScore(response);

        String loggedInUserId = loggedInUserHolder.getLoggedInUserId();
        challengeScoreService.saveChallengeScore(loggedInUserId, totalScore);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("totalScore", totalScore);

        return ResponseEntity.ok(responseMap);
    }

    @GetMapping("/challenge-scores/week")
    public ResponseEntity<List<Integer>> getRecentChallengeScores() {
        String loggedInUserId = loggedInUserHolder.getLoggedInUserId();
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(6);  // 최근 7일 동안의 날짜 범위 계산

        List<Integer> recentChallengeScores =
                challengeScoreService.getRecentChallengeScores(loggedInUserId);

        // 챌린지 점수만을 추출하여 리스트로 반환
        List<Integer> responseList = recentChallengeScores.stream()
                .collect(Collectors.toList());

        // 최근 7일 동안의 챌린지 점수가 7개 미만인 경우 null을 포함하여 응답
        if (responseList.size() < 7) {
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(responseList);
    }
}
