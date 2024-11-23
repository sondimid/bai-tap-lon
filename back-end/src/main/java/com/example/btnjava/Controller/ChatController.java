package com.example.btnjava.Controller;

import com.example.btnjava.ChatRoom.ChatMessage;
import com.example.btnjava.ChatRoom.ChatNotification;
import com.example.btnjava.Service.ChatMessageService;
import com.example.btnjava.Service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ChatController {
    private final ChatMessageService chatMessageService;
//    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    public void processMessage(@Payload ChatMessage chatMessage) {
        chatMessageService.save(chatMessage);
    }
    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<?> findChatMessages(@PathVariable("senderId") Integer senderId,
                                                              @PathVariable("recipientId") Integer recipientId) {
        return ResponseEntity.ok().body(chatMessageService.findChatMessage(senderId, recipientId));
    }
}
