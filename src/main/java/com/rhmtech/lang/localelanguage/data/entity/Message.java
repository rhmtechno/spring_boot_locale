package com.rhmtech.lang.localelanguage.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "messages")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_key", nullable = false)
    private String messageKey;

    @Column(name = "locale", nullable = false)
    private String locale;

    @Column(name = "message_value", nullable = false)
    private String messageValue;
}