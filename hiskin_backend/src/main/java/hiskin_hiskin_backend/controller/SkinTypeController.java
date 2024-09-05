package hiskin_hiskin_backend.controller;

import hiskin_hiskin_backend.service.UserService;
import hiskin_hiskin_backend.util.LoggedInUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SkinTypeController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoggedInUserHolder loggedInUserHolder;

    @GetMapping("/skinType")
    public ResponseEntity<String> getUserSkinType() {
        // 로그인한 사용자의 ID를 가져옵니다.
        String loggedInUserId = loggedInUserHolder.getLoggedInUserId();

        // 데이터베이스에서 사용자의 피부 타입을 검색합니다.
        String userSkinType = userService.getUserSkinType(loggedInUserId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userSkinType);
    }
}
