package com.example.FinalExam.Dto;

import com.example.FinalExam.Model.Book;
import com.example.FinalExam.Model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {
    private Long id;
    private String name;
    private int age;
    private String dtoBio;
    private Library library;
    private Set<Book> books;
}
