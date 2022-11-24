import java.io.File;
import java.io.IOException; 
// I built this quite early on in my Java learning. So please expect lots of things will need to be updated. 
public class Main {
    public static void main(String[] args){

        KnotCrosses f1 = new KnotCrosses() ;
        f1.MainMenu() ; 

        File file = new File("Hello") ; 

        try {
            file.createNewFile() ;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

    }
}
