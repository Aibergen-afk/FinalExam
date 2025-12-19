package com.example.FinalExam.Api;


import com.example.FinalExam.Dto.LibraryDto;
import com.example.FinalExam.Service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/library")
public class LibraryApi {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>(libraryService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id")Long id){
        return new ResponseEntity<>(libraryService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addlibrary(@RequestBody LibraryDto libraryDto){
        libraryService.addLibrary(libraryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatelibrary(@PathVariable(name = "id")Long id,
                                           @RequestBody LibraryDto libraryDto){
        libraryService.updateLibrary(id,libraryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
