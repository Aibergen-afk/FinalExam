package com.example.FinalExam.Mapper;

import com.example.FinalExam.Dto.LibraryDto;
import com.example.FinalExam.Model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    @Mapping(target = "dtoName", source = "name")
    LibraryDto toDto(Library library);

    @Mapping(target = "name", source = "dtoName")
    Library toEntity(LibraryDto libraryDto);

    List<LibraryDto> toDtoList(List<Library> libraryEntityList);
}
