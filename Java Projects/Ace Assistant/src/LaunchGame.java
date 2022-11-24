import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout ;
import java.awt.Dimension;
import javax.swing.BorderFactory ; 
import java.awt.Color ;
import java.io.File ; 

// Code that will create the three main sections of the game. 
// The visual Screen contains all the visuals stuff that the end user will see. 
// The textScreen will contain the 2 texts panels.
// characterScreen will contain the name of the character that is currently speaking,whispering,thinking ect.
// textScreen will contain what will be spoken by the characters.

public class LaunchGame {

    // file won't be used much here. It will be passed onto the Game object at the bottom, where it will be needed. 
    LaunchGame(JFrame gameScreen , File file){
        gameScreen.setSize(750 , 750);
        gameScreen.setResizable(false);
        gameScreen.setLayout(new BorderLayout());

        Border textScreenBorder = BorderFactory.createLineBorder(Color.WHITE , 1) ; 
        JPanel visualScreen = new JPanel() ; 
        JPanel textScreen = new JPanel() ;
        JPanel characterScreen = new JPanel() ;
        JPanel EmptyScreen2 = new JPanel() ;
        JPanel EmptyScreen = new JPanel() ;
        JPanel TopTextHolder = new JPanel() ; 

        
        TopTextHolder.setOpaque(false);

        textScreen.setLayout(new BorderLayout());
        textScreen.setPreferredSize(new Dimension(gameScreen.getWidth() , 150)) ; 
        textScreen.setBackground(Color.BLACK);

        characterScreen.setPreferredSize(new Dimension(100 , 35)); 
        characterScreen.setBackground(Color.BLUE);
        characterScreen.setBorder(textScreenBorder);

        EmptyScreen.setPreferredSize(new Dimension(620 , 35));
        // .setBackground(Color.ORANGE);
        EmptyScreen.setOpaque(false);

        EmptyScreen2.setPreferredSize(new Dimension(102 , 100));
        // EmptyScreen2.setBackground(Color.PINK); 
        EmptyScreen2.setOpaque(false);

        visualScreen.setPreferredSize(new Dimension(gameScreen.getWidth()  , gameScreen.getHeight() - textScreen.getHeight()));
        visualScreen.setBackground(Color.BLACK);

        TopTextHolder.add(characterScreen) ; 
        TopTextHolder.add(EmptyScreen) ; 
        textScreen.add(TopTextHolder, BorderLayout.NORTH) ;
        textScreen.add(EmptyScreen2 , BorderLayout.WEST) ; 
        gameScreen.add(textScreen, BorderLayout.SOUTH) ;
        gameScreen.add(visualScreen , BorderLayout.CENTER) ;

        
        // Images won't show up unless we place these two. 
        gameScreen.validate(); 
        gameScreen.repaint();
        new Game(gameScreen , visualScreen, textScreen , characterScreen , file) ; 
    }

}
