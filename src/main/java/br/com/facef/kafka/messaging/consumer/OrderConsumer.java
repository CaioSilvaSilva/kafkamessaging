package br.com.facef.kafka.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {
  @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(String order) {
    log.info("Order: " + order);
  }
}
