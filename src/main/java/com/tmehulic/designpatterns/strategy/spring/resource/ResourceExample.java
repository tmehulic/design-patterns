package com.tmehulic.designpatterns.strategy.spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class ResourceExample {

    private final ResourceLoader resourceLoader;

    public ResourceExample(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource load(String location) {
        return resourceLoader.getResource(location);
    }
}
