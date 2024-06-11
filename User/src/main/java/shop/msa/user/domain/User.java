package shop.msa.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.msa.user.domain.value.Address;

@Entity
@Getter
@Table(name = "shop_user",indexes = @Index(name = "login_id_idx", columnList = "loginId", unique = true))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String loginId;

    private String password;

    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "salt_id")
    private Salt salt;

    @Embedded
    private Address address;

    private User(String loginId, String password, String phoneNumber, Salt salt, Address address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.salt = salt;
        this.address = address;
    }

    public static User createUser(String loginId, String encryptPassword, String phoneNumber, Salt salt, Address address) {
        return new User(loginId, encryptPassword, phoneNumber, salt, address);
    }


}
