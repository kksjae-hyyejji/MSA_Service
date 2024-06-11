package shop.msa.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "shop_user_salt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salt_id")
    private Long id;

    private String salt;

    public Salt(String salt) {
        this.salt = salt;
    }
}
