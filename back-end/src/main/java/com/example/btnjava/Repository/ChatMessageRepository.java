package com.example.btnjava.Repository;

import com.example.btnjava.ChatRoom.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {
    List<ChatMessage> findByChatId(String chatId);
}
