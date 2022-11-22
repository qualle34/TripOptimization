package com.qualle.trip.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member_allowance", schema = "public")
public class MemberAllowance implements Serializable {

    @Id
    @ManyToOne
    @RestResource(exported = false)
    @JoinColumn(name = "allowance_id")
    private Allowance allowance;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private int days;
}
