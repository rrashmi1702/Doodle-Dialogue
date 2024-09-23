package com.example.dd.dd.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data // Automatically adds @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Custom constructor (optional, if needed)
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    public User getName() {
//    }
}

enum UserRole {
    FREELANCER, CLIENT
}
