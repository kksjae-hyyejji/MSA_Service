package shop.msa.product.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.Map;

@Getter
@NoArgsConstructor
public class CommonResponse {

    private String message;

    @Singular("data")
    private Map<String, Object> data;

    @Builder
    public CommonResponse(String message, Map<String, Object> data) {
        this.message = message;
        this.data = data;
    }
}
