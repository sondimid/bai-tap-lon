package com.example.btnjava.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ChatRoomService {
    String getChatRoomId(Integer senderId, Integer recipientId);
    String createChatRoom(Integer senderId, Integer recipientId);
    List<Integer> getRecipientIdsBySenderId(Integer id);

}
