package hiskin_hiskin_backend.repository;

import hiskin_hiskin_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);

    @Modifying
    @Query("UPDATE User u SET u.skinType = :skinType WHERE u.userId = :userId")
    void updateSkinType(@Param("userId") String userId, @Param("skinType") String skinType);
}
