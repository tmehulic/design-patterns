package com.tmehulic.designpatterns.decorator.java;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase(c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int bytesRead = super.read(b, off, len);
        for (int i = off; i < off + bytesRead; i++) {
            b[i] = (byte) Character.toLowerCase(b[i]);
        }
        return bytesRead;
    }
}
