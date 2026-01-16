package com.example.step11.ex01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RestaurantTest {
    @Autowired
    private Restaurant restaurant;

    @Test
    public void testExists() {
        assertNotNull(restaurant);

        log.info("restaurant = {}", restaurant);
        log.info("------------------------------------------------------");
        log.info("chef = {}", restaurant.getChef());
    }
}