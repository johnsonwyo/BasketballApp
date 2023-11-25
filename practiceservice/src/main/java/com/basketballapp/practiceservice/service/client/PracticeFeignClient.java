package com.basketballapp.practiceservice.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.basketballapp.practiceservice.model.Practice;

import jakarta.websocket.server.PathParam;

@FeignClient("practice-service")
public interface PracticeFeignClient {
    @GetMapping(value = "/v1/practice/", consumes = "application/json")
    Practice getPractice(@PathParam("date") String date, @PathParam("grade") int grade);
}
