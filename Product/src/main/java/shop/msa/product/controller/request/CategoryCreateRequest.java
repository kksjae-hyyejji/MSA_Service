package shop.msa.product.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import shop.msa.product.service.request.CategoryServiceCreateRequest;

@Getter
public class CategoryCreateRequest {

    private Long parentId;

    @NotBlank(message = "카테고리 이름은 필수")
    private String name;

    public CategoryCreateRequest(Long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }

    public CategoryServiceCreateRequest toServiceRequest() {

        return new CategoryServiceCreateRequest(parentId, name);
    }
}
