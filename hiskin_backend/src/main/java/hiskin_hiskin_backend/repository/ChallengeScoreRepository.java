package hiskin_hiskin_backend.repository;

import hiskin_hiskin_backend.domain.ChallengeScore;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface ChallengeScoreRepository extends JpaRepository<ChallengeScore, Long> {
    List<ChallengeScore> findByUserIdAndDateOrderByDateDesc(String userId, LocalDate date);

    List<ChallengeScore> findByUserIdOrderByDateDesc(String userId, Pageable pageable);

}
