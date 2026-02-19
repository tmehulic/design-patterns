package com.tmehulic.designpatterns.strategy.spring;

import com.tmehulic.designpatterns.strategy.spring.resource.CustomResource;
import com.tmehulic.designpatterns.strategy.spring.resource.ResourceExample;
import com.tmehulic.designpatterns.strategy.spring.transaction.TransactionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@ActiveProfiles("test")
public class SpringStrategyTests {

    @Autowired RestTestClient restTestClient;
    @Autowired TransactionService transactionService;
    @Autowired ResourceExample resourceExample;

    @Test
    void dispatcherExampleTest() {
        String response =
                restTestClient
                        .get()
                        .uri("/hello")
                        .headers(headers -> headers.setBasicAuth("user", "password"))
                        .exchange()
                        .expectStatus()
                        .isOk()
                        .expectBody(String.class)
                        .returnResult()
                        .getResponseBody();
        Assertions.assertEquals("It actually works!", response);
    }

    @Test
    void transactionExampleTest() {
        Assertions.assertThrows(Exception.class, () -> transactionService.executeTransaction());
    }

    @Test
    void resourceLoaderExampleTest() {
        Resource classPathResource = resourceExample.load("classpath:example.txt");

        Assertions.assertTrue(classPathResource.exists());
        Assertions.assertTrue(classPathResource instanceof ClassPathResource);

        Resource fileUrlResource = resourceExample.load("file:src/test/resources/example.txt");

        Assertions.assertTrue(fileUrlResource.exists());
        Assertions.assertTrue(fileUrlResource instanceof FileUrlResource);

        Resource urlResource = resourceExample.load("https://www.google.com");

        Assertions.assertTrue(urlResource instanceof UrlResource);

        Resource customResource = resourceExample.load("custom:example.txt");

        Assertions.assertTrue(customResource instanceof CustomResource);
    }
}
