package shop.msa.product.service;

import shop.msa.product.controller.request.OrderProductRequest;

import java.util.List;

public interface KafkaProducerService {

    void occurOrderCreateEvent(String username, List<OrderProductRequest> orders);
}
