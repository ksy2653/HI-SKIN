package hiskin_hiskin_backend.service;

import org.springframework.stereotype.Service;

@Service
public class SkinTypeTestService {
    public String diagnoseSkinType1(int question1_1Response, int question1_2Response) {
        // 1-1번 질문에 대한 점수 변환
        double question1_1Score = convertResponseToScore(question1_1Response);

        // 1-2번 질문에 대한 점수 변환
        double question1_2Score = convertResponseToScore(question1_2Response);

        // 두 질문에 대한 점수 총합 계산
        double totalScore = question1_1Score + question1_2Score;

        // 피부 타입 진단
        if (totalScore >= 4 && totalScore <= 8) {
            return "O"; // 지성 (Oily)
        } else if (totalScore >= 1 && totalScore < 4) {
            return "D"; // 건성 (Dry)
        } else {
            return "Unknown"; // 다른 피부 타입 또는 오류 처리
        }
    }

    public String diagnoseSkinType2(int question2_1Response, int question2_2Response) {
        // 2-1번 질문에 대한 점수 변환
        double question2_1Score = convertResponseToScore(question2_1Response);

        // 2-2번 질문에 대한 점수 변환
        double question2_2Score = convertResponseToScore(question2_2Response);

        // 두 질문에 대한 점수 총합 계산
        double totalScore2 = question2_1Score + question2_2Score;

        // 피부 타입 진단
        if (totalScore2 >= 1 && totalScore2 <= 4) {
            return "R"; // 저항성 (Resistance)
        } else if (totalScore2 > 4 && totalScore2 <= 8) {
            return "S"; // 민감성 (Sensitivity)
        } else {
            return "Unknown"; // 다른 피부 타입 또는 오류 처리
        }
    }

    public String diagnoseSkinType3(int question3_1Response, int question3_2Response) {
        // 3-1번 질문에 대한 점수 변환
        double question3_1Score = convertResponseToScore(question3_1Response);

        // 3-2번 질문에 대한 점수 변환
        double question3_2Score = convertResponseToScore(question3_2Response);

        // 두 질문에 대한 점수 총합 계산
        double totalScore3 = question3_1Score + question3_2Score;

        // 피부 타입 진단
        if (totalScore3 >= 1 && totalScore3 <= 6) {
            return "N"; // 비색소성 (Non-pigmented)
        } else if (totalScore3 > 6 && totalScore3 <= 8) {
            return "P"; // 색소성 (Pigmented)
        } else {
            return "Unknown"; // 다른 피부 타입 또는 오류 처리
        }
    }

    public String diagnoseSkinType4(int question4_1Response, int question4_2Response) {
        // 4-1번 질문에 대한 점수 변환
        double question4_1Score = convertResponseToScore(question4_1Response);

        // 4-2번 질문에 대한 점수 변환
        double question4_2Score = convertResponseToScore(question4_2Response);

        // 두 질문에 대한 점수 총합 계산
        double totalScore4 = question4_1Score + question4_2Score;

        // 피부 타입 진단
        if (totalScore4 >= 1 && totalScore4 <= 4) {
            return "T"; // 탄력있는 (Tight)
        } else if (totalScore4 > 4 && totalScore4 <= 8) {
            return "W"; // 주름진 (Wrinkled)
        } else {
            return "Unknown"; // 다른 피부 타입 또는 오류 처리
        }
    }

    private double convertResponseToScore(int response) {
        switch (response) {
            case 1:
                return 1.0;
            case 2:
                return 2.0;
            case 3:
                return 3.0;
            case 4:
                return 4.0;
            case 5:
                return 2.5;
            default:
                return 0.0; // 유효하지 않은 응답 처리
        }
    }
}
