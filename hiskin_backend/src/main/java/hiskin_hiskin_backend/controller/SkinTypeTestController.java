package hiskin_hiskin_backend.controller;

import hiskin_hiskin_backend.service.SkinTypeTestService;
import hiskin_hiskin_backend.service.UserService;
import hiskin_hiskin_backend.util.LoggedInUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/skin-test")
public class SkinTypeTestController {
    @Autowired
    private SkinTypeTestService skinTypeTestService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoggedInUserHolder loggedInUserHolder;

    private Integer question1_1Response; // 1-1번 질문에 대한 응답
    private Integer question1_2Response; // 1-2번 질문에 대한 응답
    private Integer question2_1Response; // 2-2번 질문에 대한 응답
    private Integer question2_2Response; // 2-2번 질문에 대한 응답
    private Integer question3_1Response; // 3-1번 질문에 대한 응답
    private Integer question3_2Response; // 3-2번 질문에 대한 응답
    private Integer question4_1Response; // 4-1번 질문에 대한 응답
    private Integer question4_2Response; // 4-2번 질문에 대한 응답
    private String skinType1 = "Unknown"; // 1번 질문으로 진단받은 피부 타입
    private String skinType2 = "Unknown"; // 2번 질문으로 진단받은 피부 타입
    private String skinType3 = "Unknown"; // 3번 질문으로 진단받은 피부 타입
    private String skinType4 = "Unknown"; // 4번 질문으로 진단받은 피부 타입


    @PostMapping("/question1-1")
    public ResponseEntity<String> receiveQuestion1_1Response(@RequestBody Map<String, Integer> responseMap) {
        question1_1Response = responseMap.get("question1-1Response");

        if (question1_1Response != null) {
            // question1Response 변수에 사용자의 1-1번 질문 응답이 저장됩니다.
            // 사용자의 응답은 저장만 하고 아직 진단은 하지 않음
            return new ResponseEntity<>("Question 1-1 Response Received", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 1-1 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question1-2")
    public ResponseEntity<String> receiveQuestion1_2Response(@RequestBody Map<String, Integer> responseMap) {
        question1_2Response = responseMap.get("question1-2Response");

        if (question1_2Response != null) {
            // question2Response 변수에 사용자의 1-2번 질문 응답이 저장됩니다.
            // 이제 두 질문에 대한 응답이 모두 저장되었으므로 SkinTypeTestService를 호출하여 피부 타입을 진단할 수 있습니다.
            skinType1 = skinTypeTestService.diagnoseSkinType1(question1_1Response, question1_2Response);
            userService.updateUserSkinType("사용자 아이디", skinType1);

            // 결과 반환 또는 다른 작업 수행
            return new ResponseEntity<>("Question 1-2 Response Received. Skin Type: " + skinType1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 1-2 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question2-1")
    public ResponseEntity<String> receiveQuestion2_1Response(@RequestBody Map<String, Integer> responseMap) {
        question2_1Response = responseMap.get("question2-1Response");

        if (question2_1Response != null) {
            // question1Response 변수에 사용자의 1-1번 질문 응답이 저장됩니다.
            // 사용자의 응답은 저장만 하고 아직 진단은 하지 않음
            return new ResponseEntity<>("Question 2-1 Response Received", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 2-1 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question2-2")
    public ResponseEntity<String> receiveQuestion2_2Response(@RequestBody Map<String, Integer> responseMap) {
        question2_2Response = responseMap.get("question2-2Response");

        if (question2_2Response != null) {

            skinType2 = skinTypeTestService.diagnoseSkinType2(question2_1Response, question2_2Response);
            userService.updateUserSkinType("사용자 아이디", skinType2);

            // 결과 반환 또는 다른 작업 수행
            return new ResponseEntity<>("Question 2-2 Response Received. Skin Type: " + skinType2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 2-2 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question3-1")
    public ResponseEntity<String> receiveQuestion3_1Response(@RequestBody Map<String, Integer> responseMap) {
        question3_1Response = responseMap.get("question3-1Response");

        if (question3_1Response != null) {
            // question1Response 변수에 사용자의 1-1번 질문 응답이 저장됩니다.
            // 사용자의 응답은 저장만 하고 아직 진단은 하지 않음
            return new ResponseEntity<>("Question 3-1 Response Received", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 3-1 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question3-2")
    public ResponseEntity<String> receiveQuestion3_2Response(@RequestBody Map<String, Integer> responseMap) {
        question3_2Response = responseMap.get("question3-2Response");

        if (question3_2Response != null) {

            skinType3 = skinTypeTestService.diagnoseSkinType3(question3_1Response, question3_2Response);
            userService.updateUserSkinType("사용자 아이디", skinType3);

            // 결과 반환 또는 다른 작업 수행
            return new ResponseEntity<>("Question 3-2 Response Received. Skin Type: " + skinType3, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 3-2 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question4-1")
    public ResponseEntity<String> receiveQuestion4_1Response(@RequestBody Map<String, Integer> responseMap) {
        question4_1Response = responseMap.get("question4-1Response");

        if (question4_1Response != null) {
            // question1Response 변수에 사용자의 1-1번 질문 응답이 저장됩니다.
            // 사용자의 응답은 저장만 하고 아직 진단은 하지 않음
            return new ResponseEntity<>("Question 4-1 Response Received", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Question 4-1 Response", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/question4-2")
    public ResponseEntity<String> receiveQuestion4_2Response(@RequestBody Map<String, Integer> responseMap) {
        question4_2Response = responseMap.get("question4-2Response");

        if (question4_2Response != null) {
            skinType4 = skinTypeTestService.diagnoseSkinType4(question4_1Response, question4_2Response);
            String combinedSkinType = combineSkinTypes(skinType1, skinType2, skinType3, skinType4);

            // combinedSkinType 값이 있을 때 반환
            if (combinedSkinType != null) {
                // 스킨테스트 완료 후 사용자 아이디를 LoggedInUserHolder 빈에서 가져와서 업데이트
                String loggedInUserId = loggedInUserHolder.getLoggedInUserId();
                userService.updateUserSkinType(loggedInUserId, combinedSkinType);

                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(combinedSkinType);
            } else {
                return new ResponseEntity<>("Invalid Response", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid Question 4-2 Response", HttpStatus.BAD_REQUEST);
        }
    }

    private String combineSkinTypes(String skinType1, String skinType2, String skinType3, String skinType4) {

        return skinType1 + skinType2 + skinType3 + skinType4;
    }
}
