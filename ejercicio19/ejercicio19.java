package com.mycompany.rxjavabackpressure;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class ejercicio19 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> fastProducer = Flowable.interval(10, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer();
        
        fastProducer
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(100); 
                    System.out.println("Consumido: " + item);
                }, throwable -> {
                    System.err.println("Error: " + throwable);
                });

        Thread.sleep(5000); 
    }
}

