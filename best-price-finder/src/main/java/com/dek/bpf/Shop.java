package com.dek.bpf;

import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {


    private static class RandomHolder {
        private static final SecureRandom RANDOM = new SecureRandom();
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    @Deprecated
    public Future<Double> getPriceAsync1(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread( () -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            } catch (Exception ex) {
                future.completeExceptionally(ex);
            }
        }).start();
        return future;
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(String product) {
        delay();
        return RandomHolder.RANDOM.nextDouble() * product.charAt(0)
                + product.charAt(1);
    }

}
