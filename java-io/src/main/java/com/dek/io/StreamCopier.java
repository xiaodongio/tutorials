package com.dek.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier {

    public static void copy(InputStream in, OutputStream out) throws IOException {
        synchronized (in) {
            synchronized (out) {
                byte[] buf = new byte[256];
                while (true) {
                    int read = in.read(buf);
                    if (read == -1) {
                        break;
                    } else {
                        out.write(buf, 0, read);
                    }
                }
            }
        }
    }

}
