package com.tmehulic.designpatterns.decorator.spring;

import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@ActiveProfiles("test")
public class SpringDecoratorTests {

    @Autowired RestTestClient restTestClient;

    @LocalServerPort private int port;

    @Test
    void requestWrapperTest() {
        String payload = "Decorator Example";

        restTestClient
                .post()
                .uri("/example")
                .body(payload)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("SUCCESS")
                .consumeWith(
                        result -> {
                            String auditHeader =
                                    result.getResponseHeaders().getFirst("X-DECORATOR-EXAMPLE");
                            Assertions.assertEquals(
                                    String.valueOf("SUCCESS".length()), auditHeader);
                        });
    }

    @Test
    void webSocketDecoratorTest() throws Exception {
        WebSocketClient client = new StandardWebSocketClient();

        List<String> receivedMessages = new ArrayList<>();

        WebSocketHandler clientHandler =
                new TextWebSocketHandler() {
                    @Override
                    protected void handleTextMessage(
                            @NonNull WebSocketSession session, TextMessage message) {
                        receivedMessages.add(message.getPayload());
                    }
                };

        WebSocketSession session =
                client.execute(clientHandler, "ws://localhost:" + port + "/ws-example").get();

        session.sendMessage(new TextMessage("Test"));

        Thread.sleep(1000);

        Assertions.assertTrue(receivedMessages.contains("Decorated: Test"));

        session.close();
    }
}
