package shop.msa.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_USER(HttpStatus.CONFLICT, "Duplicate User");

    private final HttpStatus status;
    private final String message;

}
