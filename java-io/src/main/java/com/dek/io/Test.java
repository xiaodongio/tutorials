package com.dek.io;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        System.out.println(Integer.toBinaryString(-129));
        System.out.println(0b1011);

        byte a= (byte) 256;
        byte b= (byte) -257;
        byte c= (byte) 258;

        System.out.println(a);


        String s = "How are streams treating you?";
        byte[] data = s.getBytes();
        System.out.write(data, 2, 5);

    }

}
