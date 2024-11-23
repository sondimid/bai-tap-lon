package com.example.btnjava.Service.Implement;

import com.example.btnjava.ChatRoom.ChatRoom;
import com.example.btnjava.Repository.ChatRoomRepository;
import com.example.btnjava.Service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public String getChatRoomId(Integer senderId, Integer recipientId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        if(chatRoom.isPresent()) {
            return chatRoom.get().getChatId();
        }
        else{
            return createChatRoom(senderId, recipientId);
        }
    }
    public String createChatRoom(Integer senderId, Integer recipientId) {
        String chatId = String.format("%s_%s", senderId, recipientId);
        ChatRoom chatRoomRecipient = ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();
        ChatRoom chatRoomSender = ChatRoom.builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();
        chatRoomRepository.save(chatRoomSender);
        chatRoomRepository.save(chatRoomRecipient);
        return chatId;
    }
}
