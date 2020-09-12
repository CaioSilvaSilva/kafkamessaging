package br.com.facef.kafka.messaging.producer;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

  @Value("${order.topic}")
  private String orderTopic;

  @Autowired
  private KafkaTemplate kafkaTemplate;

  public void sendToTopic(String order) {
    final var key = UUID.randomUUID().toString();
    this.kafkaTemplate.send(this.orderTopic, key, order);
  }
}
