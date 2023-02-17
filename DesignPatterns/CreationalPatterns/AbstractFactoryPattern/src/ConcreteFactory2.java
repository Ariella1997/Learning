public class ConcreteFactory2 implements AbstractFactory {

    // The ConcreteFacory implements the AbstractFactory. Hence it needs to implements the methods from AbstractFactory
    // Each of the Products returned implements the corresponding AbstractProduct making the below valid

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2() ; 
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2() ; 
    }
    
}
