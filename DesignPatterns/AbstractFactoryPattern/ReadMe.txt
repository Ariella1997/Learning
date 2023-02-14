The Abstract Factory Pattern is useful for the creation various families of related product. 

- Steps:

1. Create an AbstractProduct interface (AbstractProductA,AbstractProductB, ect...) for each type of Product your Factory are going to produce. 
2. Create an AbstractFactory interface that has multiple abstract methods and have each method return an AbstractProduct (AbstractProductA,AbstractProductB, ect...)
3. Create a ConcreteProduct class (ProductA1,ProductA2,ProductB1,ProductB2, ect..) and have each Product implement the correct AbstractProduct interface (AbstractProductA,AbstractProductB, ect...)
4. Create a ConcreteFactory classes (ConcreteFactory1,ConcreteFactory2, ect...) and have the ConcreteFactory classes implement the AbstractFactory class. In the inherited method, have the ConcreteFactory classes return the correct Product (ProductA1,ProductA2,ProductB1,ProductB2, ect..)
5. Client can now instantiate the desired ConcreteFactory, and from there create the relevant Product. 



