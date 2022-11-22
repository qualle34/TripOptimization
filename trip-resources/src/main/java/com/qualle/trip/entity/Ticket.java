package com.qualle.trip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket", schema = "public")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"from\"")
    private String from;

    @Column(name = "\"to\"")
    private String to;

    private LocalDate date;

    private double price;

    @ManyToOne
    @RestResource(exported = false)
    private Transport type;

    @ManyToOne
    private Member member;
}
