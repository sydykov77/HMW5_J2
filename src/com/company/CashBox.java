package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CashBox extends Thread {
    Semaphore semaphore;
    int id;

    public CashBox(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }


    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println("Пассажир №" + id + " купил билет");
            sleep(100);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
