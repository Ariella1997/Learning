import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener ;
import java.awt.GridLayout;

public class SettingScreen implements ActionListener,KeyListener{

    // Button array that will contain the buttons that we can select. 
    // INCREMENT THIS IF YOU NEED TO ADD MORE BUTTONS
    JButton[] buttonArray = new JButton[2] ; 

    // Panel will hold the buttons nicely together
    JPanel settingScreenPanel = new JPanel() ; 
    // Label will hold text saying "Settings", so we know what was opened
    JLabel settingScreenLabel = new JLabel("Settings") ; 
    // Imported game object
    Game game ;     

    SettingScreen(Game currentgame){

        // Setting the game object to the one that was passed to us. This allows us to use it elsewhere. 
        game = currentgame ; 

        // Creating JButtons. the textSpeedButtonUpdater will update the text in the button depending on the text speed. 
        JButton textSpeedButton = new JButton(textSpeedButtonUpdater()) ; 
        JButton quitButton = new JButton("Quit Game") ;

        // Adding the buttons to the buttonArray
        buttonArray[0] = textSpeedButton ; 
        buttonArray[1] = quitButton ; 

        // Adding ActionCommands to the JButtons. This matches the names of the variable, and will be used in the actionPerformed method
        buttonArray[0].setActionCommand("textSpeedButton"); 
        buttonArray[1].setActionCommand("quitButton") ; 

        // Addding Action Listeners to the JButtons. 
        for(int i = 0 ; i < buttonArray.length ; i++){
            buttonArray[i].addActionListener(this); 
        }

        // Setting the size of the "Settings" Label. Feel free to edit this
        settingScreenLabel.setBounds(50 , 50 , 200 , 50) ; 

        // GridLayout means the buttons will be placed nicely for us in the Panel. the amount of rows will match the number of buttons, and the colum should remain 1. The position of the Panel will be just under the Label, with each button having the same width and height as the Label above
        settingScreenPanel.setLayout(new GridLayout(buttonArray.length, 1)) ; 
        settingScreenPanel.setBounds(settingScreenLabel.getX() , settingScreenLabel.getY() + settingScreenLabel.getHeight() , settingScreenLabel.getWidth() , settingScreenLabel.getHeight()*buttonArray.length);

        // Making the Label Opaque (For visibility), and giving center Alignment. (I like center Alignment)
        settingScreenLabel.setOpaque(true);
        settingScreenLabel.setHorizontalAlignment(JLabel.CENTER);

        // Adding focus to the settingScreenPanel and addding a KeyListener. Now we can press "S" to escape from the game.
        settingScreenPanel.requestFocusInWindow() ; 
        settingScreenPanel.addKeyListener(this);

        // Adding the buttons to the SettingScreenPanel
        for(int i = 0 ; i < buttonArray.length ; i++){
            settingScreenPanel.add(buttonArray[i]) ; 
        }

        // Adding the Panel and Label to the screen, and repainting for visibility.
        game.getVisualLayer().add(settingScreenPanel , Integer.valueOf(3)) ; 
        game.getVisualLayer().add(settingScreenLabel, Integer.valueOf(3)) ; 
        game.getVisualLayer().validate();
        game.getVisualLayer().repaint(); 

        // Just making sure tha the Panel has the focus at the end of the day.
        settingScreenPanel.requestFocusInWindow() ; 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Focus is given back to the panel the moment any button would steal focus from the panel. 
        settingScreenPanel.requestFocusInWindow() ; 
        // We can basically extend this using a switch method. Since we set unique action commands, we can specify what each button should do.
        switch(e.getActionCommand()){
            // This case is for the textSpeedButton. This will change the speed of the text for us, by changing the getTimer(). If the current delay is half the game starting delay, we set the delay to twice the starting delay. Otherwise, we cut the delay in half. 
            case "textSpeedButton":
                // This if statement creates a loop, where the getTimer() delay goes STARTING_TIMER_DELAY -> STARTING_TIMER_DELAY /2 -> 2*STARTING_TIMER_DELAY -> STARTING_TIMER_DELAY. STARTING_TIMER_DELAY HAS TO BE A EVEN NUMBER, CHECK GAME TO MAKE SURE THIS IS TRUE
                if(game.getTimer().getDelay() == game.STARTING_TIMER_DELAY  / 2){
                    game.getTimer().setDelay(game.STARTING_TIMER_DELAY  * 2);
                } else{
                    game.getTimer().setDelay(game.getTimer().getDelay() / 2);
                }
                // We call the textSpeedButton and use the textSpeedButtonUpdater to update the text on what the textSpeed is. This should visually show the user that something has happened, and testing in game will cofirm that to them.
                buttonArray[0].setText(textSpeedButtonUpdater()) ; 
                break; 
                // Todo: Complete this. 
            case "quitButton":
                int Answer = JOptionPane.showConfirmDialog(game.getGameScreen() , "Are you sure you want to exit? All progress will be lost" , "Exit" , JOptionPane.YES_NO_OPTION) ;
                if(Answer ==0){
                    game.getGameScreen().dispose() ; 
                    new MainMenu() ; 
                }
                break ; 
        }
        
    }


    public String textSpeedButtonUpdater(){
        // From actionPerformed, we have 3 options for getTimer() Delay (STARTING_TIMER_DELAY , STARTING_TIMER_DELAY /2 or 2*STARTING_TIMER_DELAY). This will check which one was selected, and then return the string that matches the speed to the Adjective "Fast, Slow, Default". 
        if(game.getTimer().getDelay() == game.STARTING_TIMER_DELAY){
            return "Game Text Speed : Default" ;
        }
        else if(game.getTimer().getDelay() == game.STARTING_TIMER_DELAY / 2){
            return "Game Text Speed : Fast" ; 
            }
        else{
            return "Game Text Speed : Slow" ; 
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
            // Close the setting menu
            case 's' : 
                // Dispose of all settingPanel andd Labels
                game.getVisualLayer().remove(settingScreenPanel) ; 
                game.getVisualLayer().remove(settingScreenLabel) ; 
                // Repainting the gameScreen, so visually it is now removed.
                game.getVisualLayer().validate() ; 
                game.getVisualLayer().repaint(); 
                // returning focus back to the game. 
                game.getGameScreen().requestFocusInWindow() ; 
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
