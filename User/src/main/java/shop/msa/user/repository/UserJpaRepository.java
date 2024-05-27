package shop.msa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.msa.user.domain.User;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(String loginId);
    Optional<User> findByLoginId(String loginId);
}
