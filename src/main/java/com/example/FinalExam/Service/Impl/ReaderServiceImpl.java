package com.example.FinalExam.Service.Impl;

import com.example.FinalExam.Dto.ReaderDto;
import com.example.FinalExam.Mapper.ReaderMapper;
import com.example.FinalExam.Model.Reader;
import com.example.FinalExam.Repository.ReaderRepository;
import com.example.FinalExam.Service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {

    private final ReaderMapper readerMapper;
    private final ReaderRepository readerRepository;

    @Override
    public List<ReaderDto> getAll() {
        return readerMapper.toDtoList(readerRepository.findAll());
    }

    @Override
    public ReaderDto getById(Long id) {
        return readerRepository.findById(id)
                .map(readerMapper::toDto)
                .orElse(null);
    }

    @Override
    public ReaderDto addReader(ReaderDto readerDto) {
        Reader reader = readerMapper.toEntity(readerDto);
        Reader savedReader = readerRepository.save(reader);
        return readerMapper.toDto(savedReader);
    }

    @Override
    public ReaderDto updateReader(Long id, ReaderDto readerDto) {
        if (!readerRepository.existsById(id)) {
            return null;
        }

        Reader reader = readerMapper.toEntity(readerDto);
        reader.setId(id);
        reader.setName(readerDto.getName());
        reader.setReaderBio(readerDto.getDtoBio());
        reader.setAge(readerDto.getAge());
        reader.setLibrary(readerDto.getLibrary());
        reader.setBooks(readerDto.getBooks());

        Reader updatedReader = readerRepository.save(reader);
        return readerMapper.toDto(updatedReader);
    }

    @Override
    public boolean deleteReader(Long id) {
        if (!readerRepository.existsById(id)) {
            return false;
        }
        readerRepository.deleteById(id);
        return true;
    }
}
