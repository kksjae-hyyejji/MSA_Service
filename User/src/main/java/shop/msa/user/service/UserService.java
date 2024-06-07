package shop.msa.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.msa.user.controller.request.UserRegistRequest;
import shop.msa.user.domain.User;
import shop.msa.user.domain.value.Address;
import shop.msa.user.exception.CustomException;
import shop.msa.user.exception.ErrorCode;
import shop.msa.user.service.cqrs.UserCommandPort;
import shop.msa.user.service.cqrs.UserQueryPort;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserCommandPort userCommandPort;
    private final UserQueryPort userQueryPort;

    @Transactional
    public void regist(UserRegistRequest request) {

        if (userQueryPort.existsByLoginId(request.getLoginId())) {
            throw new CustomException(ErrorCode.DUPLICATE_USER);
        }

        Address address = Address.create(request.getCity(), request.getStreet(), request.getZipcode(), request.getDetailedAddress());

        userCommandPort.save(new User(request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                address));

    }
}
