package shop.msa.order.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import shop.msa.order.domain.event.OrderCreateEvent;
import shop.msa.order.service.KafkaConsumerService;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${consumer.topic1.name}", groupId = "${consumer.groupid.name}")
    @Override
    public void consumeOrderCreateEvent(ConsumerRecord<String, String> record) throws JsonProcessingException {

        log.info("consume order create event: {}", record.value());
        OrderCreateEvent event = objectMapper.readValue(record.value(), OrderCreateEvent.class);

    }
}
