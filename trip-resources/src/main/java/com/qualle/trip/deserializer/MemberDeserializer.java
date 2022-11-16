package com.qualle.trip.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.qualle.trip.entity.Member;
import com.qualle.trip.entity.Trip;
import com.qualle.trip.entity.User;

import java.io.IOException;

public class MemberDeserializer extends StdDeserializer<Member> {

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

        member.setRole(node.get("role").asText());

        return member;
    }
}
