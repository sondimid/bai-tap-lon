package com.example.btnjava.Service;

import com.example.btnjava.ChatRoom.ChatMessage;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatMessageService {
    ChatMessage save(ChatMessage chatMessage);
    List<ChatMessage> findChatMessage(Integer senderId, Integer recipientId);
    LocalDateTime getLeastTime(Integer senderId, Integer recipientId);
    String getLeastMessage(Integer senderId, Integer recipientId);

}
