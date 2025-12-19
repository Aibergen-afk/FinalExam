package com.example.FinalExam.Mapper;

import com.example.FinalExam.Dto.BookDto;
import com.example.FinalExam.Model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "dtoCode", source = "code")
    BookDto toDto(Book book);

    @Mapping(target = "code", source = "dtoCode")
    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> bookEntityList);
}
