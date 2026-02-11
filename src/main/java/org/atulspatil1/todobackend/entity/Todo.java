package org.atulspatil1.todobackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private boolean completed;
}
