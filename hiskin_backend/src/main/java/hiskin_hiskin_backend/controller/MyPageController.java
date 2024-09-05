package hiskin_hiskin_backend.controller;

import hiskin_hiskin_backend.util.ChallengeScoreGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyPageController {
    @GetMapping("/my-page/three-months")
    public ResponseEntity<List<Integer>> getThreeMonthsChallengeScores() {
        List<Integer> challengeScores = ChallengeScoreGenerator.generateChallengeScores(6);

        return ResponseEntity.ok(challengeScores);
    }

    @GetMapping("/my-page/six-months")
    public ResponseEntity<List<Integer>> getSixMonthsChallengeScores() {
        List<Integer> challengeScores = ChallengeScoreGenerator.generateChallengeScores(6);

        return ResponseEntity.ok(challengeScores);
    }
}
