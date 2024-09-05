package hiskin_hiskin_backend.service;

import hiskin_hiskin_backend.domain.User;
import hiskin_hiskin_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void updateUserSkinType(String userId, String skinType) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            user.setSkinType(skinType);
            userRepository.save(user);
        }
    }

    public String getUserSkinType(String userId) {
        User user = userRepository.findByUserId(userId);
        return user != null ? user.getSkinType() : null;
    }

    public void updateChallengeScore(String userId, int challengeScore) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            user.setChallengeScore(challengeScore);
            userRepository.save(user);
        }
    }
}
