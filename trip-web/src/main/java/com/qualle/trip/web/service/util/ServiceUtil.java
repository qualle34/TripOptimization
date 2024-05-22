package com.qualle.trip.web.service.util;

import com.qualle.trip.web.client.api.MemberAllowance;
import com.qualle.trip.web.client.api.Ticket;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UtilityClass
public class ServiceUtil {

    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy г.");
        return simpleDateFormat.format(date);
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy г.");
        return dateTimeFormatter.format(date);
    }

    public static Object getTicketInfo(List<Ticket> dto) {
        List<String> output = new ArrayList<>();

        for (Ticket ticket : dto) {
            output.add(ticket.getFrom() + " - " + ticket.getTo() + " " + ticket.getPrice());
        }
        return output;
    }

    public static Object getAllowanceInfo(List<MemberAllowance> dto) {
        List<String> output = new ArrayList<>();

        for (MemberAllowance allowance : dto) {
            String info = allowance.getAllowance().getCountry().getValue() + " - " + allowance.getAllowance().getValue() * allowance.getDays();
            output.add(info);
        }
        return output;
    }
}