package com.tmehulic.designpatterns.strategy.spring.resource;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CustomResourceResolver implements ProtocolResolver, ResourceLoaderAware {

    @Override
    public @Nullable Resource resolve(
            @NonNull String location, @NonNull ResourceLoader resourceLoader) {
        if (location.startsWith("custom:")) {
            return new CustomResource();
        }
        return null;
    }

    @Override
    public void setResourceLoader(@NonNull ResourceLoader resourceLoader) {
        if (DefaultResourceLoader.class.isAssignableFrom(resourceLoader.getClass())) {
            ((DefaultResourceLoader) resourceLoader).addProtocolResolver(this);
        }
    }
}
