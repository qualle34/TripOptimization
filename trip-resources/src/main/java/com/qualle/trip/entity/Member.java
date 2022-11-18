package com.qualle.trip.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.qualle.trip.deserializer.MemberDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Trip trip;

    @RestResource(exported = false)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberAllowance> memberAllowances;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    private String role;

    public Member(Long id) {
        this.id = id;
    }
}
