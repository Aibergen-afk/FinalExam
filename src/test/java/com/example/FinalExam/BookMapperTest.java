package com.example.FinalExam;

import com.example.FinalExam.Dto.BookDto;
import com.example.FinalExam.Mapper.BookMapper;
import com.example.FinalExam.Model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void convertEntityToDtoTest() {
        Book book = new Book(1L, "JAVA", "Java Programming");

        BookDto dto = bookMapper.toDto(book);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(book.getId(), dto.getId());
        Assertions.assertEquals(book.getCode(), dto.getDtoCode());
        Assertions.assertEquals(book.getName(), dto.getName());
    }

    @Test
    void convertDtoToEntityTest() {
        BookDto dto = new BookDto(2L, "SQL", "Database Management");

        Book book = bookMapper.toEntity(dto);

        Assertions.assertNotNull(book);
        Assertions.assertEquals(dto.getId(), book.getId());
        Assertions.assertEquals(dto.getDtoCode(), book.getCode());
        Assertions.assertEquals(dto.getName(), book.getName());
    }
}
