import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is the user interface for Who Wants To Be A Millionaire.  
 *  
 * @author Brendan Bull, from http://www4.ncsu.edu/~spbalik/SummerCamp/code.html
 * @version unknown
 * 
 * @author Amber Lee
 * @version 7/29/16 AM Class
 */

public class MillionaireGameGUI extends JFrame implements ActionListener, WindowListener {
    private JScrollPane pnlScroll;
    private JTextArea txtQuestion;    
    private JLabel lblMoneyWon;
    private JLabel lblQuestionWorth;
    private JLabel[] lblAnswers;
    private JButton[] btnAnswers;
    private JButton btnNextQuestion;
    private JButton btnQuit;
    private JButton btnJump;
    
    private int qCount;
    private int jumpsLeft;

    private Color backgroundBlue = new Color (54,77,255);
    private Color backgroundDarkBlue = new Color(60,64,186);

    private MillionaireGame mg;

    private final int DISPLAYABLE_LINES = 5; //This number of lines
    //that can fit into the question
    //area without scroll bars.        
    private final int NUM_ANSWERS = 4;

    /** 
     * Createa a MillionaireGameGUI object and arranges the GUI widgets.
     *
     * @param _mg a MillionaireGame object
     */

    public MillionaireGameGUI (MillionaireGame _mg) {
        mg = _mg;
        qCount = 0;
        jumpsLeft = 2;

        Container c = getContentPane();        
        c.setLayout (new BorderLayout());

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout (2,1));  // grid of 2 rows, 1 col   
        pnlCenter.add (initLogoArea()); // add the millionaire logo pic
        pnlCenter.add (initAnswerPane()); // add the panel with questions and answers

        c.add(pnlCenter, BorderLayout.CENTER);  // sets pnlCenter's position as center in the container
        c.add(initBottomPane(), BorderLayout.SOUTH); // adds the bottom panel of next question/quit

        addWindowListener(this);                
        setTitle("Who Wants to be a Millionaire");
        setLocation(300,100);
        setSize(450, 520);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Puts the who wants to be a millionaire image on a JPanel and returns the panel to the constructor.
     * 
     * @return a JPanel with the millionaire image on it.
     */

    private JComponent initLogoArea() {

        JPanel pnlLogo = new JPanel();
        ImageIcon logo = new ImageIcon("millionaire.jpg");

        //You can't add an image directly to a panel.  To get around this,
        //I've added the image to a JLabel and added the JLabel to the panel.
        pnlLogo.add(new JLabel(logo));

        return pnlLogo;
    }

    /**
     * Create a panel that contains the question, answer, and money won widgets.
     *
     * @return a JPanel with the question/answer area.          
     */

    private JComponent initAnswerPane() {

        JPanel pnlAnswer = new JPanel(); //the entire panel including question + answers + money won
        JPanel pnlCenter = new JPanel();     // the answers   
        JPanel pnlSouth = new JPanel();    // the money won
        JPanel pnlNorth = new JPanel(); // the question (goes into pnlScroll, then pnlNorth)
        JPanel pnlEast = new JPanel(); // shows how much the question is worth

        pnlAnswer.setLayout (new BorderLayout());
        pnlNorth.setLayout(new BorderLayout());
        
        // Question text goes into pnlScroll, then pnlNorth
        txtQuestion = new JTextArea(3,25); 
        txtQuestion.setText("Click 'Start Game' to start.");
        txtQuestion.setFont(new Font ("Courier", Font.PLAIN, 12));                
        txtQuestion.setWrapStyleWord(true);  
        txtQuestion.setForeground (Color.WHITE);    
        txtQuestion.setBackground (backgroundBlue);     
        txtQuestion.setEditable(false);     

        //Makes the question scrollable in case the question is really long
        pnlScroll = new JScrollPane(txtQuestion);

        //Make moneyWorth label and add it to pnlEast
        lblQuestionWorth = new JLabel();
        pnlEast.add(lblQuestionWorth);
        pnlEast.setBackground(backgroundDarkBlue);
        lblQuestionWorth.setForeground(Color.WHITE);  

        //Add pnlScroll and pnlEast inside pnlNorth, question text on left and money worth on right 
        pnlNorth.setBackground (backgroundBlue);
        pnlNorth.add(pnlScroll, BorderLayout.CENTER);   
        pnlNorth.add(pnlEast, BorderLayout.EAST);
        pnlNorth.setPreferredSize(new Dimension (410,70));
  
        lblMoneyWon = new JLabel ("Money Won So Far: $0");                
        pnlSouth.add (lblMoneyWon);   
        pnlSouth.setBackground (backgroundBlue);
        lblMoneyWon.setForeground(Color.WHITE);                 

        initBtnAnswers();
        initLblAnswers();

        String[] s = {"", "", "", ""};
        setLblAnswers(s);

        String[] btnLabels = {"A","B","C","D"};
        for (int i = 0; i < NUM_ANSWERS; i++) {
            btnAnswers[i].setPreferredSize (new Dimension (50,30));
            //btnAnswers[i].setPreferredSize (new Dimension (50,60));        
            pnlCenter.add (btnAnswers[i]);
            lblAnswers[i].setPreferredSize (new Dimension (160, 30));
            //lblAnswers[i].setPreferredSize (new Dimension (135, 60));  
            pnlCenter.add (lblAnswers[i]);              
            btnAnswers[i].setBackground (backgroundBlue);  
            btnAnswers[i].setForeground (Color.white);
            lblAnswers[i].setForeground (backgroundDarkBlue);             
        }

        enableBtnAnswer(false);   
        pnlAnswer.add (pnlNorth, BorderLayout.NORTH);     
        pnlAnswer.add (pnlCenter ,BorderLayout.CENTER);       
        pnlAnswer.add (pnlSouth, BorderLayout.SOUTH);

        return pnlAnswer;                                 
    }

    /**
     * Create a panel that contains the "quit", "next question", and "jump question" buttons.
     *
     * @return a JPanel with the "quit", "next question", and "jump question" buttons.
     */

    private JComponent initBottomPane () {
        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout(new BorderLayout());
        JPanel nextOrQuit = new JPanel();
        nextOrQuit.setLayout(new GridLayout(1,2));
        JPanel jumpQuestion = new JPanel();
        
        Icon jump = new ImageIcon("jump.gif");
        btnJump = new JButton("Jump the Question (" + jumpsLeft + ")", jump);
        btnJump.addActionListener(this);
        btnJump.setEnabled(false);

        Icon question = new ImageIcon ("question.gif");
        btnNextQuestion = new JButton ("Start Game", question);
        btnNextQuestion.addActionListener(this);

        Icon stop = new ImageIcon ("stop.jpg");
        btnQuit = new JButton ("Quit", stop);
        btnQuit.addActionListener(this);       

        nextOrQuit.add(btnNextQuestion); 
        nextOrQuit.add(btnQuit);
        jumpQuestion.add(btnJump);
        
        pnlBottom.add(nextOrQuit, BorderLayout.SOUTH);
        pnlBottom.add(jumpQuestion, BorderLayout.CENTER);

        return pnlBottom;
    }

    /**
     * Creates the labels used to display the answers.
     */

    private void initLblAnswers() {
        lblAnswers = new JLabel[NUM_ANSWERS]; 

        for (int i = 0; i < NUM_ANSWERS; i++) {
            lblAnswers[i] = new JLabel();
        }
    }

    /**
     * Creates the buttons used for answering questions.     
     */

    private void initBtnAnswers() {
        String[] btnLabels = {"A","B","C","D"};
        btnAnswers = new JButton[NUM_ANSWERS];

        for (int i = 0; i < NUM_ANSWERS; i++) {
            btnAnswers[i] = new JButton(btnLabels[i]);
            btnAnswers[i].addActionListener(this);
        }
    }

    /**
     * Changes the text of the answer labels.
     *
     * @param answers An array of strings that contains possible answers.
     *                answers[0] = answer A, answers[1] = answer B, etc.
     */

    public void setLblAnswers(String[] answers) {

        if (answers.length < NUM_ANSWERS) 
            return;

        for (int i = 0; i < NUM_ANSWERS; i++) {
            lblAnswers[i].setText(answers[i]);
        }            
    }

    /**
     * Enables or disables all of the answer buttons.
     *
     * @param enable - The answer buttons are enabled if "enable" is true.
     *                 They are disabled if "enable" is false.
     */

    public void enableBtnAnswer (boolean enable) {

        for (int i = 0; i < NUM_ANSWERS; i++) { 
            btnAnswers[i].setEnabled(enable);
        }
    }

    /**
     * Called when a button is clicked.
     *     
     * @param e The source of the button click.
     */

    public void actionPerformed (ActionEvent e) {
        final int FIRST_Q = 0;
        final int LAST_Q = 13;
        
        //action to execute if user pressed get next question
        if (e.getSource() == btnNextQuestion) {
            if (qCount == FIRST_Q) {
                btnNextQuestion.setText("Next Question");
                btnJump.setEnabled(true);
            }
            else if (jumpsLeft != 0 && qCount != LAST_Q) {
                btnJump.setEnabled(true);
            }
            
            btnNextQuestion.setEnabled(false);
            enableBtnAnswer(true);      
            mg.nextQuestion(qCount);      
            txtQuestion.setText(mg.getQuestion());
            lblQuestionWorth.setText("Money Level: $" + mg.getQuestionWorth(qCount));

            //Creates an array of Strings used to set the label text
            String[] answers = new String[NUM_ANSWERS];
            for (int i = 0; i < NUM_ANSWERS; i++) {
                answers[i] = mg.getTextForAnswer(btnAnswers[i].getText());
            }
            setLblAnswers (answers);
            
            qCount++;
        }
        
        //Jump button pressed
        if (e.getSource() == btnJump) {
            jumpsLeft--;
            btnJump.setText("Jump the Question (" + jumpsLeft + ")");
            if (jumpsLeft == 0 || qCount == LAST_Q) {
                btnJump.setEnabled(false);
            }
            
            btnNextQuestion.setEnabled(false);
            enableBtnAnswer(true);      
            mg.nextQuestion(qCount);      
            txtQuestion.setText(mg.getQuestion());
            lblQuestionWorth.setText("Money Level: $" + mg.getQuestionWorth(qCount));

            //Creates an array of Strings used to set the label text
            String[] answers = new String[NUM_ANSWERS];
            for (int i = 0; i < NUM_ANSWERS; i++) {
                answers[i] = mg.getTextForAnswer(btnAnswers[i].getText());
            }
            setLblAnswers (answers);
            
            qCount++;
        }

        //Quit button pressed

        if (e.getSource() == btnQuit) {
            System.exit(0);
        }

        //One of the answer buttons was pressed

        for (int i = 0; i < NUM_ANSWERS; i++) {

            if (e.getSource() == btnAnswers[i]) {
                boolean correct = mg.isCorrectAnswer(btnAnswers[i].getText());

                //The player got the answer correct
                if (correct) {
                    lblMoneyWon.setForeground(Color.GREEN);
                    if (mg.hasWon()) {
                        lblMoneyWon.setText("You won 1 million dollars!!!");
                        btnNextQuestion.setEnabled(false);
                    }
                    else {
                        lblMoneyWon.setText("Money Won So Far: $" + mg.getMoneyWon());
                        btnJump.setEnabled(false);
                        btnNextQuestion.setEnabled(true);
                    }
                }

                //The player got the answer wrong
                else {
                    lblMoneyWon.setForeground(Color.RED);
                    lblMoneyWon.setText("You lose");
                    btnNextQuestion.setEnabled(false);
                    btnJump.setEnabled(false);
                }                      

                enableBtnAnswer(false);                
            }
        }    
    }

    /**
     * Exits the program when the window is closed.
     *
     * @param we - The event triggered by the window closing.
     */

    public void windowClosing (WindowEvent we) {
        System.exit(0);  
    }

    // Because this class is implementing WindowListener, I'm required
    // to provide implementations for these methods.  However, I don't
    // want anything special to happen when these window events are 
    // triggered so I've just provided dummy implementations to make the
    // the compiler happy.

    public void windowClosed(WindowEvent we) {}

    public void windowActivated (WindowEvent we) {}

    public void windowOpened (WindowEvent we) {}    

    public void windowDeactivated (WindowEvent we) {}

    public void windowDeiconified (WindowEvent we) {}

    public void windowIconified (WindowEvent we) {}
}