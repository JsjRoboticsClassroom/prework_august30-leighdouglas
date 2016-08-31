package nyc.c4q;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        boolean notDone = true;
        while (notDone){
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to play again?");
            String userAnswer = scanner.next();

            boolean isValidInput;

             do {
                 userAnswer = userAnswer.toLowerCase();
                 if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
                     notDone = true;
                     isValidInput = true;

                 } else if (userAnswer.equalsIgnoreCase("no") || userAnswer.equalsIgnoreCase("n")) {
                     notDone = false;
                     isValidInput = true;
                     break;
                 } else {
                     System.out.println("Try again");
                     userAnswer = scanner.next();
                     isValidInput = false;
                 }
             } while (isValidInput == false);
        }
    }
}
