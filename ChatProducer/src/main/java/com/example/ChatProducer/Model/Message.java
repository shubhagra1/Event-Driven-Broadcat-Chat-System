package com.example.ChatProducer.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

	private String sender;
	private String chatGrp;
	private String content;
	private String time_stamp;
}
