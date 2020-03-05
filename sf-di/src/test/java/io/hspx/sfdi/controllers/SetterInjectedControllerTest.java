package io.hspx.sfdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.hspx.sfdi.services.SetterGreetingService;

class SetterInjectedControllerTest {
    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new SetterGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}