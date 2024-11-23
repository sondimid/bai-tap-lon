package com.example.btnjava.ChatRoom;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String chatId;

    private Integer senderId;

    private Integer recipientId;

    private String content;

    private LocalDateTime timestamp;
}
