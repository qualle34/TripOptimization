package com.qualle.trip.web;

import com.qualle.trip.web.client.api.Allowance;
import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.MemberAllowance;
import com.qualle.trip.web.client.api.Ticket;
import com.qualle.trip.web.service.util.ExpensesCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTest {


    @Test
    public void testWhenNoMembersThanSuccess() {
        List<Member> members = new ArrayList<>();

        assertEquals(0d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(0d, ExpensesCalculator.calcAllowanceExpenses(members));
    }


    @Test
    public void testWhenMemberHasNoTicketAndNoAllowanceThanSuccess() {
        List<Member> members = new ArrayList<>();

        Member member1 = Member.builder()
                .id(1L)
                .build();

        members.add(member1);

        assertEquals(0d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(0d, ExpensesCalculator.calcAllowanceExpenses(members));
    }

    @Test
    public void testWhenMemberHasOneTicketAndOneAllowanceThanSuccess() {
        List<Member> members = new ArrayList<>();

        Member member1 = Member.builder()
                .id(1L)
                .tickets(List.of(
                        Ticket.builder().id(1L).price(100).build())
                )
                .memberAllowances(List.of(
                        MemberAllowance.builder().days(10).allowance(Allowance.builder().id(1L).value(10).build()).build())
                )
                .build();

        members.add(member1);

        assertEquals(100d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(100d, ExpensesCalculator.calcAllowanceExpenses(members));
    }


    @Test
    public void testWhenMemberHasTwoTicketsAndTwoAllowancesThanSuccess() {
        List<Member> members = new ArrayList<>();

        Member member1 = Member.builder()
                .id(1L)
                .tickets(List.of(
                        Ticket.builder().id(1L).price(100).build(),
                        Ticket.builder().id(2L).price(200).build())
                )
                .memberAllowances(List.of(
                        MemberAllowance.builder().days(10).allowance(Allowance.builder().id(1L).value(10).build()).build(),
                        MemberAllowance.builder().days(20).allowance(Allowance.builder().id(2L).value(20).build()).build())
                )
                .build();

        members.add(member1);

        assertEquals(300d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(600d, ExpensesCalculator.calcAllowanceExpenses(members));
    }


    @Test
    public void testWhenMembersHaveNoTicketAndNoAllowanceThanSuccess() {
        List<Member> members = new ArrayList<>();

        Member member1 = Member.builder()
                .id(1L)
                .build();

        Member member2 = Member.builder()
                .id(2L)
                .build();

        members.add(member1);
        members.add(member2);

        assertEquals(0d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(0d, ExpensesCalculator.calcAllowanceExpenses(members));
    }

    @Test
    public void testWhenMembersHaveOneTicketAndOneAllowanceThanSuccess() {
        List<Member> members = new ArrayList<>();

        Member member1 = Member.builder()
                .id(1L)
                .tickets(List.of(
                        Ticket.builder().id(1L).price(100).build())
                )
                .memberAllowances(List.of(
                        MemberAllowance.builder().days(10).allowance(Allowance.builder().id(1L).value(10).build()).build())
                )
                .build();

        Member member2 = Member.builder()
                .id(2L)
                .tickets(List.of(
                        Ticket.builder().id(4L).price(400).build())
                )
                .memberAllowances(List.of(
                        MemberAllowance.builder().days(40).allowance(Allowance.builder().id(4L).value(40).build()).build())
                )
                .build();

        members.add(member1);
        members.add(member2);

        assertEquals(500d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(1700d, ExpensesCalculator.calcAllowanceExpenses(members));
    }

    @Test
    public void testWhenMembersHaveTwoTicketsAndTwoAllowancesThanSuccess() {
        List<Member> members = new ArrayList<>();

        Member member1 = Member.builder()
                .id(1L)
                .tickets(List.of(
                        Ticket.builder().id(1L).price(100).build(),
                        Ticket.builder().id(2L).price(200).build())
                )
                .memberAllowances(List.of(
                        MemberAllowance.builder().days(10).allowance(Allowance.builder().id(1L).value(10).build()).build(),
                        MemberAllowance.builder().days(20).allowance(Allowance.builder().id(2L).value(20).build()).build())
                )
                .build();

        Member member2 = Member.builder()
                .id(2L)
                .tickets(List.of(
                        Ticket.builder().id(3L).price(300).build(),
                        Ticket.builder().id(4L).price(400).build())
                )
                .memberAllowances(List.of(
                        MemberAllowance.builder().days(30).allowance(Allowance.builder().id(3L).value(30).build()).build(),
                        MemberAllowance.builder().days(40).allowance(Allowance.builder().id(4L).value(40).build()).build())
                )
                .build();

        members.add(member1);
        members.add(member2);

        assertEquals(1000d, ExpensesCalculator.calcTicketExpenses(members));
        assertEquals(3400d, ExpensesCalculator.calcAllowanceExpenses(members));
    }
}
