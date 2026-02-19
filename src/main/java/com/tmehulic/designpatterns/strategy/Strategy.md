# The Strategy Pattern

**The Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy
lets the algorithm vary independently of clients that use it.

## Applicability

Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch
from one algorithm to another during runtime.

Use the Strategy pattern when you have a lot of similar classes that only differ in the way they execute the same
behavior.

Use the Strategy pattern to isolate the business logic of a class from the implementation details of algorithms that
may not be as important in the context of that logic.

Use the Strategy pattern when your class has a massive conditional statement that switches between different variants of
the same algorithm.

## Spring

Spring heavily relies on the Strategy pattern, especially in the Dependency Injection (DI) layer. The examples in the
`spring` package showcase how the Strategy pattern is used in Spring.

### 1. Request Handling: `HandlerMapping`

`DispatcherServlet` needs to know which controller method should handle an incoming HTTP request. It keeps a list of
`HandlerMapping` strategies, and delegates to the first one that returns a non-null `HandlerExecutionChain`.   
This is demonstrated in the `dispatcher` package.

* **The Strategy Interface:** `org.springframework.web.servlet.HandlerMapping`
* **The Logic:** "Here is an HTTP Request. Find me the `HandlerExecutionChain` (the controller method and interceptors)
  that should handle it."

### 2. Transaction Management: `PlatformTransactionManager`

Spring's transaction management is a classic example of the Strategy pattern. When you annotate a method with
`@Transactional`, Spring needs to know *how* to manage the transaction. It delegates this responsibility to a
`PlatformTransactionManager` strategy that you configure in your application context.  
This is demonstrated in the `transaction` package.

* **The Strategy Interface:** `org.springframework.transaction.PlatformTransactionManager`
* **The Logic:** "Begin a transaction," "Commit this transaction," or "Rollback this transaction."

### 3. Resource Loading: `ResourceLoader`

Spring's `ResourceLoader` is a strategy for loading resources (files, classpath resources, URLs) based on a location
string.
This is demonstrated in the `resource` package

* **The Strategy Interface:** `org.springframework.core.io.ResourceLoader` (and the `Resource` interface itself).
* **The Logic:** "Given a location string, give me a handle to the resource."

Other strategy patterns in Spring also include:

- `AuthenticationProvider` for security
- `ViewResolver` for MVC view resolution
- `BeanNameGenerator` for bean naming in component scanning
- `MessageSource` for internationalization (i18n) message resolution
- `CacheManager` for caching strategies
- `TaskExecutor` for asynchronous task execution strategies
- `LocaleResolver` for determining the user's locale in web applications
- `HandlerExceptionResolver` for resolving exceptions thrown during request handling