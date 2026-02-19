package com.tmehulic.designpatterns.strategy.spring.resource;

import org.springframework.core.io.AbstractResource;

import java.io.InputStream;

public class CustomResource extends AbstractResource {
    @Override
    public String getDescription() {
        return "Custom Resource";
    }

    @Override
    public InputStream getInputStream() {
        return InputStream.nullInputStream();
    }
}
