package com.example.FinalExam.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_reader")
public class Reader implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String username;
    private String email;
    private String password;
    private String role;
    private String readerBio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Library library;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_user_Books",
            joinColumns = @JoinColumn(name = "reader_id"),
            inverseJoinColumns = @JoinColumn(name = "Book_id")
    )
    private Set<Book> Books;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_reader_Roles",
            joinColumns = @JoinColumn(name = "reader_id"),
            inverseJoinColumns = @JoinColumn(name = "Role_id")
    )
    private List<Role> Roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Roles;
    }

    @Override
    public String getUsername() { return email; }


}