public class Main {
    public static void main(String[] args){

        ConcreteFactory2 factory = new ConcreteFactory2() ; 
        System.out.println(factory.createProductA().getClass().getSimpleName()) ; 

    }
}
