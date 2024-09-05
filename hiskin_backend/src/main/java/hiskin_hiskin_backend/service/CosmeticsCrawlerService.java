package hiskin_hiskin_backend.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CosmeticsCrawlerService {
    public Map<String, String> scrapeProductInfo(String searchKeyword) {
        // Selenium WebDriver 설정
        System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--port=12345"); // 12345 포트로 변경
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        Map<String, String> productInfo = null;
        try {
            // 올리브영 사이트 열기
            driver.get("https://www.oliveyoung.co.kr/store/main/main.do?oy=0");

            // 검색어 입력
            WebElement searchBox = driver.findElement(By.id("query"));
            searchBox.sendKeys(searchKeyword);

            // 검색 버튼 클릭
            WebElement searchButton = driver.findElement(By.id("searchSubmit"));
            searchButton.click();

            // 1위 상품 정보 가져오기
            WebElement topProductElement = driver.findElement(By.cssSelector("#w_cate_prd_list .prd_info"));
            String productName = topProductElement.findElement(By.cssSelector(".tx_name")).getText();
            String imageUrl = topProductElement.findElement(By.cssSelector(".prd_thumb img")).getAttribute("src");

            // 정규표현식을 사용하여 "[ ]" 부분 제거
            productName = productName.replaceAll("\\[.*?\\]", "").trim();

            // JSON 형식으로 데이터 구성
            productInfo = new HashMap<>();
            productInfo.put("productName", productName);
            productInfo.put("imageUrl", imageUrl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // WebDriver 종료
        }

        return productInfo; // productInfo를 반환
    }
}
