import javax.swing.JButton;
import javax.swing.JFrame ; 
import javax.swing.JPanel ; 
import java.awt.FlowLayout ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;


public class MainMenu implements ActionListener{

    // Variables shared with the Action Listener method
    JFrame mainMenu = new JFrame("Ace Assistant");
    JButton startButton = new JButton("Start");
    JButton exitButton = new JButton("Exit");
    JPanel mainMenuButtonHolder = new JPanel();

    MainMenu(){
        // JFrame Settings
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setLayout(new FlowLayout());
        mainMenu.setSize(500 , 500);

        // Size of the container that will hold the buttons
        mainMenuButtonHolder.setPreferredSize(new Dimension(100  , 500)); 

        // Size of the buttons
        startButton.setPreferredSize(new Dimension(100 , 50));
        exitButton.setPreferredSize(new Dimension(100 , 50));

        // Adding Action Listeners to the buttons
        startButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Adding the buttons to the container that holds buttons
        mainMenuButtonHolder.add(startButton) ; 
        mainMenuButtonHolder.add(exitButton) ; 

        // Adding the container that holds buttons to the mainMenu, make the entire Main Menu visible
        mainMenu.add(mainMenuButtonHolder) ;
        mainMenu.setVisible(true); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            // Activates the story selection Screen, removes the mainMenuButtons first. 
            mainMenu.remove(mainMenuButtonHolder) ; 
            new StorySelector(mainMenu) ; 
        }
        else if(e.getSource() == exitButton){
            // Closes the entire program
            mainMenu.dispose();
        }
        
    }

   
    
}
