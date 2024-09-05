package hiskin_hiskin_backend.service;

/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatGPTService {

    // 환경변수 설정 후 진행
    @Value("${my.password}")
    private String apiKey;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate restTemplate;

    public ChatGPTService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> askChatGPT(String question) {
        Map<String, Object> requestBodyMap = new LinkedHashMap<>();
        requestBodyMap.put("model", "gpt-3.5-turbo");

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "system", "content", "You are a helpful assistant."));
        messages.add(Map.of("role", "user", "content", "User: " + question));

        requestBodyMap.put("messages", messages);

        // Converting the request body map to JSON string
        try {
            String requestBody = new ObjectMapper().writeValueAsString(requestBodyMap);

            // Creating HTTP headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            // Creating the HTTP entity with the request body and headers
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            // Making the API call
            String apiUrl = OPENAI_API_URL + "?temperature=0.7";

            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
            String response = responseEntity.getBody();

            // 여기에서 응답을 추출하는 대신 ResponseEntity를 그대로 반환
            return responseEntity;
        } catch (JsonProcessingException e) {
            // JSON 처리 예외 처리
            e.printStackTrace(); // 또는 예외를 로깅
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류: JSON 형식으로 요청 변환 실패");
        } catch (HttpClientErrorException e) {
            // HTTP 클라이언트 오류 처리
            return ResponseEntity.status(e.getRawStatusCode()).body("오류: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            // 기타 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류: " + e.getMessage());
        }
    }
}


 */