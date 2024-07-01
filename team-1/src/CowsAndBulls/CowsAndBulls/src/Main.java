import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        init();
    }

    public static void init(){
        System.out.println("Welcome to Cows and Bulls");
        System.out.println("How would you like to play?");
        System.out.println("1. Numbers");
        System.out.println("2. Text");

        boolean run = true;
        while(run){
            int choice = -1;

            boolean valid = true;
            try{
                choice = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please provide a valid choice");
                valid = false;
                input.nextLine();
            }

            if(valid){
                boolean runCase = true;
                switch (choice){
                    case 1:
                        System.out.println("Please provide the size of the number you want to try (max 4)");
                        while(runCase){
                            int numSize = 0;

                            valid = true;
                            try{
                                numSize = input.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println("Please provide an integer");
                                valid = false;
                                input.nextLine();
                            }

                            if(numSize > 4){
                                System.out.println("Please provide a maximum length of 4");
                                valid = false;
                            }

                            if(valid){
                                numberCowsAndBulls(generateRandomNumber(numSize));
                                runCase = false;
                                run = false;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Please provide the size of the word you want to try (max 4)");
                        while(runCase){
                            valid = true;
                            int strSize = -1;
                            try{
                                strSize = input.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println("Please provide an integer");
                                valid = false;
                                input.nextLine();
                            }

                            if(strSize > 4){
                                System.out.println("Please provide a maximum length of 4");
                                valid = false;
                            }

                            if(valid){
                                stringCowsAndBulls(getString(strSize));
                                runCase = false;
                                run = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Please provide a valid choice");
                        break;
                }
            }
        }
    }

    public static ArrayList<Integer> generateRandomNumber(double length) {
        Random rand = new Random();

        int num = rand.nextInt((int)Math.pow(10, length) / 10, (int)Math.pow(10, length));
        ArrayList<Integer> numArray = new ArrayList<>();
        while(num != 0){
            numArray.add(num%10);
            num /= 10;
        }

        while(checkDuplicates(numArray)){
            num = rand.nextInt(1000, 10000);
            numArray = new ArrayList<>();
            while(num != 0){
                numArray.add(num%10);
                num /= 10;
            }
        }

        return numArray;
    }

    public static String getString(int length) {
        if(length < 3){
            String word = "";
            Random rand = new Random();
            for(int i = 0; i < length; i++)
                word += Character.toString(rand.nextInt(123 - 97) + 97);

            if(checkDuplicates(word.split("")))
                return getString(length);

            return word;
        } else {
            String textFile = switch (length) {
                case 3 -> "3-letter-words.txt";
                case 4 -> "4-letter-words.txt";
                default -> "";
            };

            ArrayList<String> words = new ArrayList<>();
            try {
                File myObj = new File(textFile);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    words.add(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
            }

            Random rand = new Random();
            int index = rand.nextInt(words.size() - 1);

            return words.get(index);
        }
    }

    public static boolean checkDuplicates(ArrayList<Integer> numArray){
        boolean isDuplicate = false;

        for(int i = 0; i < numArray.size(); i++) {
            for (int j = i + 1; j < numArray.size(); j++) {
                if(numArray.get(i).equals(numArray.get(j))){
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate)
                break;
        }

        return isDuplicate;
    }

    public static boolean checkDuplicates(String[] strArray){
        boolean isDuplicate = false;

        for(int i = 0; i < strArray.length; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                if(strArray[i].equals(strArray[j])){
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate)
                break;
        }

        return isDuplicate;
    }

    public static void numberCowsAndBulls(ArrayList<Integer> numArray){
        boolean playing = true;
        while(playing) {
            int guess;
            ArrayList<Integer> guessArray;

            System.out.println("Enter your guess, the number has " + numArray.size() + " digits.");
            // Validate guess
            do {
                guess = input.nextInt();
                guessArray = new ArrayList<>();
                while (guess != 0) {
                    guessArray.add(guess % 10);
                    guess /= 10;
                }
                if (checkDuplicates(guessArray))
                    System.out.println("Please enter a number with no repeating digits");
                if (guessArray.size() != numArray.size())
                    System.out.println("Please enter a number with " + numArray.size() + " digits.");
            } while (checkDuplicates(guessArray) || (numArray.size() != guessArray.size()));

            int cows = 0;
            int bulls = 0;

            for (int i = 0; i < numArray.size(); i++) {
                for (int j = 0; j < guessArray.size(); j++)
                    if ((numArray.get(i).equals(guessArray.get(j)))) {
                        if (i == j)
                            bulls++;
                        else
                            cows++;
                    }
            }

            if(bulls == numArray.size()) {
                playing = false;
                System.out.println("Well done you won");
            }else{
                System.out.println("Nice try.");
                System.out.println("cows: " + cows + " bulls: " + bulls);
            }
        }

    }

    public static void stringCowsAndBulls(String str){
        // to fix input bug from input.nextInt() not leaving an open line
        input.nextLine();

        str = str.toLowerCase();

        boolean playing = true;
        while(playing) {
            String guess;
            String[] guessArray;

            System.out.println("Enter your guess, the word has " + str.length() + " letters.");
            // Validate guess
            do {
                guess = input.nextLine();
                guessArray = guess.split("");

                if (checkDuplicates(guessArray))
                    System.out.println("Please enter a word with no repeating letters");
                if (guessArray.length != str.length())
                    System.out.println("Please enter a number with " + str.length() + " letters.");
            } while (checkDuplicates(guessArray) || (str.length() != guessArray.length));

            int cows = 0;
            int bulls = 0;

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < guessArray.length; j++)
                    if (guessArray[j].equals(String.valueOf(str.charAt(i)))) {
                        if (i == j)
                            bulls++;
                        else
                            cows++;
                    }
            }

            if(bulls == str.length()) {
                playing = false;
                System.out.println("Well done you won");
            }else{
                System.out.println("Nice try.");
                System.out.println("cows: " + cows + " bulls: " + bulls);
            }
        }
    }
}