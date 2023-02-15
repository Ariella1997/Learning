The Factory Method pattern is useful when the class creating the object can't know beforehand which object it must create. 

- Steps: 

1. Create an AbstractProduct interface that has a create method
2. Create ConcreteProduct classes (ConcreteProductA,ConcreteProductB,ect...), with each product implementing the AbstractProduct interface and implementing the create method 
3. Create an AbstractFactory abstract class, and with an abstract method orderProduct that returns an AbstractProduct 
4. Create ConcreteFactory classes (ConcreteFactoryA,ConcreteFactoryB,ect...) for each ConcreteProduct, have it inherit the AbstractFactory class with each ConcreteFactory orderProduct method returning the correct ConcreteProduct (ConcreteProductA,ConcreteProductB,ect...)
5. Client can now instantiate the desired ConcreteFactory, and from there create the relevant ConcreteProduct. 

# of AbstractProduct = 1
# of AbstractFactory = 1
# of ConcreteProduct = n
# of ConcreteFactory = n

- Adding a new ConcreteProduct 

1. Create a new ConcreteProduct class (ConcreteProductC) that implements the AbstractProduct interface. Implement the create method. 
2. Create a ConcreteFactory class (ConcreteFactoryC) that implements the AbstractFactory abstract class. Implement the orderProduct method by having it return the new ConcreteProduct class (ConcreteProductC). 

# of ConcreteProduct n -> n + 1 
# of ConcreteFactory n -> n + 1 