# The Decorator Pattern

**The Decorator Pattern** attaches additional responsibilities to an object dynamically. Decorators provide a flexible
alternative to subclassing for extending functionality.

## Applicability

Use the Decorator pattern when you need to be able to assign extra behaviors to objects at runtime without breaking the
code that uses these objects.

Use the pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.

## Spring

Spring uses the Decorator pattern primarily via wrappers to enhance standard framework objects (like requests,
responses, and cache objects) with additional capabilities.

The examples in the `spring` package showcase how the Decorator pattern is used in Spring.

### 1. HTTP Request Wrappers

In the Web layer, Spring often needs to read an HTTP request body multiple times (for logging or tracing), but standard
InputStreams can only be read once. Spring solves this by decorating the request with `ContentCachingRequestWrapper`.

* **The Decorator Interface:** `javax.servlet.http.HttpServletRequest` (or the Jakarta equivalent).
* **The Logic:** "Here is an HTTP request. Wrap it so that I can read the body multiple times without consuming the
  original stream."

### 2. WebSocket Handlers

When working with WebSockets, you often need to add behavior to connections (like logging, exception handling, or
monitoring) without modifying the actual message handling logic. Spring provides `WebSocketHandlerDecorator` to wrap
existing handlers.

* **The Decorator Interface:** `org.springframework.web.socket.WebSocketHandler`
* **The Logic:** "Here is a WebSocket connection. Wrap it so that I can add additional behavior without modifying the
  message handling logic."

Other decorator patterns in Spring also include:

- `SecurityContextHolderAwareRequestWrapper` for decorating requests with Spring Security authentication methods
- `BeanWrapper` for decorating Java beans with property access and manipulation capabilities
- `TransactionAwareCacheDecorator` for synchronizing cache put/evict operations with active transactions
- `HttpHeadResponseDecorator` for handling HTTP HEAD requests in WebFlux
- `SessionRepositoryFilter` which wraps the `HttpServletRequest` to override session handling (used in Spring Session)