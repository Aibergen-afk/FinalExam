package com.example.FinalExam.Service;

import com.example.FinalExam.Dto.ReaderDto;

import java.util.List;

public interface ReaderService {

    List<ReaderDto> getAll();

    ReaderDto getById(Long id);

    ReaderDto addReader(ReaderDto readerDto);

    ReaderDto updateReader(Long id, ReaderDto readerDto);

    boolean deleteReader(Long id);
}
