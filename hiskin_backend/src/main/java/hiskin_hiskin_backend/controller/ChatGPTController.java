package hiskin_hiskin_backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hiskin_hiskin_backend.dto.ChatRequest;
//import hiskin_hiskin_backend.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatGPTController {
    /*
    @Autowired
    private ChatGPTService chatGPTService;
    @Autowired
    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/ask")
    public ResponseEntity<Map<String, Object>> askChatGPT(@RequestBody ChatRequest chatRequest) {
        String question = chatRequest.getQuestion();

        // ChatGPTService의 askChatGPT 메서드 호출하고 ResponseEntity를 가져오기
        ResponseEntity<String> responseEntity = chatGPTService.askChatGPT(question);

        // 응답에서 "content"를 추출하여 프론트엔드로 반환
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String content = extractContentFromResponse(responseEntity.getBody());

            // JSON 응답으로 변환
            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("content", content);

            return ResponseEntity.ok(jsonResponse);
        } else {
            // API 호출이 성공하지 않은 경우 오류 응답 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", responseEntity.getBody());

            return ResponseEntity.status(responseEntity.getStatusCode()).body(errorResponse);
        }
    }

    private String extractContentFromResponse(String response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);

            // OpenAI API 응답의 실제 구조에 기반하여 수정 필요
            // 예를 들어 응답에 "choices" 필드가 있다면 경로를 조정해야 합니다.
            JsonNode contentNode = jsonNode.at("/choices/0/message/content");

            // JsonNode를 String으로 변환
            return contentNode.asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "오류: 응답에서 content 추출 실패";
        }
    }

     */

    @PostMapping("/test")
    public Map<String, String> ask(@RequestBody Map<String, String> data) {
        // 프론트엔드가 "question" 필드를 가진 JSON 객체로 입력을 보낸다고 가정합니다.
        String userQuestion = data.get("question");

        // 여기서 사용자의 질문을 기반으로 원하는 로직을 수행할 수 있습니다.
        // 간단히 하기 위해 고정된 메시지로 응답합니다.
        String response = "안녕하세요"; // 실제 로직에 맞게 수정하세요.

        // 응답용 JSON 객체 생성
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("content", response);

        return jsonResponse;
    }
}