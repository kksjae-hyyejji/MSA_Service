package shop.msa.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.msa.user.controller.request.UserLoginRequest;
import shop.msa.user.controller.request.UserRegistRequest;
import shop.msa.user.domain.Salt;
import shop.msa.user.domain.User;
import shop.msa.user.domain.value.Address;
import shop.msa.user.exception.CustomException;
import shop.msa.user.exception.ErrorCode;
import shop.msa.user.service.cqrs.UserCommandPort;
import shop.msa.user.service.cqrs.UserQueryPort;
import shop.msa.user.util.JwtUtil;
import shop.msa.user.util.PasswordUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordUtil passwordUtil;
    private final JwtUtil jwtUtil;
    private final UserCommandPort userCommandPort;
    private final UserQueryPort userQueryPort;

    @Transactional
    public void regist(UserRegistRequest request) {

        if (userQueryPort.existsByLoginId(request.getLoginId())) {
            throw new CustomException(ErrorCode.DUPLICATE_USER);
        }

        Address address = Address.create(request.getCity(), request.getStreet(), request.getZipcode(), request.getDetailedAddress());
        Salt salt = passwordUtil.getSalt();
        String encryptPassword = passwordUtil.getEncryptedPassword(request.getPassword(), salt.getSalt());
        User user = User.createUser(request.getLoginId(), encryptPassword, request.getPhoneNumber(), salt, address);

        userCommandPort.save(user);
    }

    public String login(UserLoginRequest userLoginRequest) {

        User user = userQueryPort.findByLoginId(userLoginRequest.getLoginId())
                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_LOGIN));

        String password = passwordUtil.getEncryptedPassword(userLoginRequest.getPassword(), user.getSalt().getSalt());
        if (!password.equals(user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_LOGIN);
        }

        // Role은 추후 세팅하고 변경하며, expire는 환경 변수로 분리 예정.
        String token = jwtUtil.createJwt(user.getLoginId(), "Normal", 30L * 24 * 60 * 60 * 1000);
        return token;
    }
}
