package com.example.FinalExam.Service;

import com.example.FinalExam.Dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getById(Long id);

    BookDto addBook(BookDto bookDto);

    BookDto updateBook(Long id, BookDto bookDto);
}
