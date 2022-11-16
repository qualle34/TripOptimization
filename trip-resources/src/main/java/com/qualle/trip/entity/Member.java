package com.qualle.trip.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.qualle.trip.deserializer.MemberDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member", schema = "public")
@JsonDeserialize(using = MemberDeserializer.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberAllowance> memberAllowances;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    private String role;

}
