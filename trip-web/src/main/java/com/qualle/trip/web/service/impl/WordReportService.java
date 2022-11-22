package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.api.Member;
import com.qualle.trip.web.client.api.Trip;
import com.qualle.trip.web.service.ReportService;
import com.qualle.trip.web.service.util.ExpensesCalculator;
import com.qualle.trip.web.service.util.WordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.qualle.trip.web.service.util.ServiceUtil.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class WordReportService implements ReportService {

    @Override
    public File makeReport(Trip trip) {
        return createReport(trip);
    }

    private File createReport(Trip trip){

        Map<String, Object> data = getData(trip);

        return WordUtil.createReport(data);
    }


    private Map<String, Object> getData(Trip trip) {
        Map<String, Object> data = new HashMap<>();
        data.put("date_now", formatDate(new Date()));
        data.put("date_start", formatDate(trip.getStart()));
        data.put("date_end", formatDate(trip.getEnd()));
        data.put("title", trip.getTitle());
        data.put("place", trip.getPlace());
        data.put("description", trip.getDescription());
        data.put("additional_expenses", trip.getExpenses() + " р.");

        double allowanceExpenses = ExpensesCalculator.calcAllowanceExpenses(trip.getMembers());
        double ticketExpenses = ExpensesCalculator.calcTicketExpenses(trip.getMembers());

        data.put("allowance_expenses", allowanceExpenses + " р.");
        data.put("ticket_expenses", ticketExpenses + " р.");
        data.put("expenses", (allowanceExpenses + ticketExpenses) + " р.");

        StringBuilder members = new StringBuilder();
        StringBuilder departments = new StringBuilder();

        for(Member member : trip.getMembers()) {
            members.append(member.getUser().getName())
                    .append(" ")
                    .append(member.getUser().getSurname())
                    .append(", ");

            if (member.getUser().getDepartment() != null){
                departments.append(member.getUser().getDepartment().getName())
                        .append(", ");
            }

            fillMemberData(data, member);
        }

        data.put("member", members.toString());
        data.put("department", departments.toString());

        return data;
    }

    private void fillMemberData(Map<String, Object> data, Member member) {
        data.put("allowances", getAllowanceInfo(member.getMemberAllowances()));
        data.put("tickets", getTicketInfo(member.getTickets()));
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
