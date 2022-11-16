package com.qualle.trip.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.qualle.trip.entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberDeserializer extends StdDeserializer<Member> {

    private ObjectMapper mapper = new ObjectMapper();

    public MemberDeserializer() {
        this(null);
    }

    public MemberDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Member deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        Member member = new Member();

        if (node.get("user") != null && !node.get("user").isNull()) {
            long userId = (node.get("user").get("id")).longValue();
            member.setUser(new User(userId));
        }

        if (node.get("trip") != null && !node.get("trip").isNull()) {
            long tripId = (node.get("trip").get("id")).longValue();
            member.setTrip(new Trip(tripId));
        }

        if (node.get("memberAllowances") != null && !node.get("memberAllowances").isNull()) {
            List<MemberAllowance> memberAllowanceList = new ArrayList<>();

            for (JsonNode objNode : node.get("memberAllowances")) {

                MemberAllowance ma = new MemberAllowance();

                ma.setDays(objNode.get("days").intValue());
                ma.setAllowance(new Allowance(objNode.get("allowance").get("id").longValue()));
                ma.setMember(new Member(objNode.get("member").get("id").longValue()));

                memberAllowanceList.add(ma);
            }
            member.setMemberAllowances(memberAllowanceList);
        }


        member.setRole(node.get("role").asText());

        return member;
    }
}
