package com.qualle.trip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    private LocalDate birthday;

    private String gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Credentials credentials;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Passport passport;

    @RestResource(exported = false)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Member> members;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    public User(Long id) {
        this.id = id;
    }
}
