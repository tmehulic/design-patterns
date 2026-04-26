package com.tmehulic.designpatterns.factory.spring.factorymethod;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactoryExample {

    @Bean
    public ExampleFactoryBean exampleFactoryBean() {
        return new ExampleFactoryBean();
    }

    public static class ExampleFactoryBean implements FactoryBean<ExampleBeanService> {
        @Override
        public @Nullable ExampleBeanService getObject() throws Exception {
            return new ExampleBeanService();
        }

        @Override
        public @Nullable Class<?> getObjectType() {
            return ExampleBeanService.class;
        }
    }
}
