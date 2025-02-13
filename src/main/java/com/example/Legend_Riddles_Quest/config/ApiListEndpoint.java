package com.example.Legend_Riddles_Quest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "api-list")
public class ApiListEndpoint {

    @Autowired
    private ApplicationContext context;

    @ReadOperation
    public String apiList() {
        String[] beans = context.getBeanNamesForAnnotation(RestController.class);
        return Arrays.stream(beans).collect(Collectors.joining("\n"));
    }
}
