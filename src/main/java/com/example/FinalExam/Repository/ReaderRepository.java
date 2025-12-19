package com.example.FinalExam.Repository;

import com.example.FinalExam.Model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findByEmail(String email);

}
