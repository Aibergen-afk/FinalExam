package com.example.FinalExam;

import com.example.FinalExam.Dto.LibraryDto;
import com.example.FinalExam.Mapper.LibraryMapper;
import com.example.FinalExam.Model.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibraryMapperTest {

    @Autowired
    private LibraryMapper libraryMapper;

    @Test
    void convertEntityToDtoTest() {
        Library library = new Library();
        library.setId(1L);
        library.setName("IT");

        LibraryDto libraryDto = libraryMapper.toDto(library);

        Assertions.assertNotNull(libraryDto);
        Assertions.assertEquals(library.getId(), libraryDto.getId());
        Assertions.assertEquals(library.getName(), libraryDto.getDtoName());
    }

    @Test
    void convertDtoToEntityTest() {
        LibraryDto libraryDto = new LibraryDto(2L, "Finance");

        Library library = libraryMapper.toEntity(libraryDto);

        Assertions.assertNotNull(library);
        Assertions.assertEquals(libraryDto.getId(), library.getId());
        Assertions.assertEquals(libraryDto.getDtoName(), library.getName());
    }
}
