import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Numeric {
    Scanner scanner = new Scanner(System.in);
    boolean guessed = false;

    // Function to generate a random number of exactly 4 different digits
    public int generateNum() {
        int max = 9;
        int size = 4;

        StringBuilder str = new StringBuilder();
        ArrayList<Integer> numArr = new ArrayList<>(size);

        for (int i = 0; i <= max; i++) {
            numArr.add(i);
        }

        Collections.shuffle(numArr);
        // Fixed issue where populating value 0 index 0 wouldn't add to the integer (Example: 0123 -> 123)
        for (int i = 0; i < size; i++) {

            if(numArr.get(i) == 0 && i == 0)
            {
                System.out.println("Skipped number coz 0.");
                size++;
                continue;
            }
            str.append(numArr.get(i));
            System.out.println("Added: " + str.toString()); ;
        }

        return Integer.parseInt(str.toString());
    }
    //Created separate function for displaying the rules

    public void displayRules() {
        System.out.println("Welcome to the game of BULLS and COWS.");
        System.out.println("BULLS = # common digits with exact matches.");
        System.out.println("COWS = # common digits in wrong position.");
        System.out.println("Give your best shot: ");
    }
    // Function to get input

    public int getNumber() {

        return scanner.nextInt();
    }
    // Function to populate ArrayList
    public void populateArr(ArrayList<Integer> intArr, Integer num) {
        String str = String.valueOf(num);
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            int a = Integer.parseInt(String.valueOf(str.charAt(i)));
            intArr.add(a);
        }
    }
    // Function to play the game using string variable

    public void playInt() {
        int cows = 0;
        int bulls = 0;
        boolean guessed = false;
        int secretNum = generateNum();

        ArrayList <Integer> secretNumArr = new ArrayList<>();
        populateArr(secretNumArr, secretNum);
        System.out.println(secretNumArr);
        displayRules();
        while (!guessed){

            int guess = getNumber();
            ArrayList <Integer> guessArr = new ArrayList<>();
            populateArr(guessArr, guess);

            // Fixed count of cows and bulls
            //If both numbers are equal and in the same position bulls++
            //if numbers are equal but in different positions cows++

            if (guessArr.size() == secretNumArr.size()) {
                for (int i = 0; i < guessArr.size(); i++) {

                    if ( secretNumArr.get(i) == guessArr.get(i) ) {
                        bulls++;
                    }

                }

                for (int i = 0; i < guessArr.size(); i++) {
                    for (int j = 0; j < secretNumArr.size(); j++) {
                        if ( secretNumArr.get(i) == guessArr.get(j) ) {
                            if(i != j)
                                cows++;
                        }
                    }
                }
            }

            System.out.println ("The number of bulls is:" + bulls + " and the number of cows is: " + cows);
            // Win condition bulls == 4
            if(bulls == 4)
                guessed = true;
            else
                bulls = 0;

        }
        scanner.close();

    }
    // Function to play the game using string variable
    public void playString() {
        String secretNum = String.valueOf(generateNum());
        String[] secretNumArr = secretNum.split("");

        StringBuilder printStr = new StringBuilder();

        for (String c : secretNumArr) {
            printStr.append(" ").append(c);
        }

        System.out.println(printStr);
        displayRules();


        int cows = 0;
        int bulls = 0;
        // Added win condition and a while loop so the user doesn't have only 1 chance to get the secret number
        while (!guessed) {

            String guessedNum = String.valueOf(getNumber());
            String[] guessedNumArr = guessedNum.split("");

            for (int i = 0; i < secretNumArr.length; i++) {
                if (secretNumArr[i].equals(guessedNumArr[i])) {
                    bulls++;
                }
            }

            for (int i = 0; i < secretNumArr.length; i++) {
                for (int j = 0; j < secretNumArr.length; j++) {
                    if (secretNumArr[i].equals(guessedNumArr[j])) {
                        if (i != j)
                            cows++;
                    }
                }
            }


            System.out.println("The number of bulls is: " + bulls + " and the number of cows is: " + cows);
            cows = 0;

            if (bulls == 4) {
                guessed = true;
                System.out.println("Congratulations, you guessed the number!");
            }
            else
                bulls = 0;
        }
        scanner.close();
    }
}
