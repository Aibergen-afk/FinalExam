package com.example.FinalExam.Service;

import com.example.FinalExam.Model.Reader;
import com.example.FinalExam.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyReaderService implements UserDetailsService {

    private final ReaderRepository readerRepository;
    private final PasswordEncoder passwordEncoder;

    public void registr(Reader model) {
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        model.setRole("ROLE_USER");
        readerRepository.save(model);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Reader reader = readerRepository.findByEmail(email);

        return org.springframework.security.core.userdetails.User
                .withUsername(reader.getEmail())
                .password(reader.getPassword())
                .roles("USER")
                .build();
    }
}
