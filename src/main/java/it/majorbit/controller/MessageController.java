package it.majorbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import it.majorbit.model.MessageModel;
import it.majorbit.util.UserStorage;

@RestController
@CrossOrigin
public class MessageController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("chat/{to}")

	public void sendMessage(@DestinationVariable String to, MessageModel message) {
		System.out.println("Trasferendo il messaggio: " + message + "to: " + to);
		boolean isExists = UserStorage.getInstance().getUsers().contains(to);
		if (isExists) {

			simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);

		}

	}

}
