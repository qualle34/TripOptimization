package com.qualle.trip.web.service.util;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.MemberAllowance;
import com.qualle.trip.web.client.api.Ticket;
import lombok.experimental.UtilityClass;

import java.util.Collection;


@UtilityClass
public class ExpensesCalculator {

    public static double calcTicketExpenses(Collection<Member> members) {

        if (members == null || members.isEmpty()) {
            return 0;
        }

        return members.stream().mapToDouble(ExpensesCalculator::calcTicketExpensesForMember).sum();
    }

    public static double calcAllowanceExpenses(Collection<Member> members) {

        if (members == null || members.isEmpty()) {
            return 0;
        }

        return members.stream().mapToDouble(ExpensesCalculator::calcAllowanceExpensesForMember).sum();
    }

    private static double calcTicketExpensesForMember(Member member) {

        if (member.getTickets() == null || member.getTickets().isEmpty()) {
            return 0;
        }

        return member.getTickets().stream().mapToDouble(Ticket::getPrice).sum();
    }

    private static double calcAllowanceExpensesForMember(Member member) {

        if (member.getMemberAllowances() == null || member.getMemberAllowances().isEmpty()) {
            return 0;
        }

        int allDays = member.getMemberAllowances().stream().mapToInt(MemberAllowance::getDays).sum();
        double maxDayPrice = member.getMemberAllowances().stream().mapToDouble(ma -> ma.getAllowance().getValue()).max().orElse(0);

        return allDays * maxDayPrice;
    }
}
