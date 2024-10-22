package shop.msa.user.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.msa.user.response.CommonResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CommonResponse> handleCustomException(CustomException e, HttpServletRequest request) {

        log.info("Exception URL: {} " ,request.getRequestURL().toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(CommonResponse.builder().message(e.getMessage()).build());

    }
}
