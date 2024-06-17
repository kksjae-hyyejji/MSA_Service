package shop.msa.user.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserAddressRequest {

    @NotBlank(message = "유저 Id가 누락")
    private String loginId;
    private String city;
    private String street;
    private String zipcode;
    private String detailedAddress;

}
