# The Factory Patterns

**The Factory Method Pattern** defines an interface for creating an object, but lets subclasses decide which class to
instantiate. Factory Method lets a class defer instantiation to subclasses.

**The Abstract Factory Pattern** provides an interface for creating families of related or dependent objects without
specifying their concrete classes.

## Applicability

### Factory Method ###

Use the Factory Method when you don’t know beforehand the exact types and dependencies of the objects your code should
work with.

Use the Factory Method when you want to provide users of your library or framework with a way to extend its internal
components.

Use the Factory Method when you want to save system resources by reusing existing objects instead of rebuilding them
each time.

### Abstract Factory ###

Use the Abstract Factory when your code needs to work with various families of related products, but you don't want it
to depend on the concrete classes of those products – they might be unknown beforehand, or you simply want to allow for
future extensibility.

Consider implementing the Abstract Factory when your have a class with a set of Factory Methods that blur its primary
responsibility.