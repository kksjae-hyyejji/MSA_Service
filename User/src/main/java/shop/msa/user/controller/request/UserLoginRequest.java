package shop.msa.user.controller.request;

import lombok.Getter;

@Getter
public class UserLoginRequest {

    private String loginId;
    private String password;
}
