The Factory Method pattern is useful when the class creating the object can't know beforehand which object it must create. 

- Steps: 

1. Create an AbstractProduct interface that has a create method
2. Create ConcreteProduct classes (ConcreteProductA,ConcreteProductB,ect...), with each product implementing the AbstractProduct interface and implementing the create method 
3. Create an AbstractFactory abstract class, and with an abstract method orderProduct that returns an AbstractProduct 
4. Create ConcreteFactory classes (ConcreteFactoryA,ConcreteFactoryB,ect...) for each ConcreteProduct, have it inherit the AbstractFactory class with each ConcreteFactory orderProduct method returning the correct ConcreteProduct (ConcreteProductA,ConcreteProductB,ect...)
5. Client can now instantiate the desired ConcreteFactory, and from there create the relevant ConcreteProduct. 

# of AbstractFactory = 1
# of ConcreteFactory = n
# of AbstractProduct = 1
# of ConcreteProduct = n

- Adding a new ConcreteProduct 

1. Create a new ConcreteProduct class (ConcreteProductC) that implements the AbstractProduct interface. Implement the create method. 
2. Create a ConcreteFactory class (ConcreteFactoryC) that implements the AbstractFactory abstract class. Implement the orderProduct method by having it return the new ConcreteProduct class (ConcreteProductC). 

# of ConcreteFactory n -> n + 1 
# of ConcreteProduct n -> n + 1 

- Conversion to AbstractFactory Pattern 
(Normally, you convert from a Factory Method Pattern to an Abstract Factory Pattern when you realise you have another group of product family that has all the products of the current Factory Method) 

1. Replace the AbstractProduct interface with "n" AbstractProduct interfaces (AbstractProductA, AbstractProductB,... ect) for each ConcreteProduct type. 
2. Change the AbstractFactory from an abstract class into an interface, and replace the single method orderProduct with "n" abstract methods each returning one of the AbstractProduct interfaces (AbstractProductA, AbstractProductB,... ect). 
3. Replace the "n" ConcreteProduct with "2*n" ConcreteProduct(ConcreteProductA1,ConcreteProductA2,ConcreteProductB1,ConcreteProductB2,ect...), for the two different family of product. Have each concreteProduct implement the correct AbstractProduct interface (AbstractProductA, AbstractProductB,... ect)
4. Replace the "n" ConcreteFactory classes with 2 ConcreteFactory classes (ConcreteFactory1,ConcreteFactory2). Have each ConcreteFactory class implement the AbstractFactory class. In the inherited method, have the ConcreteFactory classes methods return the correct ConcreteProduct (ProductA1,ProductA2,ProductB1,ProductB2, ect..)
5. Conversion should be successful 

# of AbstractFactory = 1 -> 1
# of ConcreteFactory = n -> 2
# of AbstractProduct = 1 -> n 
# of ConcreteProduct = n -> 2*n