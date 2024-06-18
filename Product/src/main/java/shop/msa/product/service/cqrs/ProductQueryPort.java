package shop.msa.product.service.cqrs;

public interface ProductQueryPort {

    boolean existsByName(String name);

}
