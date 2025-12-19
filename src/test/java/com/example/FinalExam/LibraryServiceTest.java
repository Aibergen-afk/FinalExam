package com.example.FinalExam;

import com.example.FinalExam.Dto.LibraryDto;
import com.example.FinalExam.Service.LibraryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class LibraryServiceTest {

    @Autowired
    private LibraryService libraryService;

    @Test
    void getAllTest() {
        List<LibraryDto> list = libraryService.getAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        for (LibraryDto dto : list) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getDtoName());
        }
    }

    @Test
    void getByIdTest() {
        List<LibraryDto> all = libraryService.getAll();
        if (all.isEmpty()) return;

        Random random = new Random();
        Long id = all.get(random.nextInt(all.size())).getId();
        LibraryDto dto = libraryService.getById(id);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(id, dto.getId());
    }

    @Test
    void addLibraryTest() {
        LibraryDto dto = new LibraryDto();
        dto.setDtoName("New Library");

        LibraryDto created = libraryService.addLibrary(dto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(dto.getDtoName(), created.getDtoName());

        LibraryDto found = libraryService.getById(created.getId());
        Assertions.assertEquals(found.getDtoName(), created.getDtoName());
    }

    @Test
    void updateLibraryTest() {
        LibraryDto dto = new LibraryDto();
        dto.setDtoName("Temp Library");

        LibraryDto created = libraryService.addLibrary(dto);

        LibraryDto updateDto = new LibraryDto();
        updateDto.setDtoName("Updated Library");

        LibraryDto updated = libraryService.updateLibrary(created.getId(), updateDto);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals("Updated Library", updated.getDtoName());

        LibraryDto found = libraryService.getById(created.getId());
        Assertions.assertEquals("Updated Library", found.getDtoName());
    }
}
