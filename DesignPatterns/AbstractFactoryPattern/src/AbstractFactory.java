public interface AbstractFactory {

    // In the abstract factory, we have the methods that will be inherited by the ConcreteFactory
    // Note the return type of the objects is an interface, not an object 
    // All objects created will implements the corresponding interface

    public AbstractProductA createProductA() ; 
    public AbstractProductB createProductB() ; 
    
}
