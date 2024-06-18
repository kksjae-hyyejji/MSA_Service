package shop.msa.product.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shop.msa.product.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class CategoryResponse {

    private Long id;

    private String name;

    private Long parentId;

    private int depth;

    private List<CategoryResponse> child = new ArrayList<>();

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getParent() != null ? category.getParent().getId() : null,
                category.getDepth(),
                category.getChilds()
                        .stream()
                        .map(CategoryResponse::of)
                        .collect(Collectors.toList())
        );
    }
};
