package com.johar.test.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @ClassName: CompletableFutureTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/11/30 23:40
 * @Since: 1.0.0
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {

        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    return "test " + UUID.randomUUID().toString();
                }
            });
            futureList.add(future);
        }
        

        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
        System.out.println(allOfFuture.get(5, TimeUnit.SECONDS));
//        CompletableFuture<List<String>> resultFuture = allOfFuture.thenApply(f -> {
//            return futureList.stream().map(future -> future.get()).collect(Collectors.toList());
//        });
    }
}