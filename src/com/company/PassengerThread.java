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
            sleep(100);
            semaphore.release();
            System.out.println("Пассажир №"+id+" купил билет и сел в автобус");
            countDownLatch.countDown();
            Thread.sleep(id*10);
            countDownLatch.await();
            if (id>=100){
                System.out.println("Aвтобус поехал!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
