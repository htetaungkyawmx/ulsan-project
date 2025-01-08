package org.mdt.ulsanproject.exception;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class DroneWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming message here
        System.out.println("Received message: " + message.getPayload());

        // Respond to the client
        session.sendMessage(new TextMessage("Response from server: " + message.getPayload()));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Handle new connection establishment
        System.out.println("New connection established: " + session.getId());
    }
}
