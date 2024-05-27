package shop.msa.user.service.cqrs;

public interface UserQueryPort {
    boolean existsByLoginId(String loginId);
}
