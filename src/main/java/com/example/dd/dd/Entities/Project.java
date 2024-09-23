package com.example.dd.dd.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double budget;

    @ManyToOne
    private User client;

    @OneToMany(mappedBy = "project")
    private List<Bid> bids;
}
