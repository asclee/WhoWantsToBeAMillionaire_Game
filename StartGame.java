import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

/**
 * Opens a GUI with game rules and different topic buttons that the user can choose to start a game
 * 
 * @author Amber Lee 
 * @version 7/29/16 AM Class
 */
public class StartGame
{
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 400;

    public static void main(String[] args)
    {
        JFrame frame = new GameTopicFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setTitle("Game Topics and Instructions");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
