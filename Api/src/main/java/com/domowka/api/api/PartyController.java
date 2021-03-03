package com.domowka.api.api;

import com.domowka.api.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/party")
@RestController
public class PartyApi {
    private final PartyService service;

    @Autowired
    public PartyApi(PartyService service) {
        this.service = service;
    }
}
