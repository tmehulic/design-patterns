package com.tmehulic.designpatterns.factory.java.factorymethod;

import java.nio.charset.Charset;

public class CharsetExample {

    public Charset getCharset(String charsetName) {
        return Charset.forName(charsetName);
    }
}
