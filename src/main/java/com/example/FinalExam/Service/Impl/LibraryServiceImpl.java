package com.example.FinalExam.Service.Impl;

import com.example.FinalExam.Dto.LibraryDto;
import com.example.FinalExam.Mapper.LibraryMapper;
import com.example.FinalExam.Model.Library;
import com.example.FinalExam.Repository.LibraryRepository;
import com.example.FinalExam.Service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryMapper libraryMapper;
    private final LibraryRepository libraryRepository;

    @Override
    public List<LibraryDto> getAll() {
        return libraryMapper.toDtoList(libraryRepository.findAll());
    }

    @Override
    public LibraryDto getById(Long id) {
        return libraryMapper.toDto(libraryRepository.findById(id).orElseThrow());
    }

    @Override
    public LibraryDto addLibrary(LibraryDto libraryDto) {
        Library library = libraryMapper.toEntity(libraryDto);
        Library saved = libraryRepository.save(library);
        return libraryMapper.toDto(saved);
    }

    @Override
    public LibraryDto updateLibrary(Long id, LibraryDto libraryDto) {
        Library library = libraryMapper.toEntity(libraryDto);
        library.setId(id);
        library.setName(libraryDto.getDtoName());
        Library updated = libraryRepository.save(library);
        return libraryMapper.toDto(updated);
    }
}
