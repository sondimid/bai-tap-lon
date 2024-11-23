package com.example.btnjava.Service.Implement;

import com.example.btnjava.ChatRoom.ChatMessage;
import com.example.btnjava.Repository.ChatMessageRepository;
import com.example.btnjava.Service.ChatMessageService;
import com.example.btnjava.Service.ChatRoomService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId()
                ,chatMessage.getRecipientId());
        chatMessage.setChatId(chatId);
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessage(Integer senderId, Integer recipientId) {
        String chatId = chatRoomService.getChatRoomId(senderId, recipientId);
        return chatMessageRepository.findByChatId(chatId);
    }
}
