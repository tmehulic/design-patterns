package com.tmehulic.designpatterns.strategy.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@ActiveProfiles("test")
public class SpringStrategyTests {

    @Autowired RestTestClient restTestClient;

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
}
