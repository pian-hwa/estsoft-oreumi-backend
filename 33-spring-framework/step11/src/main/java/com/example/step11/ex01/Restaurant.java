package com.example.step11.ex01;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
class Restaurant {
    @Autowired
    private Chef chef;
}
