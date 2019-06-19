package com.dek.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RandomInputStream extends InputStream {


    private transient Random generator = new Random();


    @Override
    public int read() throws IOException {
        int result = generator.nextInt() % 256;
        if (result < 0) {
            result = -result;
        }
        return result;
    }

    @Override
    public int read(byte[] b) throws IOException {
        generator.nextBytes(b);
        return b.length;
    }


    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        byte[] tmp = new byte[len];
        generator.nextBytes(tmp);
        System.arraycopy(tmp, 0, b, off, len);
        return len;
    }

    @Override
    public long skip(long n) throws IOException {
        return n;

    }
}
