package com.dek.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileInputStream inputStream = new FileInputStream("java-nio\\input.txt");
        FileOutputStream outputStream = new FileOutputStream("java-nio\\output.txt");
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {

            byteBuffer.clear();
            int read = inChannel.read(byteBuffer);

            if (read == -1) {
                break;
            }

            byteBuffer.flip();

            outChannel.write(byteBuffer);
        }

        inChannel.close();
        outChannel.close();

    }



}
