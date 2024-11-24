package com.example.btnjava.Service.Implement;

import com.example.btnjava.ChatRoom.ChatMessage;
import com.example.btnjava.Repository.ChatMessageRepository;
import com.example.btnjava.Service.ChatMessageService;
import com.example.btnjava.Service.ChatRoomService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId());
        chatMessage.setChatId(chatId);
        LocalDateTime vietnamTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        chatMessage.setTimestamp(vietnamTime);
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessage(Integer senderId, Integer recipientId) {
        String chatId = chatRoomService.getChatRoomId(senderId, recipientId);
        return chatMessageRepository.findByChatId(chatId);
    }

    @Override
    public LocalDateTime getLeastTime(Integer senderId, Integer recipientId) {
        List<ChatMessage> chatMessages = findChatMessage(senderId, recipientId);
        return chatMessages.getLast().getTimestamp();
    }

    @Override
    public String getLeastMessage(Integer senderId, Integer recipientId) {
        List<ChatMessage> chatMessages = findChatMessage(senderId, recipientId);
        return chatMessages.getLast().getContent();
    }
}
