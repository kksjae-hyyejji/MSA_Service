package shop.msa.user.util;

import io.jsonwebtoken.ExpiredJwtException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JwtUtilTest {

    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        String secret = "test_secret_keytest_secret_keytest_secret_keytest_secret_key";
        jwtUtil = new JwtUtil(secret);
    }

    @Test
    @DisplayName("발급한 jwt의 username, 만료 기간이 정상적으로 세팅되는지 확인한다.")
    void extractInfoFromJwt() {
        String token = jwtUtil.createJwt("test","yet", 30L * 24 * 60 * 60 * 1000);
        assertThat("test").isEqualTo(jwtUtil.getUsername(token));
        assertThat(jwtUtil.isExpired(token)).isFalse();
    }

    @Test
    @DisplayName("만료기간이 지난 jwt는 ExpiredJwtException 예외를 던진다.")
    void checkExpiredDate() {
        String token = jwtUtil.createJwt("test","yet", 0L);
        assertThrows(ExpiredJwtException.class, () -> jwtUtil.isExpired(token));
    }
}