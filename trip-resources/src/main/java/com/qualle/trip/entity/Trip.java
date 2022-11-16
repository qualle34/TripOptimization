package com.qualle.trip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trip", schema = "public")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String place;

    private String description;

    @Column(name = "date_start")
    private LocalDate start;

    @Column(name = "date_end")
    private LocalDate end;

    private double expenses;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members;

    public Trip(Long id) {
        this.id = id;
    }
}
