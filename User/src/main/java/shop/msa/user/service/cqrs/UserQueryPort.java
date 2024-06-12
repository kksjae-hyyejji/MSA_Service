package shop.msa.user.service.cqrs;

import org.springframework.data.jpa.repository.Query;
import shop.msa.user.domain.User;

import java.util.Optional;

public interface UserQueryPort {
    boolean existsByLoginId(String loginId);
    
    @Query("SELECT u FROM User u JOIN FETCH u.salt WHERE u.loginId = :loginId")
    Optional<User> findByLoginId(String loginId);

}
