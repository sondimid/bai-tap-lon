package com.example.btnjava.ChatRoom;

import com.example.btnjava.Model.Entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ChatRoom extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String chatId;

    private Integer senderId;

    private Integer recipientId;

}
