package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.TransportClient;
import com.qualle.trip.web.client.api.Transport;
import com.qualle.trip.web.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    private final TransportClient transportClient;

    @Override
    public List<Transport> getTransports() {
        return new ArrayList<>(transportClient.getTransports().getContent());
    }
}
