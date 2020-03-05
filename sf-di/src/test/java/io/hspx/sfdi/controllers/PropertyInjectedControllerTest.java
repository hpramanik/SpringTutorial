package io.hspx.sfdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.hspx.sfdi.services.PropertyGreetingService;

class PropertyInjectedControllerTest {
    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new PropertyGreetingService();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}