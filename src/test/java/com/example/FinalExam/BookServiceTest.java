package com.example.FinalExam;

import com.example.FinalExam.Dto.BookDto;
import com.example.FinalExam.Service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getAllTest() {
        List<BookDto> list = bookService.getAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        for (BookDto dto : list) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getName());
            Assertions.assertNotNull(dto.getDtoCode());
        }
    }

    @Test
    void getByIdTest() {
        List<BookDto> all = bookService.getAll();
        if (all.isEmpty()) return;

        Random random = new Random();
        Long id = all.get(random.nextInt(all.size())).getId();

        BookDto dto = bookService.getById(id);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(id, dto.getId());
        Assertions.assertThrows(Exception.class, () -> bookService.getById(-1L));
    }

    @Test
    void addBookTest() {
        BookDto dto = new BookDto();
        dto.setDtoCode("PY");
        dto.setName("Python Programming");

        BookDto created = bookService.addBook(dto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(dto.getName(), created.getName());
        Assertions.assertEquals(dto.getDtoCode(), created.getDtoCode());

        BookDto found = bookService.getById(created.getId());
        Assertions.assertEquals(found.getName(), created.getName());
    }

    @Test
    void updateBookTest() {
        BookDto dto = new BookDto();
        dto.setDtoCode("JS");
        dto.setName("JavaScript");

        BookDto created = bookService.addBook(dto);

        BookDto updateDto = new BookDto();
        updateDto.setDtoCode("JSX");
        updateDto.setName("JavaScript Updated");

        BookDto updated = bookService.updateBook(created.getId(), updateDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals("JSX", updated.getDtoCode());
        Assertions.assertEquals("JavaScript Updated", updated.getName());

        BookDto found = bookService.getById(created.getId());
        Assertions.assertEquals("JavaScript Updated", found.getName());
    }
}
