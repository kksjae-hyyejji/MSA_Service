package shop.msa.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.msa.user.controller.request.UserLoginRequest;
import shop.msa.user.controller.request.UserRegistRequest;
import shop.msa.user.response.CommonResponse;
import shop.msa.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @PostMapping("/regist")
    public ResponseEntity<CommonResponse> regist(@Valid @RequestBody UserRegistRequest userRegistRequest) {

        userService.regist(userRegistRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .message("회원가입 완료").build());
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@Valid @RequestBody UserLoginRequest userLoginRequest) {

        userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .message("로그인 완료").build());

    }

}
