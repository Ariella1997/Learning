public class ConcreteFactoryB extends AbstractFactory{

    @Override
    public AbstractProduct orderProduct() {
        return new ConcreteProductB() ; 
    }
    
}
