package com.example.FinalExam.Api;

import com.example.FinalExam.Model.Reader;
import com.example.FinalExam.Service.MyReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MyReaderApi {

    private final MyReaderService myReaderService;



    @PostMapping("/registr")
    public void registr(@RequestBody Reader model){
        myReaderService.registr(model);
    }

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok("You are authorized!");
    }
}
