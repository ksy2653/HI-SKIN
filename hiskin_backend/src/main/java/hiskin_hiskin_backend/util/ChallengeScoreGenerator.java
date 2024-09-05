package hiskin_hiskin_backend.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChallengeScoreGenerator {
    private static final int MIN_SCORE = 25;
    private static final int MAX_SCORE = 100;

    // 원하는 개수만큼 랜덤한 챌린지 점수를 생성하여 반환
    public static List<Integer> generateChallengeScores(int count) {
        List<Integer> challengeScores = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomScore = random.nextInt(MAX_SCORE - MIN_SCORE + 1) + MIN_SCORE;
            challengeScores.add(randomScore);
        }

        return challengeScores;
    }
}
