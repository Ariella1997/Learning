import java.awt.Color ;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener ; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Game implements MouseListener,ActionListener,KeyListener{

    // Todo: messageUpdater() method, gets a file from a specific path and passes it through TextReader(), and set message to the new file. Will probably need to pass in an integer to symbolise where we started
    // Todo: Write the next section of story. Check game works up until the end. 

    // messageCounter will fetch a command or text from the message variable
    int messageCounter = -1 ;
    // characterCounter will fetch the letters from the text in a message variable.
    int characterCounter = 0 ;
    // message will hold a list of command and text to be interpreted by the code
    LinkedList<String> message = new LinkedList<>();
    // visualLayer alllows us to correctly lay the different visual images in the correct order on the visualScreen
    JLayeredPane visualLayer = new JLayeredPane();
    // various items that have been passed to us from the launchGame class
    JFrame gameScreen = new JFrame() ;
    JPanel visualScreen = new JPanel() ;
    JPanel textScreen = new JPanel() ;
    JPanel characterScreen = new JPanel() ;
    // A JLabel that will display the name of character currently speaking, thinking, whispering, ect.
    JLabel characterNameDisplay = new JLabel("") ;
    // A JLabel that will display what is actually being said, thought, whispered, ect.
    // Here we will have the first ever text that the player will read, telling them how to move forward.
    JLabel textDisplay = new JLabel("Click to Start or press the SPACEBAR") ;
    // A timer object that will perform the act of writing the character by incrementing characterCounter
    Timer timer = new Timer(0 , this ) ;
    // An evidenceScreen object that will open things that are in the court record. 
    EvidenceScreen evidenceScreen ;
    // List containing icon, text and full images of various evidences. 
    LinkedList<ImageIcon> evidenceImageList = new LinkedList<>() ; 
    LinkedList<String> evidenceTextList = new LinkedList<>() ;
    LinkedList<ImageIcon> evidenceFullImageList = new LinkedList<>() ; 
    // A settingScreeen object that will open up the settings to change/leave the game.
    SettingScreen settingScreen ; 
    // A final variable used by the SettingScreen. 
    final int STARTING_TIMER_DELAY ; 
    // Audio stuff
    Clip musicClip ; 

    Game(JFrame oldgameScreen , JPanel oldvisualScreen , JPanel oldtextScreen , JPanel oldcharacterScreen , File file){

        // passsing the variables that were given to us from launchgame
        gameScreen = oldgameScreen ;
        visualScreen = oldvisualScreen ; 
        textScreen = oldtextScreen ;
        characterScreen = oldcharacterScreen ;
        
        // visualLayer will have no Layout manager, Images are placed by setBounds method. 
        // most images will be done through the imageUpdater() method. (Not all)
        // visualLayer will match cover the entire visualScreen.
        visualScreen.setLayout(null) ; 
        visualLayer.setBounds(0 , 0 ,visualScreen.getWidth() , visualScreen.getHeight()) ;

        // sets the speed at which the text should appear one after the other. If you want to change the overall text Delay, do it here on the first line. 
        // Increase for slower text speed, Decrease for Faster text speed
        // STARTING_TIMER_DELAY will be used for SettingScreen (We must pass STARTING_TIMER_DELAY as an even number.)
        timer.setDelay(10);
        STARTING_TIMER_DELAY = 2*timer.getDelay() ; 
        timer.setDelay(STARTING_TIMER_DELAY) ; 

        // Setting starting colours for the character's name and what they will be saying. 
        // textDisplay will be set to the top of the JLabel for added space.
        characterNameDisplay.setForeground(Color.WHITE);
        textDisplay.setForeground(Color.WHITE);
        textDisplay.setVerticalAlignment(JLabel.TOP);

        // Adding the various JLabels and JLayeredPane to the code
        // We also add in mouseListener to users can move the text forward
        characterScreen.add(characterNameDisplay) ; 
        textScreen.add(textDisplay) ; 
        gameScreen.addMouseListener(this);
        // Apparently need to requestFocusInWindow before I can set up the KeyListener. 
        gameScreen.requestFocusInWindow();
        gameScreen.addKeyListener(this) ;

        // Adding the visualLayer onto the screen
        // Activate textReader to fill in the message variable, where all commands will be stored.
        visualScreen.add(visualLayer) ; 
        message = TextReader(file) ;

    }

    public LinkedList<String> TextReader(File file) {
        // Will write a command line from the txt file that will give what textfile should be read
        // Will use this to separate different story elements. 
        LinkedList<String> Story = new LinkedList<>(); 
        Scanner scanner;
        int i = 0 ; 
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String temp = scanner.nextLine() ; 
                switch(temp){
                    case "Bubble" : 
                        Story.add(i , temp) ;
                        Story.add(i + 1 , scanner.nextLine()) ; 
                        Story.add(i + 2 , "");
                        Story.add(i + 3, ""); 
                        Story.add(i + 4 , "Remove Bubble") ; 
                        i = i + 5; 
                        break ;
                    case "Thought" : 
                        Story.add(i , temp) ; 
                        Story.add(i + 1 , "Alex") ; 
                        Story.add(i + 2 , "(".concat(scanner.nextLine()).concat(")")) ; 
                        i = i + 3  ; 
                        break; 
                    default : 
                        Story.add( i , temp) ; 
                        i++ ; 
                        break ; 
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Story ;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // When we pop up new objects, we will lose focus on the gameScreen. This stops the mousePressed from activating and moving the game along in the background. 
        if(gameScreen.hasFocus()){
            // code on what to do if the timer is still running (i.e the message is still being written)
            // timer is stopped, remainder of text is added and character counter reset
            if(timer.isRunning()){
                gameScreen.removeMouseListener(this);
                timer.stop() ;
                textDisplay.setText("");
                textDisplay.setText(message.get(messageCounter)) ;
                characterCounter = 0 ; 
                try {
                    TimeUnit.MILLISECONDS.sleep(100) ;
                } 
                catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                gameScreen.addMouseListener(this);
            }
            // code on what to do when the timer is not running (the message has finished being written)
            else{
                // Method that will load a new file when necesary. Mostly will do nothing. 
                // messageUpdater() ; 
                // method for dealing with the display of imagery
                imageUpdater();
                // method for changing the music in the game (Not finished yet)
                musicUpdater() ; 
                // method for dealing with the allocation of evidence into the three evidenceLists. (Image, Text and FullImage)
                evidenceUpdater() ; 
                // method for the formatting of text in the textDisplay
                formatUpdater();
                // code that will print out the character name and text to be displayed
                characterNameDisplay.setText(message.get(messageCounter)) ;
                textDisplay.setText("");
                messageCounter++ ;
                // timer that will help write out the textDisplay. See actionPerformed method
                timer.start();
            }
        }else{
            System.out.println(gameScreen.getFocusOwner()) ; 
        }
    }

    public void messageUpdater() {
        // switch(message.get(messageCounter)){
        //    case "Load" : 
        //        messageCounter++ ; 
        // }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    public void imageUpdater(){
        messageCounter++ ; 
        switch(message.get(messageCounter)){
            // Background: These are the visuals that will be covered by anything new that appears.
            // Background will delete everything that once was there, so characters and objects will dissappear. 
            // IMPORTANT: Background should be called first in the text document containing commands, before anything else is placed. 
            case "Background" : 
                messageCounter++ ;
                visualLayer.removeAll() ; 
                String BackgroundName = "Ongoing\\Java Projects\\Ace Assistant\\src\\Background\\".concat(message.get(messageCounter).concat(".png") ); 
                ImageIcon BackgroundIcon = new ImageIcon(BackgroundName); 
                JLabel BackgroundHolder = new JLabel(BackgroundIcon);
                BackgroundHolder.setBounds(0 , 0 , visualScreen.getWidth() , visualScreen.getHeight());
                visualLayer.add(BackgroundHolder , Integer.valueOf(0)); 
                visualLayer.validate(); 
                visualLayer.repaint();
                imageUpdater();
                break ;
            // Objects: These are items that appear infront of the characters.
            // They are separate to the background. 
            case "Object" :
                messageCounter++ ; 
                String ObjectName = "Ongoing\\Java Projects\\Ace Assistant\\src\\Object\\".concat(message.get(messageCounter).concat(".png") );
                ImageIcon ObjectIcon = new ImageIcon(ObjectName);
                JLabel ObjectHolder = new JLabel(ObjectIcon);
                ObjectHolder.setBounds(0 , 0, ObjectIcon.getIconWidth() , ObjectIcon.getIconHeight());
                visualLayer.add(ObjectHolder , Integer.valueOf(2)); 
                visualLayer.validate(); 
                visualLayer.repaint();
                imageUpdater();
                break; 
            // Characters: These are the actual characters to be displayed. 
            // They appear infront of backgrounds, but behind Objects 
            case "Character" :
                messageCounter++ ;
                String CharacterName = "Ongoing\\Java Projects\\Ace Assistant\\src\\Character\\".concat(message.get(messageCounter).concat(".png") );
                ImageIcon CharacterIcon = new ImageIcon(CharacterName) ; 
                JLabel CharacterHolder = new JLabel(CharacterIcon);
                messageCounter++ ; 
                int xposition = Integer.valueOf(message.get(messageCounter)) ;
                messageCounter++; 
                int yposition = Integer.valueOf(message.get(messageCounter)) ; 
                CharacterHolder.setBounds(xposition , yposition , CharacterIcon.getIconWidth() , CharacterIcon.getIconHeight()) ;
                visualLayer.add(CharacterHolder , Integer.valueOf(1)) ;
                visualLayer.validate();
                visualLayer.repaint();
                imageUpdater();
                break;
            // Bubble: Places a bubble speech above all other images, that is removed at the end of the next mouseclick by Remove Bubble case
            // Bubble should be used for items that appear momentaringly. 
            // Position will depend on the size of the object. 
            // Elements are added to the message linkedList so that the characterNameDisplay and textDisplay are empty.
            case "Bubble" :
                messageCounter++ ;
                String BubbleName = "Ongoing\\Java Projects\\Ace Assistant\\src\\Bubble\\".concat(message.get(messageCounter).concat(".png") );
                ImageIcon BubbleIcon = new ImageIcon(BubbleName) ;
                JLabel BubbleHolder = new JLabel(BubbleIcon) ;
                BubbleHolder.setBounds((int) (visualScreen.getWidth()/2 - BubbleIcon.getIconWidth()/2 ) ,(int) (visualScreen.getHeight()/2 - BubbleIcon.getIconHeight()/2 ) , BubbleIcon.getIconWidth() , BubbleIcon.getIconHeight() ) ;
                visualLayer.add(BubbleHolder , Integer.valueOf(3)) ; 
                visualLayer.validate(); 
                visualLayer.repaint();
                messageCounter++ ; 
                break ;
            // Remove Bubble: Reomves the bubble that was previously placed.
            // Removes the most recently added item.
            // If we added "Remove Bubble" unnaturally (i.e not via TextReader()), we will remove the Remove Bubble text, as it should not be part of the story.(Main example of this is in presenting evidence in EvidenceScreen)
            case "Remove Bubble" :
                    visualLayer.remove(0);
                    visualLayer.validate(); 
                    visualLayer.repaint();
                    if(message.get(messageCounter- 1 ) != ""){
                        message.remove(messageCounter) ; 
                        System.out.println(message) ; 
                    } ; 

                imageUpdater();
                break ;
        }
    }
    // Todo: Test Temporary case so that we can finally have some audio. 
    // Todo: Create some audio for the game!! (Long term Project)
    // Probably do Repeating (Background music that repeats once it reaches the end) and Temporary (Sound FX that are played once)
    public void musicUpdater() {
        switch(message.get(messageCounter)){
            case "Repeating" :
            if(musicClip != null){
                musicClip.stop();
                musicClip.flush();
            }
                messageCounter++ ; 
                File musicFile = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Music\\".concat(message.get(messageCounter).concat(".wav"))) ;
                if(musicFile.exists()){
                    AudioInputStream musicAudio;
                    try {
                        musicAudio = AudioSystem.getAudioInputStream(musicFile);
                        musicClip = AudioSystem.getClip();
                        musicClip.open(musicAudio) ; 
                        musicClip.start();
                        musicClip.loop(Clip.LOOP_CONTINUOUSLY) ; 
                        messageCounter++ ; 
                    } 
                    catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        e.printStackTrace();
                    }
                }
                break ;
            case "Temporary":
                messageCounter++ ; 
                File soundFXFile = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Music\\".concat(message.get(messageCounter).concat(".wav"))) ;
                if(soundFXFile.exists()){
                    AudioInputStream fXAudio;
                    try {
                        fXAudio = AudioSystem.getAudioInputStream(soundFXFile);
                        Clip fXClip = AudioSystem.getClip();
                        fXClip.open(fXAudio) ; 
                        fXClip.start();
                        while(fXClip.isActive()){
                        gameScreen.removeMouseListener(this);
                        }
                        fXClip.stop() ; 
                        fXClip.flush();
                        gameScreen.addMouseListener(this) ; 
                        messageCounter++ ; 
                    } 
                    catch (UnsupportedAudioFileException | IOException | LineUnavailableException e ) {
                        e.printStackTrace();
                    } 
                }
                break ; 
        }
    }

    // Todo: A Remove Evidence case, so that evidence that is now useless can be removed from the selection list. 
    public void evidenceUpdater() {
        switch(message.get(messageCounter)){
            case "Add Evidence":
                messageCounter++ ; 
                String EvidenceName2 = "Ongoing\\Java Projects\\Ace Assistant\\src\\Evidence(Small)\\".concat(message.get(messageCounter).concat(".png") ); 
                ImageIcon EvidenceImageIcon2 = new ImageIcon(EvidenceName2);
                evidenceImageList.add(evidenceImageList.size() , EvidenceImageIcon2) ;
                File EvidenceFullImageFile = new File("Ongoing\\Java Projects\\Ace Assistant\\src\\Evidence(Full)\\".concat(message.get(messageCounter).concat(".png"))) ;
                if(EvidenceFullImageFile.exists()){
                    ImageIcon EvidenceFullImageIcon = new ImageIcon(EvidenceFullImageFile.getAbsolutePath()) ; 
                    evidenceFullImageList.add(evidenceFullImageList.size() , EvidenceFullImageIcon) ; 
                    messageCounter++ ;  
                    evidenceTextList.add(evidenceTextList.size() , message.get(messageCounter) + " (Press Q to view the full evidence)") ;
                }else{
                    evidenceFullImageList.add(evidenceFullImageList.size() , null) ; 
                    messageCounter++ ; 
                    evidenceTextList.add(evidenceTextList.size() , message.get(messageCounter)) ;
                }
                messageCounter++ ;
                evidenceUpdater();
                break ; 
            default : 
                break ; 
        }
        messageCounter--; 
        imageUpdater();
    }

    public void formatUpdater() {
        switch(message.get(messageCounter)){
                // Thought: Main characters thinking.
                // we add Aide as the next element in message, so when the code reads for what to put in the characterNameDisplay, we get Alex.
            case "Thought" :
                textDisplay.setForeground(Color.CYAN);
                messageCounter++ ; 
                break ;
                // Whisper: Character is whispering
                // Text will be made in grey, to make it harder to read
            case "Whisper" : 
                textDisplay.setForeground(Color.GRAY);
                messageCounter++ ; 
                break ;
            // Testimony: Some Character is giving a testimony. 
            // Text will be green, to differentiate it from normal text. 
            // EvidenceScreen relys on greenforeground to present evidence.
            // Todo: Display LifePoints when the text is green. So probably do it here.
            case "Testimony" :
                textDisplay.setForeground(Color.GREEN);
                messageCounter++ ; 
                break ; 
            default :
            // Most messages will be in white
            // Code probably read someone's name, so no need to increment messageCounter. 
                textDisplay.setForeground(Color.WHITE);
                break ;
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }


    // Code that will write the message for us in the game. While I do not like the if statements much, I think it's the only option here.
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the characterCounter has not reached the end of the text to be displayed, we add the next character to the textdisplay, and increment the characterCounter.
        if(message.get(messageCounter).toCharArray().length > characterCounter ){
            textDisplay.setText(textDisplay.getText() + message.get(messageCounter).charAt(characterCounter)) ;
            characterCounter++ ; 
        }
        // If it has reached the end of the text to be displayed, we remove the timer, and reset the character counter for the next time the method is called. 
        else{
            timer.stop();
            characterCounter = 0 ; 
        }
    }

    
    // Todo: Add an Questioning with the q buttons for the testimony (check text color == green). 
    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
            // If we detect a spacebar, we will activate the mousePressed method
            case ' ' :
                mousePressed(null);
                break ; 
            // This will be the main way to interact with the evidence Screen. 
            // Evidence list will only pop up if there are evidences to show and no bubble is currently present. 
            // Todo: Some small functionality for now. (See class for info)
            case 'e':
                if(!evidenceTextList.isEmpty() && visualLayer.getComponentCountInLayer(Integer.valueOf(3)) == 0){
                    evidenceScreen = new EvidenceScreen(this) ; 
                }
                break;
            // This will be the main way to interact with the setting Screens. 
            // Will only be avaliable if there are no bubbles present. 
            // Completed. More features can be added if needed.
            case 's':
                if(visualLayer.getComponentCountInLayer(Integer.valueOf(3)) == 0){
                    settingScreen = new SettingScreen(this) ; 
                }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

