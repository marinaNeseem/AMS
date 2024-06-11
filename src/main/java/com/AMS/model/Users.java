package com.AMS.model;

import com.AMS.Enums.Type;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String user_name;

    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    public Users(String user_name, String email, String password, Type type) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.type = type;
    }
}
