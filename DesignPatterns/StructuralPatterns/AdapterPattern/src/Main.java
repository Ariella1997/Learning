public class Main {
    public static void main(String[] args){

        Adaptee adaptee = new Adaptee() ; 
        adaptee.displayMenu(5);

        Adapter adapter = new Adapter() ; 
        adapter.displayMenu(5); 
    }
}
