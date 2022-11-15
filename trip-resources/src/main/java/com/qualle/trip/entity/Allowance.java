package com.qualle.trip.entity;

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
@Table(name = "allowance", schema = "public")
public class Allowance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "allowance", cascade = CascadeType.ALL)
    private List<MemberAllowance> memberAllowances;

}
