package com.example.account.service.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class customerService {
    public long generateRandom() {
        // Generate a random 10-digit number between 1000000000 and 9999999999 (inclusive)
        long randomNum = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);

        return randomNum;
    }
}
