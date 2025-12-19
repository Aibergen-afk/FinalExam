package com.example.FinalExam.Repository;

import com.example.FinalExam.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
