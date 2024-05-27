package shop.msa.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.msa.user.controller.request.UserRegistRequest;
import shop.msa.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @PostMapping("/regist")
    public ResponseEntity<?> regist(@Valid @RequestBody UserRegistRequest userRegistRequest) {

        userService.regist(userRegistRequest);

        return ResponseEntity.ok("회원가입 완료");
    }
}
