package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private Semaphore semaphore;
    private int id;
    private CountDownLatch countDownLatch;

    public PassengerThread(Semaphore semaphore,CountDownLatch countDownLatch, int id) {
        this.semaphore = semaphore;
        this.countDownLatch=countDownLatch;
        this.id = id;
    }


    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println("Пассажир №" + id + " купил билет");
            sleep(100);
            semaphore.release();
            System.out.println("Пассажир №"+id+" сел в автобус");
            countDownLatch.countDown();
            Thread.sleep(id*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
