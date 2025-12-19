package com.example.FinalExam.Service.Impl;

import com.example.FinalExam.Dto.BookDto;
import com.example.FinalExam.Mapper.BookMapper;
import com.example.FinalExam.Model.Book;
import com.example.FinalExam.Repository.BookRepository;
import com.example.FinalExam.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public List<BookDto> getAll() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public BookDto getById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow());
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        Book saved = bookRepository.save(book);
        return bookMapper.toDto(saved);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book.setId(id);
        book.setName(bookDto.getName());
        book.setCode(bookDto.getDtoCode());
        Book updated = bookRepository.save(book);
        return bookMapper.toDto(updated);
    }
}
