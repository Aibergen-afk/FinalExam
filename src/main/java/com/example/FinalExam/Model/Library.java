package com.example.FinalExam.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
