package shop.msa.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {

    void consumeOrderCreateEvent(ConsumerRecord<String, String> record) throws JsonProcessingException;


}
