package com.example.aibackend.util;

import org.springframework.stereotype.Component;

@Component
public class MessageFormatter {

    public String format(String name) {
        return "[INFO] Hello, " + name + "!";
    }
}
