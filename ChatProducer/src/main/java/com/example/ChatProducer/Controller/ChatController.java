package com.example.ChatProducer.Controller;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import com.example.ChatProducer.Model.Message;
import com.example.ChatProducer.Producer.BroadcastMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {
	
	@Autowired
	public BroadcastMessage message;
	
	@PostMapping("api/publish")
	public void sendMsg(@RequestBody Message msg) {
		
		msg.setTime_stamp(LocalDateTime.now().toString());

		message.broadcastMessage(msg);
		log.info("Broadcasting msg :"+msg.toString());
		
	}
}
