import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Writes game questions for different topics and creates a GUI with game rules and different topic buttons
 * 
 * @author Amber Lee
 * Credits:
 * Links to the real game show questions worth a million dollars
 * http://thechive.com/2015/08/28/can-you-answer-the-million-dollar-questions-from-who-wants-to-be-a-millionaire-quiz/
 * https://www.buzzfeed.com/staceygrant/is-that-your-final-answer?utm_term=.tcP893AXy#.vjr7KOmX0
 * 
 * Link to the British game show version questions
 * http://millionaire.wikia.com/wiki/David_Edwards
 * 
 * @version 7/29/16 AM Class
 */

public class GameTopicFrame extends JFrame
{
    private GameQuestions compSci;
    private GameQuestions java;
    private GameQuestions million;
    private GameQuestions british;
    
    private JButton buttonCS;
    private JButton buttonJava;
    private JButton buttonMil;
    private JButton buttonBrit;
    
    private Color backgroundBlue = new Color (54,77,255);
    
    class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Object obj = event.getSource();
            if (obj == buttonCS) {
                new MillionaireGameGUI(new MillionaireGame(compSci));
            }
            else if (obj == buttonJava) {
                new MillionaireGameGUI(new MillionaireGame(java));
            }
            else if (obj == buttonMil) {
                new MillionaireGameGUI(new MillionaireGame(million));
            }
            else if (obj == buttonBrit) {
                new MillionaireGameGUI(new MillionaireGame(british));
            }
        }
    }

    /**
     * Constructor to create the frame window with the game rules and different topics
     */
    public GameTopicFrame() {
        JPanel pnlOverall = new JPanel(); //overall panel
        JPanel pnlInstruct = new JPanel(); //add instructions and game rules
        JPanel pnlButtons = new JPanel(); //add the buttons for choosing topic
        JPanel pnlLogo = new JPanel(); //add the millionaire logo pic
        
        ImageIcon logo = new ImageIcon("millionaire.jpg");
        pnlLogo.add(new JLabel(logo));

        String instructText = "Game Rules: There are 14 questions in all, and you must must answer correctly to keep playing. Once you get a question wrong, you are out of the game. You have 2 lifelines that allow you to jump over a question and continue to the next one. Choose a topic below to begin.";
        JTextArea instruct = new JTextArea(4, 30);
        instruct.setText(instructText);
        instruct.setWrapStyleWord(true);
        instruct.setLineWrap(true);
        instruct.setForeground(Color.WHITE);    
        instruct.setBackground(backgroundBlue);
        instruct.setMargin(new Insets(10,10,10,10));
        instruct.setEditable(false);
        pnlInstruct.add(instruct);
        
        pnlButtons.setLayout(new GridLayout(2, 2));
        buttonCS = new JButton("Computer Science Trivia");
        buttonJava = new JButton("Java Trivia");
        buttonMil = new JButton("Million-dollar Questions");
        buttonBrit = new JButton("British Edition");
        pnlButtons.add(buttonCS);
        pnlButtons.add(buttonJava);
        pnlButtons.add(buttonMil);
        pnlButtons.add(buttonBrit);
        
        pnlOverall.setLayout(new BorderLayout());
        pnlOverall.add(pnlLogo, BorderLayout.NORTH);
        pnlOverall.add(pnlInstruct, BorderLayout.CENTER);
        pnlOverall.add(pnlButtons, BorderLayout.SOUTH);
        add(pnlOverall);
        
        // Link the listeners to the buttons
        ActionListener listener1 = new ClickListener();
        buttonCS.addActionListener(listener1);

        ActionListener listener2 = new ClickListener();
        buttonJava.addActionListener(listener2);
        
        ActionListener listener3 = new ClickListener();
        buttonMil.addActionListener(listener3);
        
        ActionListener listener4 = new ClickListener();
        buttonBrit.addActionListener(listener4);
        
        //computer science topic
        compSci = new GameQuestions();
        compSci.addQuestion("A founder of Computer Science introduced an abstract model of a computer in 1936. What was his name?", 0);
        compSci.addChoice("Alan Turing", true, 0, "A");
        compSci.addChoice("James Gosling", false, 0, "B");
        compSci.addChoice("Dennis Ritchie", false, 0, "C");
        compSci.addChoice("Donald Knuth", false, 0, "D");

        compSci.addQuestion("The ENIAC was the first usable electronic computer. What was it originally developed to calculate?", 1);
        compSci.addChoice("Math tables", false, 1, "A");
        compSci.addChoice("Ballistic trajectories", true, 1, "B");
        compSci.addChoice("Aircraft fuel usage", false, 1, "C");
        compSci.addChoice("Credit card bills", false, 1, "D");

        compSci.addQuestion("The ENIAC took up a whole room at the University of Pennsylvania. Of what electronic components was it made?", 2);
        compSci.addChoice("Batteries", false, 2, "A");
        compSci.addChoice("Transistors", false, 2, "B");
        compSci.addChoice("Vacuum tubes", true, 2, "C");
        compSci.addChoice("Integrated circuits", false, 2, "D");

        compSci.addQuestion("The ENIAC was rewired for each new 'program' of instructions. Who came up with the idea of storing the program in the computer?", 3);
        compSci.addChoice("Niklaus Wirth", false, 3, "A");
        compSci.addChoice("John von Neumann", true, 3, "B");
        compSci.addChoice("Bill Gates", false, 3, "C");
        compSci.addChoice("Grace Hopper", false, 3, "D");

        compSci.addQuestion("The first commercial computers developed in the 1950's were called mainframes and were very large and expensive. Who was their primary manufacturer in the 60's and 70's?", 4);
        compSci.addChoice("Honeywell", false, 4, "A");
        compSci.addChoice("Data General", false, 4, "B");
        compSci.addChoice("Microsoft", false, 4, "C");
        compSci.addChoice("IBM", true, 4, "D");

        compSci.addQuestion("What company developed the first mini-computer, the PDP-8, in 1965?", 5);
        compSci.addChoice("IBM", false, 5, "A");
        compSci.addChoice("Hewlett-Packard", false, 5, "B");
        compSci.addChoice("DEC", true, 5, "C");
        compSci.addChoice("Data General", false, 5, "D");

        compSci.addQuestion("Which Nintendo system is a 16-bit machine?", 6);
        compSci.addChoice("NES", false, 6, "A");
        compSci.addChoice("Super NES", true, 6, "B");
        compSci.addChoice("N64", false, 6, "C");
        compSci.addChoice("Game Cube", false, 6, "D");

        compSci.addQuestion("An early micro-computer was built in the garage of Steve Jobs and Steve Wozniak. This was the beginning of Apple Corp. For what application was it first used?", 7);
        compSci.addChoice("word-processing", false, 7, "A");
        compSci.addChoice("email", false, 7, "B"); 
        compSci.addChoice("spreadsheet", true, 7, "C");
        compSci.addChoice("spell-checker", false, 7, "D");

        compSci.addQuestion("Mark Andreessen, a student at the University of Illinois, released an internet browser called Mosaic, the forerunner of Netscape. What protocol did it use?", 8);
        compSci.addChoice("TCP/IP", false, 8, "A");
        compSci.addChoice("HTTP", true, 8, "B");
        compSci.addChoice("SMTP", false, 8, "C");
        compSci.addChoice("FTP", false, 8, "D");

        compSci.addQuestion("Which 'object-oriented' High Level Language was developed at Sun Microsystems by James Gosling and announced in 1995?", 9);
        compSci.addChoice("FORTRAN", false, 9, "A");
        compSci.addChoice("C", false, 9, "B");
        compSci.addChoice("Java", true, 9, "C");
        compSci.addChoice("C++", false, 9, "D");

        compSci.addQuestion("What was the first computer bug?", 10);
        compSci.addChoice("spider", false, 10, "A");
        compSci.addChoice("fly", false, 10, "B");
        compSci.addChoice("mosquito", false, 10, "C");
        compSci.addChoice("moth", true, 10, "D");

        compSci.addQuestion("Who invented C++?", 11);
        compSci.addChoice("Bjarne Stroustrup", true, 11, "A");
        compSci.addChoice("James Gosling", false, 11, "B");
        compSci.addChoice("Larry Wall", false, 11, "C");
        compSci.addChoice("Alan Cooper", false, 11, "D");

        compSci.addQuestion("Which person wrote 'Information Flow in Large Communication Nets', a paper that included the initial concept of the Internet?", 12);
        compSci.addChoice("Grace Hopper", false, 12, "A");
        compSci.addChoice("Ada Lovelace", false, 12, "B");
        compSci.addChoice("John Backus", false, 12, "C");
        compSci.addChoice("Leonard Kleinrock", true, 12, "D");

        compSci.addQuestion("Which company is Java a currently trademark of?", 13);
        compSci.addChoice("Sun Microsystems", false, 13, "A");
        compSci.addChoice("Oracle", true, 13, "B");
        compSci.addChoice("Microsoft", false, 13, "C");
        compSci.addChoice("Apple", false, 13, "D");
        
        //java topic
        java = new GameQuestions();
        java.addQuestion("Who invented Java?", 0);
        java.addChoice("Steve Jobs", false, 0, "A");
        java.addChoice("Bill Gates", false, 0, "B");
        java.addChoice("Guido van Rossum", false, 0, "C");
        java.addChoice("James Gosling", true, 0, "D");
        
        java.addQuestion("What is BlueJ?", 1);
        java.addChoice("Spinoff of Java", false, 1, "A");
        java.addChoice("Programming environment", true, 1, "B");
        java.addChoice("Rare species of bird", false, 1, "C");
        java.addChoice("Computer game", false, 1, "D");
        
        java.addQuestion("Which method is called first when a program is executed?", 2);
        java.addChoice("Main", false, 2, "A");
        java.addChoice("System.out.print", false, 2, "B");
        java.addChoice("main", true, 2, "C");
        java.addChoice("public class", false, 2, "D");
        
        java.addQuestion("What is the return type of a mutator method usually specified as?", 3);
        java.addChoice("String", false, 3, "A");
        java.addChoice("void", true, 3, "B");
        java.addChoice("int", false, 3, "C");
        java.addChoice("no return type", false, 3, "D");
        
        java.addQuestion("What is a collection of related Java classes called?", 4);
        java.addChoice("Package", true, 4, "A");
        java.addChoice("Class group", false, 4, "B");
        java.addChoice("Toolkit", false, 4, "C");
        java.addChoice("Library", false, 4, "D");
        
        java.addQuestion("What must you include in the documentation for an accessor method besides the purpose of the method?", 5);
        java.addChoice("@param description", false, 5, "A");
        java.addChoice("@author name", false, 5, "B");
        java.addChoice("@version number", false, 5, "C");
        java.addChoice("none of the above", true, 5, "D");
        
        java.addQuestion("Which reserved word refers to the implicit parameter?", 6);
        java.addChoice("super", false, 6, "A");
        java.addChoice("instanceof", false, 6, "B");
        java.addChoice("this", true, 6, "C");
        java.addChoice("case", false, 6, "D");
        
        java.addQuestion("Which symbol represents the modulus in Java?", 7);
        java.addChoice("%", true, 7, "A");
        java.addChoice("&", false, 7, "B");
        java.addChoice("||", false, 7, "C");
        java.addChoice("~", false, 7, "D");
        
        java.addQuestion("What is the value of the variable ratio after it has been assigned like this? double ratio = 2/3;", 8);
        java.addChoice("2/3", false, 8, "A");
        java.addChoice("0.66666666667", false, 8, "B");
        java.addChoice("0.67", false, 8, "C");
        java.addChoice("0.0", true, 8, "D");
        
        java.addQuestion("In Java lexicographic order, which order would the words 'Art', 'grass', 'Zebra', and 'ant' be in?", 9);
        java.addChoice("ant, grass, Art, Zebra", false, 9, "A");
        java.addChoice("ant, Art, grass, Zebra", false, 9, "B");
        java.addChoice("Zebra, grass, Art, ant", false, 9, "C");
        java.addChoice("Art, Zebra, ant, grass", true, 9, "D");
        
        java.addQuestion("A programmer can use which reserved word to declare a data type with a finite set of possible values?", 10);
        java.addChoice("new", false, 10, "A");
        java.addChoice("enum", true, 10, "B");
        java.addChoice("switch", false, 10, "C");
        java.addChoice("const", false, 10, "D");
        
        java.addQuestion("What is the syntax for declaring an array list that can store character values?", 11);
        java.addChoice("new ArrayList<Char>()", false, 11, "A");
        java.addChoice("new ArrayList<Character>()", true, 11, "B");
        java.addChoice("new ArrayList<char>()", false, 11, "C");
        java.addChoice("new ArrayList<character>()", false, 11, "D");
        
        java.addQuestion("Which of the following can access an instance variable declared with the reserved word 'protected'?", 12);
        java.addChoice("Only the class itself", false, 12, "A");
        java.addChoice("Only the subclass", false, 12, "B");
        java.addChoice("Both class and subclass", true, 12, "C");
        java.addChoice("None of the above", false, 12, "D");
        
        java.addQuestion("Which of the following is NOT Java?", 13);
        java.addChoice("Coffee", false, 13, "A");
        java.addChoice("Programming language", false, 13, "B");
        java.addChoice("Indonesian island", false, 13, "C");
        java.addChoice("An exotic flower", true, 13, "D");
        
        //Real million-dollar questions from the actual game show
        //note: questions taken from these links
        //http://thechive.com/2015/08/28/can-you-answer-the-million-dollar-questions-from-who-wants-to-be-a-millionaire-quiz/
        //https://www.buzzfeed.com/staceygrant/is-that-your-final-answer?utm_term=.tcP893AXy#.vjr7KOmX0
        
        million = new GameQuestions();
        million.addQuestion("Who did artist Grant Wood use as the model for the farmer in his classic painting 'American Gothic'?", 0);
        million.addChoice("Traveling salesman", false, 0, "A");
        million.addChoice("His dentist", true, 0, "B");
        million.addChoice("Local sheriff", false, 0, "C");
        million.addChoice("His butcher", false, 0, "D");
        
        million.addQuestion("In addition to his career as an astrologer and 'prophet', Nostradamus published a 1555 treatise that included a section on what?", 1);
        million.addChoice("Training parrots to talk", false, 1, "A");
        million.addChoice("Cheating at card games", false, 1, "B");
        million.addChoice("Digging graves", false, 1, "C");
        million.addChoice("Making jams and jellies", true, 1, "D");
        
        million.addQuestion("'Nephelococcygia' is the practice of doing what?", 2);
        million.addChoice("Finding shapes in clouds", true, 2, "A");
        million.addChoice("Sleeping with open eyes", false, 2, "B");
        million.addChoice("Breaking glass", false, 2, "C");
        million.addChoice("Swimming in freezing water", false, 2, "D");
        
        million.addQuestion("Which of these US presidents appeared on the television series 'Laugh-in'?", 3);
        million.addChoice("Lyndon Johnson", false, 3, "A");
        million.addChoice("Richard Nixon", true, 3, "B");
        million.addChoice("Jimmy Carter", false, 3, "C");
        million.addChoice("Gerald Ford", false, 3, "D");
        
        million.addQuestion("For ordering his favorite beverages on demand, Lyndon B. Johnson had four buttons installed in the Oval Office labeled 'coffee', 'tea', 'Coke', and what?", 4);
        million.addChoice("Fresca", true, 4, "A");
        million.addChoice("Yoo-hoo", false, 4, "B");
        million.addChoice("V8", false, 4, "C");
        million.addChoice("A&W", false, 4, "D");
        
        million.addQuestion("Now used to refer to a cat, the word 'tabby' is derived from the name of a district of what world captial?", 5);
        million.addChoice("New Delhi", false, 5, "A");
        million.addChoice("Cairo", false, 5, "B");
        million.addChoice("Baghdad", true, 5, "C");
        million.addChoice("Moscow", false, 5, "D");
        
        million.addQuestion("Which letter must appear at the beginning of the registration number of all non-military aircraft in the US?", 6);
        million.addChoice("N", true, 6, "A");
        million.addChoice("A", false, 6, "B");
        million.addChoice("U", false, 6, "C");
        million.addChoice("L", false, 6, "D");
        
        million.addQuestion("The US icon 'Uncle Sam' was based on Samuel Wilson, who worked during the War of 1812 as a what?", 7);
        million.addChoice("Weapons mechanic", false, 7, "A");
        million.addChoice("Historian", false, 7, "B");
        million.addChoice("Mail deliverer", false, 7, "C");
        million.addChoice("Meat inspector", true, 7, "D");
        
        million.addQuestion("Who delivered the less famous two-hour speech that preceded Abraham Lincoln's two-minute Gettysburg Address?", 8);
        million.addChoice("Wendell Phillips", false, 8, "A");
        million.addChoice("Daniel Webster", false, 8, "B");
        million.addChoice("Robert G. Ingersoll", false, 8, "C");
        million.addChoice("Edward Everett", true, 8, "D");
        
        million.addQuestion("Which of the following men does not have a chemical element named for him?", 9);
        million.addChoice("Albert Einstein", false, 9, "A");
        million.addChoice("Niels Bohr", false, 9, "B");
        million.addChoice("Isaac Newton", true, 9, "C");
        million.addChoice("Enrico Fermi", false, 9, "D");
        
        million.addQuestion("Which of these ships was not one of the three taken over by colonists during the Boston Tea Party?", 10);
        million.addChoice("William", true, 10, "A");
        million.addChoice("Eleanor", false, 10, "B");
        million.addChoice("Dartmouth", false, 10, "C");
        million.addChoice("Beaver", false, 10, "D");
        
        million.addQuestion("Which First Lady was a ninth-generation descendant of Pocahontas?", 11);
        million.addChoice("Helen Taft", false, 11, "A");
        million.addChoice("Edith Wilson", true, 11, "B");
        million.addChoice("Bess Truman", false, 11, "C");
        million.addChoice("Mamie Eisenhower", false, 11, "D");
        
        million.addQuestion("Khrushchev's famous 1960 'shoe-banging' outburst at the U.N. was in response to a delegate from what nation?", 12);
        million.addChoice("Australia", false, 12, "A");
        million.addChoice("The Netherlands", false, 12, "B");
        million.addChoice("The Philippines", true, 12, "C");
        million.addChoice("Turkey", false, 12, "D");
        
        million.addQuestion("Which of the following landlocked countries is entirely contained within another country?", 13);
        million.addChoice("Lesotho", true, 13, "A");
        million.addChoice("Burkina Faso", false, 13, "B");
        million.addChoice("Mongolia", false, 13, "C");
        million.addChoice("Luxembourg", false, 13, "D");
        
        //British Version
        //note: questions taken from this link:
        //http://millionaire.wikia.com/wiki/David_Edwards
        british = new GameQuestions();
        
        british.addQuestion("Which of these is a drink made with fruit juices, spices, and often wine or spirits?", 0);
        british.addChoice("Knock", false, 0, "A");
        british.addChoice("Thump", false, 0, "B");
        british.addChoice("Punch", true, 0, "C");
        british.addChoice("Whack", false, 0, "D");
        
        british.addQuestion("A large, portable cassette recorder with built-in speakers is known as a ghetto...what?", 1);
        british.addChoice("Blaster", true, 1, "A");
        british.addChoice("Blower", false, 1, "B");
        british.addChoice("Blarer", false, 1, "C");
        british.addChoice("Banger", false, 1, "D");
        
        british.addQuestion("Which of these phrases refers to a brief success?", 2);
        british.addChoice("Blaze in the pot", false, 2, "A");
        british.addChoice("Spark in the tub", false, 2, "B");
        british.addChoice("Flare in the jug", false, 2, "C");
        british.addChoice("Flash in the pan", true, 2, "D");
        
        british.addQuestion("Which of these is a type of hat?", 3);
        british.addChoice("Sausage roll", false, 3, "A");
        british.addChoice("Pork pie", true, 3, "B");
        british.addChoice("Scotch egg", false, 3, "C");
        british.addChoice("Potato crisp", false, 3, "D");
        
        british.addQuestion("Which of these is a duty levied on the legal recognition of certain documents?", 4);
        british.addChoice("Off duty", false, 4, "A");
        british.addChoice("Stamp duty", true, 4, "B");
        british.addChoice("Heavy-duty", false, 4, "C");
        british.addChoice("Jury duty", false, 4, "D");
        
        british.addQuestion("Which singer was regularly ridiculed by Morecambe and Wise in their TV shows?", 5);
        british.addChoice("Rolf Harris", false, 5, "A");
        british.addChoice("Des O'Connor", true, 5, "B");
        british.addChoice("Gracie Fields", false, 5, "C");
        british.addChoice("Barry Manilow", false, 5, "D");
        
        british.addQuestion("Which of these is a game played by Harry Potter and his friends?", 6);
        british.addChoice("Qwerty", false, 6, "A");
        british.addChoice("Quibble", false, 6, "B");
        british.addChoice("Quidditch", true, 6, "C");
        british.addChoice("Quantum", false, 6, "D");
        
        british.addQuestion("Which city hosted the 2001 FA Cup Final?", 7);
        british.addChoice("London", false, 7, "A");
        british.addChoice("Birmingham", false, 7, "B");
        british.addChoice("Manchester", false, 7, "C");
        british.addChoice("Cardiff", true, 7, "D");
        
        british.addQuestion("Which of these have to pass a test on 'The Knowledge' to get a licence in London?", 8);
        british.addChoice("Taxi drivers", true, 8, "A");
        british.addChoice("Bus drivers", false, 8, "B");
        british.addChoice("Police officers", false, 8, "C");
        british.addChoice("Ambulance drivers", false, 8, "D");
        
        british.addQuestion("According to legend, the composer Salieri poisoned which rival?", 9);
        british.addChoice("Brahms", false, 9, "A");
        british.addChoice("Haydn", false, 9, "B");
        british.addChoice("Liszt", false, 9, "C");
        british.addChoice("Mozart", true, 9, "D");
        
        british.addQuestion("What is the real first name of Home Secretary Jack Straw?", 10);
        british.addChoice("Justin", false, 10, "A");
        british.addChoice("James", false, 10, "B");
        british.addChoice("John", true, 10, "C");
        british.addChoice("Joseph", false, 10, "D");
        
        british.addQuestion("What kind of creature is a 'grackle'?", 11);
        british.addChoice("Lizard", false, 11, "A");
        british.addChoice("Bird", true, 11, "B");
        british.addChoice("Fish", false, 11, "C");
        british.addChoice("Beetle", false, 11, "D");
        
        british.addQuestion("The Newlyn School of the late 19th century is associated with which group of people?", 12);
        british.addChoice("Method actors", false, 12, "A");
        british.addChoice("Circus entertainers", false, 12, "B");
        british.addChoice("Painters", true, 12, "C");
        british.addChoice("Musicians", false, 12, "D");
        
        british.addQuestion("If you planted the seeds of 'Quercus robur', what would grow?", 13);
        british.addChoice("Trees", true, 13, "A");
        british.addChoice("Flowers", false, 13, "B");
        british.addChoice("Vegetables", false, 13, "C");
        british.addChoice("Grain", false, 13, "D");
    }
}