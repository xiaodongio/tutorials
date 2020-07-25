package com.dek.bpf;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MutilShopTest {


    static List<Shop> shops = List.of(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    public static void main(String[] args) {
        /*long start = System.nanoTime();
        System.out.println(findPrices("phone"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");*/


        List<CompletableFuture<String>> priceFutures =
                shops.stream().map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
                                shop.getName(),
                                shop.getPrice("laptop")))
                ).collect(Collectors.toList());


        System.out.println(priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }


    public static List<String> findPrices(String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f",
                shop.getName(),
                shop.getPrice(product))).collect(Collectors.toList());
    }

}
