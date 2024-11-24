package com.example.btnjava.Service.Implement;

import com.example.btnjava.ChatRoom.ChatRoom;
import com.example.btnjava.Repository.ChatRoomRepository;
import com.example.btnjava.Service.ChatRoomService;
import com.example.btnjava.Utils.JwtTokenUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final JwtTokenUtils jwtTokenUtils;

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
    public List<Integer> getRecipientIdsBySenderId(Integer id){
        List<ChatRoom> listChatRoom = chatRoomRepository.findAllBySenderId(id).get();
        List<Integer> recipientIds = new ArrayList<>();
        for(ChatRoom chatRoom : listChatRoom){
            if(!Objects.equals(id, chatRoom.getRecipientId()) && chatRoom.getRecipientId()  != null){
                recipientIds.add(chatRoom.getRecipientId());
            }

        }
        return recipientIds;
    }


}
