package com.example.FinalExam.Mapper;

import com.example.FinalExam.Dto.ReaderDto;
import com.example.FinalExam.Model.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    @Mapping(target = "dtoBio", source = "readerBio")
    ReaderDto toDto(Reader reader);

    @Mapping(target = "readerBio", source = "dtoBio")
    Reader toEntity(ReaderDto readerDto);

    List<ReaderDto> toDtoList(List<Reader> readerEntityList);
}
