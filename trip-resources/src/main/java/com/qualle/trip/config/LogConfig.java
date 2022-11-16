package com.qualle.trip.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LogConfig {

    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository() {
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

            @Override
            public void add(HttpTrace trace) {
                try {
                    log.info(objectMapper.writeValueAsString(trace));
                } catch (JsonProcessingException e) {
                    log.error(e.getMessage(), e);
                }
                super.add(trace);
            }
        };
    }

}
