package com.dek.io;

import java.io.IOException;
import java.io.OutputStream;

public class NullOutputStream extends OutputStream {
    @Override
    public void write(int b) throws IOException {}

    public void write(byte[] data) { }
    public void write(byte[] data, int offset, int length) { }

}
