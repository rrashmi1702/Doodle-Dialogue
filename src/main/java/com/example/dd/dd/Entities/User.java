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
    private String category;
}