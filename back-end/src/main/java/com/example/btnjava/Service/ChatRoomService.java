package com.example.btnjava.Service;

import java.util.Optional;

public interface ChatRoomService {
    String getChatRoomId(Integer senderId, Integer recipientId);
    String createChatRoom(Integer senderId, Integer recipientId);
}
