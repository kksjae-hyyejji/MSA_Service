package shop.msa.product.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import shop.msa.product.controller.request.OrderProductRequest;
import shop.msa.product.domain.event.OrderCreateEvent;
import shop.msa.product.service.KafkaProducerService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Value("${producers.topic1.name}")
    private String TOPIC_ORDER;

    private final KafkaTemplate<String, OrderCreateEvent> kafkaTemplate;

    @Override
    public void occurOrderCreateEvent(String username, List<OrderProductRequest> orders) {

        OrderCreateEvent event = new OrderCreateEvent(username, orders);
        CompletableFuture<SendResult<String, OrderCreateEvent>> future = kafkaTemplate.send(TOPIC_ORDER, event);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                RecordMetadata metadata = result.getRecordMetadata();
                OrderCreateEvent e = result.getProducerRecord().value();
                log.info("Sent create order message by {}, with offset = {} ", e.getUsername(), metadata.offset());
            } else {
                log.error("Unable to send create order message by {}, due to : {}", event.getUsername(), ex.getMessage());
            }
        });
    }
}
