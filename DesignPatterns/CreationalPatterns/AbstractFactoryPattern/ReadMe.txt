The Abstract Factory Pattern is useful for the creation various families of related product. 

- Steps:

1. Create "n" AbstractProduct interface (AbstractProductA,AbstractProductB, ect...) for each type of ConcreteProduct your Factory are going to produce. 
2. Create an AbstractFactory interface that has "n" abstract methods and have each method return an AbstractProduct (AbstractProductA,AbstractProductB, ect...)
3. Create "n*m" ConcreteProduct classes (ProductA1,ProductA2,ProductB1,ProductB2, ect..), where "m" is the number of product families, and have each ConcreteProduct implement the correct AbstractProduct interface (AbstractProductA,AbstractProductB, ect...)
4. Create "m" ConcreteFactory classes (ConcreteFactory1,ConcreteFactory2, ect...) and have the ConcreteFactory classes implement the AbstractFactory class. In the inherited method, have the ConcreteFactory classes methods return the correct ConcreteProduct (ProductA1,ProductA2,ProductB1,ProductB2, ect..)
5. Client can now instantiate the desired ConcreteFactory, and from there create the relevant ConcreteProduct. 

# of AbstractFactory = 1 
# of ConcreteFactory = m 
# of AbstractProduct = n 
# of ConcreteProduct = m*n 

- Adding a new ConcreteProduct 

1. Create a new AbstractProduct interface (AbstractProductC) and for each ConcreteFactory, create a new ConcreteProduct class that implements the AbstractProductC interface. 
2. Add an abstract method (createProductC) that returns AbstractProductC to the AbstractFactory 
3. Create the unimplemented createProductC method in each ConcreteFactory, and have it return the correct ConcreteProduct 

# of AbstractProduct n -> n + 1  
# of ConcreteProduct m*n -> m*(n+1)

- Adding a new ConcreteFactory 

1. Create ConcreteProduct classes (ProductA3,ProductB3,...ect) for each existing AbstractProduct class (AbstractProductA,AbstractProductB,ect...). Each new ConcreteProduct should implement the correct AbstractProduct interface. 
2. Create a new ConcreteFactory class (ConcreteFactory3) that implements the AbstractFactory
3. Create the unimplemented methods from AbtractFactory in the new ConcreteFactory (ConcreteFactory3) and have it return the correct ConcreteProduct (ProductA3,ProductB3,...ect) 

# of ConcreteFactory m -> m + 1 
# of ConcreteProduct m*n -> (m+1)*n



