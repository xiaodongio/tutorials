package com.dek.io;

import java.io.IOException;
import java.io.InputStream;

public class StreamPrinter {

    InputStream theInput;

    public StreamPrinter(InputStream theInput) {
        this.theInput = theInput;
    }

    /**
     * 此时读取的为ASCII码    按1 回车后   输出 49（1） 10（回车）
     */
    public void print() {
        try {
            while (true) {
                int datum = theInput.read();
                if (datum == -1) {
                    break;
                }
                System.out.println(datum);
            }
        } catch (IOException e) {
            System.err.println("Couldn't read from System.in!");
        }
    }

    public static void main(String[] args) {
        new StreamPrinter(System.in).print();
    }


}
