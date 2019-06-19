package com.dek.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {


    public static void main(String[] args) throws Exception {
        try (
            final PipedOutputStream output = new PipedOutputStream();

        final PipedInputStream input = new PipedInputStream(output)) {

            Thread t2 = new Thread(() -> {
                try {
                    int data = input.read();
                    while (data != -1) {
                        System.out.println((char) data);
                        data = input.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            Thread t1 = new Thread(() -> {
                try {
                    output.write("hello pipe".getBytes());

                    t2.join();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();
            Thread.sleep(10000L);
        }
    }

}
