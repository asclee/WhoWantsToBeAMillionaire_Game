import java.io.*;
import java.util.*;

/**
 * Extracts the questions and answers and passes them on to the game GUI. Keeps track of money won so far.
 * 
 * @author Suzanne Balik, from http://www4.ncsu.edu/~spbalik/SummerCamp/code.html
 * @version 11 Oct 2001
 * 
 * @author Amber Lee
 * @version 7/29/16 AM Class
 */

public class MillionaireGame {

    private final int NUM_CHARS_PER_LINE = 50;

    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    
    private int moneyWon;
    
    private GameQuestions category;

    /**
     * Constructor for class MillionaireGame
     * 
     * @param ctg the GameQuestions object for a certain topic/category
     */
    public MillionaireGame(GameQuestions ctg) {
        category = ctg;
        moneyWon = 0;
    }

    /**
     * Extracts the text and answers of the next question in the game, and sets the amount of money won
     * 
     * @param qCount the question index number
     */
    public void nextQuestion(int qCount) {
        if (qCount == 0) 
            moneyWon = 500;
        else if (qCount == 1)
            moneyWon = 1000;
        else if (qCount == 2)
            moneyWon = 2000;
        else if (qCount == 3)
            moneyWon = 3000;
        else if (qCount == 4)
            moneyWon = 5000;
        else if (qCount == 5)
            moneyWon = 7000;
        else if (qCount == 6)
            moneyWon = 10000;
        else if (qCount == 7)
            moneyWon = 20000;
        else if (qCount == 8)
            moneyWon = 30000;
        else if (qCount == 9)
            moneyWon = 50000;
        else if (qCount == 10)
            moneyWon = 100000;
        else if (qCount == 11)
            moneyWon = 250000;
        else if (qCount == 12)
            moneyWon = 500000;
        else if (qCount == 13)
            moneyWon = 1000000;

        question = category.extractQuestion(qCount);

        answerA = category.extractAnswerChoice(qCount,"A");
        answerB = category.extractAnswerChoice(qCount,"B");
        answerC = category.extractAnswerChoice(qCount,"C");
        answerD = category.extractAnswerChoice(qCount,"D");

        correctAnswer = category.extractAnswer(qCount);
    }

    /**
     * Gets the question text
     * 
     * @return the question text
     */
    public String getQuestion () {
        return question;
    }
    
    /**
     * Gets how much money the question is worth
     * 
     * @param qCount the question index count
     * @return the amount of money
     */
    public String getQuestionWorth(int qCount)
    {
        String questionWorth = "";
        
        if (qCount == 0) 
            questionWorth = "500";
        else if (qCount == 1)
            questionWorth = "1000";
        else if (qCount == 2)
            questionWorth = "2000";
        else if (qCount == 3)
            questionWorth = "3000";
        else if (qCount == 4)
            questionWorth = "5000";
        else if (qCount == 5)
            questionWorth = "7000";
        else if (qCount == 6)
            questionWorth = "10000";
        else if (qCount == 7)
            questionWorth = "20000";
        else if (qCount == 8)
            questionWorth = "30000";
        else if (qCount == 9)
            questionWorth = "50000";
        else if (qCount == 10)
            questionWorth = "100000";
        else if (qCount == 11)
            questionWorth = "250000";
        else if (qCount == 12)
            questionWorth = "500000";
        else if (qCount == 13)
            questionWorth = "1000000";
            
        return questionWorth;
    }

    /**
     * Gets the text for the specified answer choice letter
     * 
     * @param answer the answer choice letter
     * @return the text of the answer choice
     */
    public String getTextForAnswer (String answer) {
        if (answer.equals("A"))
            return answerA;
        if (answer.equals("B"))
            return answerB;
        if (answer.equals("C"))
            return answerC;
        if (answer.equals("D"))
            return answerD;
        else return "";
    }

    /**
     * Compares the user's answer to the correct answer
     * 
     * @param guess the user's answer choice letter
     * @return the boolean true/false if the user's answer is correct/wrong
     */
    public boolean isCorrectAnswer (String guess) {
        return (guess.equals(correctAnswer));
    }

    /**
     * Checks whether the user has won a milllion dollars or not
     * 
     * @return the boolean true/false if the user won a million dollars or not
     */
    public boolean hasWon () {
        return (moneyWon == 1000000);
    }

    /**
     * Gets the amount of money won by the user so far
     * 
     * @return the amount of money won
     */
    public String getMoneyWon () {
        String money = "";
        if (moneyWon == 1000000)
            money = "$1,000,000";
        else
            //money = money + "$" + moneyWon/1000 + "," + "000";
            money = "" + moneyWon;
        return money;
    }
}
