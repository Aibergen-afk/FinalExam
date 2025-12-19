package com.example.FinalExam.Api;

import com.example.FinalExam.Dto.BookDto;
import com.example.FinalExam.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookApi {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(
            @PathVariable Long id,
            @RequestBody BookDto bookDto
    ) {
        bookService.updateBook(id, bookDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
