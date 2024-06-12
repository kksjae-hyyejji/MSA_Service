package shop.msa.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_USER(HttpStatus.CONFLICT, "Duplicate User"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    INVALID_LOGIN(HttpStatus.UNAUTHORIZED, "id 또는 password가 일치하지 않습니다.");

    private final HttpStatus status;
    private final String message;

}
