package shop.msa.user.util;

import org.springframework.stereotype.Component;
import shop.msa.user.domain.Salt;
import shop.msa.user.exception.CustomException;
import shop.msa.user.exception.ErrorCode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Component
public class PasswordUtil {

    public Salt getSalt() {

        Random random = new Random();
        byte[] salt = new byte[10];
        random.nextBytes(salt);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < salt.length; i++) {
            sb.append(String.format("%02x", salt[i]));
        }
        return new Salt(sb.toString());
    }

    public String getEncryptedPassword(String password, String salt) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password + salt).getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(String.format("%02x", digest[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }


}
