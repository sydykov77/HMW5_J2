package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    private static final int PASSANGER_SEATS = 100;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4, false);
        for (int i = 1; i < 101; i++) {
            new CashBox(semaphore, i).start();
        }



        CountDownLatch countDownLatch = new CountDownLatch(PASSANGER_SEATS);
        for (int i = 1; i <= PASSANGER_SEATS; i++) {
            Bus bus = new Bus(countDownLatch, i);
            bus.start();

        }

    }
}
