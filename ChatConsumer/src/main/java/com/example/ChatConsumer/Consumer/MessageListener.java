package com.example.ChatConsumer.Consumer;

import com.example.ChatConsumer.Model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageListener {
	
	@KafkaListener(topics = "chat-msg" , groupId = "chats")
	public void listen(Message msg) throws Exception{

		try {
			log.info("Received msg from" + msg.getSender() + ":" + msg.getContent());
		}catch (Exception e){
			throw new RuntimeException();
		}
	}
}