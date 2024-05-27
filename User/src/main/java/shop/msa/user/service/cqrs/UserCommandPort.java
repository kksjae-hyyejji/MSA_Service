package shop.msa.user.service.cqrs;

import shop.msa.user.domain.User;

public interface UserCommandPort {
    void save(User user);
}
