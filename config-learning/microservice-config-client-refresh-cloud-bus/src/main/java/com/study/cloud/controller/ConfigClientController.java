package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    //Fetching config from server at : http://localhost:8888
    @Value("${profile}")
    private String profile;

    @GetMapping(value = "profile")
    public String getProfile() {
        return profile;
    }
}
