import java.awt.Dimension;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StorySelector implements ActionListener{

    // This will be the frame that was passed on from MainMenu
    JFrame StorySelector ;  
    // New JPanel that will hold the buttons 
    JPanel StorySelectorPanel = new JPanel() ; 

    StorySelector(JFrame mainMenu){

        // Globalizing the JFrame we receieved
        StorySelector = mainMenu ; 

        // Various JButton, with text representing the various stories we can go with
        JButton testbutton = new JButton("Test") ; 
        JButton button1 = new JButton("1") ; 
        JButton button2 = new JButton("2") ; 
        JButton button3 = new JButton("3") ; 
        JButton button4 = new JButton("4") ; 
        JButton button5 = new JButton("5") ;

        // Creating a JButton array, andd butting all the buttons in the array.
        JButton[] JButtonArray = new JButton[6] ; 
        JButtonArray[0] = testbutton ; 
        JButtonArray[1] = button1 ; 
        JButtonArray[2] = button2 ; 
        JButtonArray[3] = button3 ; 
        JButtonArray[4] = button4 ; 
        JButtonArray[5] = button5 ;

        // Setting the size of the Holder for the JButton array.
        StorySelectorPanel.setPreferredSize(new Dimension(StorySelector.getWidth()  , StorySelector.getHeight())); 

        // Adding ActionCommands to the JButtons. Will be useful for the actionPerformed method
        for(int i = 0 ; i < JButtonArray.length ; i++){
            JButtonArray[i].setActionCommand(JButtonArray[i].getText()) ; 
        }
        // Setting the size of JButtons to be roughlt the entire gameScreen. 
        for(int i = 0 ; i < JButtonArray.length ; i++){
            JButtonArray[i].setPreferredSize(new Dimension( (int) (StorySelector.getWidth() / (JButtonArray.length + 1)  ) , StorySelector.getHeight() - 20 ));
        }

        // Adding Action Listerners to all the buttons
        for(int i = 0 ; i < JButtonArray.length ; i++){
            JButtonArray[i].addActionListener(this);
        }

        // Checking to see if the corresponding file exists for the story.
        for(int i = 0 ; i < JButtonArray.length ; i++){
            File file = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Story".concat(JButtonArray[i].getActionCommand()).concat(".txt")) ; 
            JButtonArray[i].setEnabled(file.exists()) ; 
        }
        
        // Adding the JButtons to the StorySelectorPanel
        for(int i = 0 ; i < JButtonArray.length ; i++){
            StorySelectorPanel.add(JButtonArray[i]) ; 
        }

        // Adding the StorySelectorPanel to the gameScreen, and then repainting everything. 
        StorySelector.add(StorySelectorPanel) ; 
        StorySelector.validate();
        StorySelector.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This means we have selected a story to use. We will not extract it from the ActionCommand we set up earlier.
        File file = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Story".concat(e.getActionCommand()).concat(".txt")) ; 
        // The JPanel is removed and the game is launched with the JFrame and the selected file. 
        StorySelector.remove(StorySelectorPanel) ; 
        new LaunchGame(StorySelector , file) ; 
    }
}
