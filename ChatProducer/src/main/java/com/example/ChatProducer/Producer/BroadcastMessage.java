package com.example.ChatProducer.Producer;

import com.example.ChatProducer.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public class BroadcastMessage {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void broadcastMessage(Message msg){
        kafkaTemplate.send(msg.getChatGrp(),msg);

//        CompletableFuture<SendResult<String, Message>> future = kafkaTemplate.send(msg.getChatGrp(),msg);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Sent message=[" + msg +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" +
//                        msg + "] due to : " + ex.getMessage());
//            }
//        });
    }
}
