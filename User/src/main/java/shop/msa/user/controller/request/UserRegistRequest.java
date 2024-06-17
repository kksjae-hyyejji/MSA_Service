package shop.msa.user.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRegistRequest {

    @NotBlank(message = "loginId 필수")
    private String loginId;
    @NotBlank(message = "password 필수")
    private String password;
    private String phoneNumber;
    private String city;
    private String street;
    private String zipcode;
    private String detailedAddress;

}
