package com.example.FinalExam;

import com.example.FinalExam.Dto.ReaderDto;
import com.example.FinalExam.Mapper.ReaderMapper;
import com.example.FinalExam.Model.Book;
import com.example.FinalExam.Model.Library;
import com.example.FinalExam.Model.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ReaderMapperTest {

    @Autowired
    private ReaderMapper readerMapper;

    @Test
    void convertEntityToDtoTest() {
        Library library = new Library();
        library.setId(1L);
        library.setName("IT");

        Book book1 = new Book(1L, "JAVA", "Java Programming");
        Book book2 = new Book(2L, "SQL", "Database Management");
        Set<Book> books = Set.of(book1, book2);

        Reader reader = new Reader();
        reader.setId(1L);
        reader.setName("Aibergen");
        reader.setAge(19);
        reader.setReaderBio("Male");
        reader.setLibrary(library);
        reader.setBooks(books);

        ReaderDto dto = readerMapper.toDto(reader);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getName());
        Assertions.assertNotNull(dto.getAge());
        Assertions.assertNotNull(dto.getDtoBio());
        Assertions.assertNotNull(dto.getLibrary());
        Assertions.assertNotNull(dto.getBooks());

        Assertions.assertEquals(reader.getId(), dto.getId());
        Assertions.assertEquals(reader.getName(), dto.getName());
        Assertions.assertEquals(reader.getAge(), dto.getAge());
        Assertions.assertEquals(reader.getReaderBio(), dto.getDtoBio());
        Assertions.assertEquals(reader.getLibrary(), dto.getLibrary());
        Assertions.assertEquals(reader.getBooks(), dto.getBooks());
    }

    @Test
    void convertDtoToEntityTest() {
        Library library = new Library();
        library.setId(1L);
        library.setName("IT");

        Book book1 = new Book(1L, "JAVA", "Java Programming");
        Book book2 = new Book(2L, "SQL", "Database Management");
        Set<Book> books = Set.of(book1, book2);

        ReaderDto dto = new ReaderDto(1L, "Aibergen", 19, "Yes", library, books);

        Reader reader = readerMapper.toEntity(dto);

        Assertions.assertNotNull(reader);
        Assertions.assertNotNull(reader.getId());
        Assertions.assertNotNull(reader.getName());
        Assertions.assertNotNull(reader.getAge());
        Assertions.assertNotNull(reader.getReaderBio());
        Assertions.assertNotNull(reader.getLibrary());
        Assertions.assertNotNull(reader.getBooks());

        Assertions.assertEquals(dto.getId(), reader.getId());
        Assertions.assertEquals(dto.getName(), reader.getName());
        Assertions.assertEquals(dto.getAge(), reader.getAge());
        Assertions.assertEquals(dto.getDtoBio(), reader.getReaderBio());
        Assertions.assertEquals(dto.getLibrary(), reader.getLibrary());
        Assertions.assertEquals(dto.getBooks(), reader.getBooks());
    }
}
