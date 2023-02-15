public class Main {
    public static void main(String[] args){

        ConcreteFactoryA factory1 = new ConcreteFactoryA() ; 
        factory1.orderProduct().create(); 
    }
}
