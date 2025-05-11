package com.mycompany.ejercicio200;

public class Ejercicio200 {

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> KafkaProducerExample.sendMessage());
        Thread consumerThread = new Thread(() -> KafkaConsumerExample.consumeMessage());

        producerThread.start();
        consumerThread.start();
    }
}
