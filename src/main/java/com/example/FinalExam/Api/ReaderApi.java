package com.example.FinalExam.Api;

import com.example.FinalExam.Dto.ReaderDto;
import com.example.FinalExam.Model.Reader;
import com.example.FinalExam.Repository.ReaderRepository;
import com.example.FinalExam.Service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reader")
public class ReaderApi {

    private final ReaderService readerService;
    private final ReaderRepository readerRepository;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(readerService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addReader(@RequestBody ReaderDto readerDto) {
        readerService.addReader(readerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReader(
            @PathVariable Long id,
            @RequestBody ReaderDto readerDto
    ) {
        readerService.updateReader(id, readerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReader(@PathVariable Long id) {
        if (readerService.deleteReader(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
