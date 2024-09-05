package hiskin_hiskin_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChallengeScoreDTO {
    private int score;
    private LocalDate date;

    public ChallengeScoreDTO(int score, LocalDate date) {
        this.score = score;
        this.date = date;
    }
}
