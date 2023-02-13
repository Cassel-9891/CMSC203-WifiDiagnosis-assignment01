/*
 * Class: CMSC203 CRN: 
 * Instructor: Grigoriy Grinberg
 * Description: Program that asks users a series of question to step through some 
 * possible problems to restore internet connectivity.
 * Due: 02/13/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Caterine Gabriela Asselborn
*/

import java.util.Scanner;
import java.io.*;

public class WifiDiagnosis
{
    // Created constants as I wrote the program for any reapeting values 
    static final String PROBLEM_CHECK_QUESTION = "Did that fix the problem?";
    static final String ANSWER_YES = "Yes";
    static final String ANSWER_NO = "No";
    static final String INVALID_MESSAGE = "Invalid answer; try again";
    static final String PROGRAMMERS_NAME = "Caterine G. Asselborn";
    static final String PROGRAM_IS_DONE = "Done";
    
    // Created array to hold the 5 steps of the diagnosis, which is the only changing part through the program
    static final String[] STEP_STATEMENTS = { 
        "Reboot the computer and try to connect", 
        "Reboot the router and try to connect",
        "Make sure the cables connecting the router are firmly plugged in and power is getting to the router",
        "Move the computer closer to the router and try to connect", 
        "Contact your ISP" 
    };

    public static void main(String[] args) throws IOException
    {
        // Automatically closes the instance of the class Scanner
        try (Scanner keyboard = new Scanner(System.in))
        {
            // Intro to the program
            System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work.");

            // Start diagnosis questions in this for loop 
            // Each time the answer is "no" the array wil ask the next question as long as the answer is valid and we are not at the end of the program
            for (int step = 0; step < (STEP_STATEMENTS.length - 1); step++)
            {
                // Through each iteration it will print the next question, and check if it solved the issue
                System.out.println(STEP_STATEMENTS[step] + "\n" + PROBLEM_CHECK_QUESTION);
                String answer = keyboard.nextLine(); // It will hold the user's keyboard input
                
                // Calls function to check answer validity and prints error message if the message is not valid
                if (!isValidAnswer(answer)) 
                {
                    System.out.println(INVALID_MESSAGE);
                    System.out.println(PROGRAMMERS_NAME);
                    return; // exits the program
                }
                // If the answer is valid and the answer is "yes" then the diagnosis is over and the program closes
                else if (answer.equalsIgnoreCase(ANSWER_YES))
                {
                    System.out.println(PROGRAM_IS_DONE);
                    System.out.println(PROGRAMMERS_NAME);
                    return; // exits the program
                }
            }
        }

        // If we get to the end of the diagnosis by not exiting while in the for loop above,
        // the last statement is printed and the program is done
        System.out.println(STEP_STATEMENTS[STEP_STATEMENTS.length - 1]);
        System.out.println(PROGRAM_IS_DONE);
        System.out.println(PROGRAMMERS_NAME);
    }

    // Created a small method to check whether the answer is valid after each step of the diagnosis
    public static boolean isValidAnswer(String answer)
    {
        // Returns a true or false boolean to be checked in the if statements above
        return answer.equalsIgnoreCase(ANSWER_YES) || answer.equalsIgnoreCase(ANSWER_NO);
    }
}