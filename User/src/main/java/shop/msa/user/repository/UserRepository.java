package shop.msa.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shop.msa.user.domain.User;
import shop.msa.user.service.cqrs.UserCommandPort;
import shop.msa.user.service.cqrs.UserQueryPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepository implements UserCommandPort, UserQueryPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean existsByLoginId(String loginId) {
        return userJpaRepository.existsByLoginId(loginId);
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        return userJpaRepository.findByLoginId(loginId);
    }

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }
}
