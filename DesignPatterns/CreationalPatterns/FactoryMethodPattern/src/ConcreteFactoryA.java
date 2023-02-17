public class ConcreteFactoryA extends AbstractFactory{

    @Override
    public AbstractProduct orderProduct() {
        return new ConcreteProductA() ; 
    }
    
}
