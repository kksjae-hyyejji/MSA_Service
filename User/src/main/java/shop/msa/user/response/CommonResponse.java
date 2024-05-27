package shop.msa.user.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
public class CommonResponse {

    private String message;
    private Map<String, Object> data;

    @Builder
    public CommonResponse(String message, Map<String, Object> data) {
        this.message = message;
        this.data = data;
    }
}
