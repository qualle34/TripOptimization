package com.qualle.trip.web.client;

import com.qualle.trip.web.client.api.Allowance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "allowanceClient", url = "http://localhost:8080/")
public interface AllowanceClient {

    @PostMapping(value = "/allowances")
    EntityModel<Allowance> addAllowance(Allowance allowance);


}
