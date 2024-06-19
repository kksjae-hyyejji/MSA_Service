package shop.msa.product.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_CATEGORY(HttpStatus.CONFLICT, "중복된 카테고리 등록입니다."),
    NON_EXISTENT_PARENT(HttpStatus.BAD_REQUEST, "존재하지 않는 부모입니다."),
    NON_EXISTENT_CATEGORY(HttpStatus.BAD_REQUEST, "존재하지 않는 카테고리입니다."),
    NOT_LOWEST_CATEGORY(HttpStatus.BAD_REQUEST, "최하위 카테고리에만 등록할 수 있습니다."),

    DUPLICATE_PRODUCT(HttpStatus.BAD_REQUEST, "중복된 상품 이름입니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String message;

}
