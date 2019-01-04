import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 * Contains methods for writing new category of questions
 * 
 * @author Suzanne Balik, from http://www4.ncsu.edu/~spbalik/SummerCamp/code.html
 * @version 11 Oct 2001
 * 
 * @author Amber Lee 
 * @version 7/29/16
 */
public class GameQuestions
{
    // instance variable
    private String[] questions;
    private String[][] choices;
    private String[] answers;
    
    private final int NUM_CHARS_PER_LINE = 50;
    private final int NUM_QUESTIONS = 14;
    private final int NUM_ANS_CHOICES = 4;

    // constructor
    /**
     * Constructor for creating a GameQuestions object
     */
    public GameQuestions() {
        questions = new String[NUM_QUESTIONS];
        choices = new String[NUM_QUESTIONS][NUM_ANS_CHOICES];
        answers = new String[NUM_QUESTIONS];
    }

    // methods
    /**
     * Set the text of the question
     * 
     * @param question the question text
     */
    public void addQuestion(String question, int qCount)
    {
        questions[qCount] = question;
    }

    /**
     * Formats the question string correctly
     * 
     * @param rawQuestion the raw text of the question
     * @return the formatted question
     */
    private String formatQuestion(String rawQuestion) {
        StringTokenizer tokenizer = new StringTokenizer(rawQuestion);
        int charCount = 0;
        String question = "";
        String token;
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (token.length() + charCount > NUM_CHARS_PER_LINE) {
                question = question + "\n" + token + " ";
                charCount = token.length() + 1;
            }
            else if (token.length() + charCount == NUM_CHARS_PER_LINE) {
                question = question + token + "\n";
                charCount = 0;
            }
            else {
                question = question + token + " ";
                charCount = charCount + token.length() + 1;
            }
        }
        return question;
    }

    /**
     * Display the formatted text of the question
     * 
     * @param qCount the question index number
     * @return the formatted text of the question
     */
    public String extractQuestion(int qCount)
    {
        return formatQuestion(questions[qCount]);
    }

    /**
     * Add a choice to the list of answer choices
     * 
     * @param choice the text of the answer choice
     * @param correct true of false if the choice is correct or not
     * @param qCount the question index number to which the answer choice corresponds
     * @param letter the answer choice letter
     */
    public void addChoice(String choice, boolean correct, int qCount, String letter)
    {
        int j = 0;
        if (letter.equals("A")) {
            j = 0;
        }
        else if (letter.equals("B")) {
            j = 1;
        }
        else if (letter.equals("C")) {
            j = 2;
        }
        else if (letter.equals("D")) {
            j = 3;
        }

        choices[qCount][j] = choice;

        if (correct) {
            answers[qCount] = letter;
        }
    }

    /**
     * Extract the text of a specific answer choice
     * 
     * @param qCount the question index number that the answer choice corresponds to
     * @param letter the letter of the answer choice to be extracted
     * @return the text of the specified answer choice
     */
    public String extractAnswerChoice(int qCount, String letter)
    {
        int j = 0;
        if (letter.equals("A")) {
            j = 0;
        }
        else if (letter.equals("B")) {
            j = 1;
        }
        else if (letter.equals("C")) {
            j = 2;
        }
        else if (letter.equals("D")) {
            j = 3;
        }

        return choices[qCount][j];
    }

    /**
     * Extract the letter of the correct answer choice
     * 
     * @param qCount the question index number that the answer corresponds to
     * @return the correct answer letter
     */
    public String extractAnswer(int qCount)
    {
        return answers[qCount];
    }
}
