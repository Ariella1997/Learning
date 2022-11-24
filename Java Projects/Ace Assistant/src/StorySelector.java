import java.awt.Dimension;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StorySelector implements ActionListener{

    JFrame StorySelector ;  
    JPanel StorySelectorPanel = new JPanel() ; 

    StorySelector(JFrame mainMenu){

        StorySelector = mainMenu ; 


        JButton testbutton = new JButton("Test") ; 
        JButton button1 = new JButton("1") ; 
        JButton button2 = new JButton("2") ; 
        JButton button3 = new JButton("3") ; 
        JButton button4 = new JButton("4") ; 
        JButton button5 = new JButton("5") ;

        JButton[] JButtonArray = new JButton[6] ; 
        JButtonArray[0] = testbutton ; 
        JButtonArray[1] = button1 ; 
        JButtonArray[2] = button2 ; 
        JButtonArray[3] = button3 ; 
        JButtonArray[4] = button4 ; 
        JButtonArray[5] = button5 ;

        StorySelectorPanel.setPreferredSize(new Dimension(mainMenu.getWidth()  , mainMenu.getHeight())); 

        for(int i = 0 ; i < JButtonArray.length ; i++){
            JButtonArray[i].setActionCommand(JButtonArray[i].getText()) ; 
        }

        for(int i = 0 ; i < JButtonArray.length ; i++){
            JButtonArray[i].setPreferredSize(new Dimension( (int) (mainMenu.getWidth() / (JButtonArray.length + 1)  ) , mainMenu.getHeight() - 20 ));
        }

        for(int i = 0 ; i < JButtonArray.length ; i++){
            JButtonArray[i].addActionListener(this);
        }

        for(int i = 0 ; i < JButtonArray.length ; i++){
            File file = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Story".concat(JButtonArray[i].getActionCommand()).concat(".txt")) ; 
            JButtonArray[i].setEnabled(file.exists()) ; 
        }
        
        for(int i = 0 ; i < JButtonArray.length ; i++){
            StorySelectorPanel.add(JButtonArray[i]) ; 
        }

        StorySelector.add(StorySelectorPanel) ; 
        StorySelector.validate();
        StorySelector.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Story".concat(e.getActionCommand()).concat(".txt")) ; 
        StorySelector.remove(StorySelectorPanel) ; 
        new LaunchGame(StorySelector , file) ; 
    }
}
