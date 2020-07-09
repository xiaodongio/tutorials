package com.dek.bpf;

import java.util.concurrent.Future;

public class AsyncShopTest {

    public static void main(String[] args) {

        Shop shop = new Shop();

        long start = System.nanoTime();

        Future<Double> priceAsync = shop.getPriceAsync("my favorite product");

        try {
            Double price = priceAsync.get();
            System.out.printf("price is %.2f%n", price);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start)/1000_000;
        System.out.println("price returned after " + retrievalTime + "msecs");
    }

}
