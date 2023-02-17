public class Adapter implements AbstractAdaptee {

    private final Target target ; 

    public Adapter(){
        target = new Target() ; 
    }


    @Override
    public void displayMenu(int numberofItems) {
        target.displayMenu(conversion(numberofItems));
    }

    @Override
    public int displayRecommendations(int numberofRecs) {
        return target.displayRecommendations(conversion(numberofRecs));
    }

    private String conversion(int a){
        return String.valueOf(a) ; 
    }
    
}
