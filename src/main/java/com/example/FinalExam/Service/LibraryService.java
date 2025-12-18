package com.example.FinalExam.Service;

import com.example.FinalExam.Dto.LibraryDto;

import java.util.List;

public interface LibraryService {

    List<LibraryDto> getAll();

    LibraryDto getById(Long id);

    LibraryDto addLibrary(LibraryDto libraryDto);

    LibraryDto updateLibrary(Long id, LibraryDto libraryDto);
}
