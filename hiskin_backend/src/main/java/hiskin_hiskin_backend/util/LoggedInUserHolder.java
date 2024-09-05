package hiskin_hiskin_backend.util;

import org.springframework.stereotype.Component;

@Component
public class LoggedInUserHolder {
    private String loggedInUserId;

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }
}
