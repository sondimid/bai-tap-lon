package com.example.btnjava.ChatRoom;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
    private Integer id;
    private String content;
    private Integer senderId;
    private Integer recipientId;
}
