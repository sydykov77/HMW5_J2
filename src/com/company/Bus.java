package com.company;

import java.util.concurrent.CountDownLatch;

public class Bus extends Thread{
    private int passengers;
    private CountDownLatch countDownLatch;

    public Bus(CountDownLatch countDownLatch,int passengers) {
        this.countDownLatch=countDownLatch;
        this.passengers = passengers;
    }


    public void run(){
        try{
            sleep(5000);
            System.out.println("Пассажир №"+passengers+" сел в автобус");
            countDownLatch.countDown();
            Thread.sleep(passengers*10);
        }catch (InterruptedException e){}
    }
}
