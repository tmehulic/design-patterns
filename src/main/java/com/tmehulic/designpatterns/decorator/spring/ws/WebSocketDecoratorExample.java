package com.tmehulic.designpatterns.decorator.spring.ws;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

@Configuration
@EnableWebSocket
public class WebSocketDecoratorExample implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        WebSocketHandler originalHandler = new PassthroughHandler();
        WebSocketHandler decoratedHandler = new ExampleDecorator(originalHandler);

        registry.addHandler(decoratedHandler, "/ws-example");
    }

    static class PassthroughHandler extends TextWebSocketHandler {
        @Override
        public void handleTextMessage(
                @NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
            session.sendMessage(message);
        }
    }

    static class ExampleDecorator extends WebSocketHandlerDecorator {

        public ExampleDecorator(WebSocketHandler delegate) {
            super(delegate);
        }

        @Override
        public void handleMessage(
                @NonNull WebSocketSession session, @NonNull WebSocketMessage<?> message)
                throws Exception {
            WebSocketMessage<?> decorated = new TextMessage("Decorated: " + message.getPayload());
            super.handleMessage(session, decorated);
        }
    }
}
