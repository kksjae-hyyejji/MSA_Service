package shop.msa.user.domain.value;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String city;
    private String street;
    private String zipcode;
    private String detailedAddress;

    public Address(String city, String street, String zipcode, String detailedAddress) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.detailedAddress = detailedAddress;
    }
}
