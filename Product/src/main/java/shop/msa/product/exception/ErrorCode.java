package shop.msa.product.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_CATEGORY(HttpStatus.CONFLICT, "중복된 카테고리 등록입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    NON_EXISTENT_PARENT(HttpStatus.BAD_REQUEST, "존재하지 않는 부모입니다.");

    private final HttpStatus status;
    private final String message;

}
