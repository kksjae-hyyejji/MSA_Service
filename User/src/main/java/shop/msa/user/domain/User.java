package shop.msa.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.msa.user.domain.value.Address;

@Entity
@Getter
@Table(name = "user",indexes = @Index(name = "login_id_idx", columnList = "loginId", unique = true))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String loginId;

    private String phoneNumber;

    @Embedded
    private Address address;

    public User(String loginId, String phoneNumber, Address address) {
        this.loginId = loginId;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

}
