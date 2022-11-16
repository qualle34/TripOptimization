package com.qualle.trip.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.qualle.trip.entity.Member;
import com.qualle.trip.entity.MemberAllowance;
import com.qualle.trip.entity.Trip;
import com.qualle.trip.entity.User;

import java.io.IOException;

public class MemberAllowanceDeserializer extends StdDeserializer<MemberAllowance> {

    public MemberAllowanceDeserializer() {
        this(null);
    }

    public MemberAllowanceDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public MemberAllowance deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        MemberAllowance member = new MemberAllowance();

        if (node.get("days") != null && !node.get("days").isNull()) {
            int days = (node.get("days")).intValue();
            member.setDays(days);
        }

        if (node.get("member") != null && !node.get("member").isNull()) {
            long memberId = (node.get("member").get("id")).longValue();
            member.setMember(new Member(memberId));
        }

        return member;
    }
}
