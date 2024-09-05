package hiskin_hiskin_backend.controller;

import hiskin_hiskin_backend.domain.User;
import hiskin_hiskin_backend.repository.UserRepository;
import hiskin_hiskin_backend.service.CosmeticsCrawlerService;
import hiskin_hiskin_backend.service.UserService;
import hiskin_hiskin_backend.util.LoggedInUserHolder;
import hiskin_hiskin_backend.util.SkinTypeSearchKeywords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CosmeticsController {
    @Autowired
    private CosmeticsCrawlerService cosmeticsCrawlerService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoggedInUserHolder loggedInUserHolder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/cosmetics")
    public ResponseEntity<Map<String, String>> searchCosmetics() {
        try {
            // Get the logged-in user's skin type
            String loggedInUserId = loggedInUserHolder.getLoggedInUserId();
            User user = userRepository.findByUserId(loggedInUserId);

            if (user != null && user.getSkinType() != null) {
                String skinType = user.getSkinType();

                // Get the search keyword based on the user's skin type
                String searchKeyword = SkinTypeSearchKeywords.valueOf(skinType).getKeyword();

                // Use the search keyword to get product information
                Map<String, String> productInfo = cosmeticsCrawlerService.scrapeProductInfo(searchKeyword);

                return new ResponseEntity<>(productInfo, HttpStatus.OK);
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "User not found or skin type not set");
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

/*
selenium 라이브러리 사용방법:
1. 크롬 버전 확인
2. 크롬 버전이랑 일치하는 크롬드라이버 설치
 */
