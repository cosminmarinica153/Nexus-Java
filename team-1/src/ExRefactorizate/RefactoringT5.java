import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * RefactoringT5
 */
public class RefactoringT5 {

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        
        Exercitii();


    }

    public static void Exercitii() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "1- Calculate the area of a circle\n" +
                        "2- Calculate the factorial of a number\n" +
                        "3- Find the maximum of three numbers\n" +
                        "4- Check if a number is prime or not\n" +
                        "5- Print the Fibonacci sequence\n" +
                        "6- Check if a string is a palindrome or not\n" +
                        "7- Find the longest word in a sentence\n" +
                        "8- Check if two strings are anagrams of each other\n" +
                        "9- Calculate the sum of two numbers\n" +
                        "10- Calculate the average of a list of numbers\n" +
                        "11- Reverse a string\n" +
                        "12- Check if a number is even or odd\n" +
                        "13- Find the largest number in a list\n" +
                        "14- Find the smallest number in a list\n" +
                        "15- Check if a number is divisible by another number\n" +
                        "16- Check if a number is a perfect square\n" +
                        "17- Find the sum of the digits of a number\n" +
                        "18- Check if a number is a palindrome or not\n" +
                        "19- Find the most common word in a phrase\n" +
                        "20- Generate a random password\n" +
                        "21- Calculate the distance between two points\n" +
                        "22- Find the most frequent letter in a string\n" +
                        "23- Find the sum of the first n natural numbers\n" +
                        "24- Find the sum of the digits of a number until it is a single digit\n" +
                        "25- Find the sum of the squares of the first n natural numbers\n" +
                        "26- Find Kaprekar numbers.\n" +
                        "27- Find Harshad numbers.");

        System.out.print("Alegeti exercitiul dorit: ");

        int exercitiuAles = scanner.nextInt();

        switch (exercitiuAles) {
            case 1:
                ariaCercului(scanner);
                break;
            case 2:
                factorial(scanner);
                break;
            case 3:
                sumOf3Numbers(scanner);
                break;
            case 4:
                isPrime(scanner);
                break;
            case 5:
                fibonacci(scanner);
                break;
            case 6:
                isPalindrome(scanner);
                break;
            case 7:
                longestWord(scanner);
                break;
            case 8:
                anagrame(scanner);
                break;
            case 9:
                sumOf2Numbers(scanner);
                break;
            case 10:
                mediaAritmetica(scanner);
                break;
            case 11:
                reverseString(scanner);
                break;
            case 12:
                evenOrOdd(scanner);
                break;
            case 13:
                largestNumberInArray(scanner);
                break;
            case 14:
                smallestNumberInArray(scanner);
                break;
            case 15:
                numereDivizibile(scanner);
                break;
            case 16:
                isPerfectSquare(scanner);
                break;
            case 17:
                sumOfDigits(scanner);
                break;
            case 18:
                palindromNumber(scanner);
                break;
            case 19:
                mostUsedWord(scanner);
                break;
            case 20:
                passwordGenerator(scanner);
                break;
            case 21:
                distance2P(scanner);
                break;
            case 22:
                mostUsedLetter(scanner);
                break;
            case 23:
                sumOfNNumbers(scanner);
                break;
            case 24:
                sumOfDigitsTill1(scanner);
                break;
            case 25:
                sumOfSquares(scanner);

                break;
            case 26:    
                keprakarNo(scanner);
                break;
            case 27:
                harshadNo(scanner);
                break;
            default:
                System.out.println("Acest exercitiu nu este in lista");
                break;
        }

        scanner.close();

    }

    public static void ariaCercului(Scanner scanner) {
        System.out.println("Enter the radius of the circle:");
        // Citește un număr de tip double de la utilizator
        double radius = scanner.nextDouble();
        // Calculează aria cercului
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of a circle is: " + area);

    }

    public static void factorial(Scanner scanner) {
        System.out.println("Type a number to find out it's factorial: ");
        // Citește un număr de tip int de la utilizator
        int factorialNumber = scanner.nextInt();
        // Inițializează variabila result cu valoarea 1
        int factorialResult = 1;
        // Se foloseste o bucla for care pleaca de la 1 pana la numarul introdus de
        // utilizator
        for (int i = 1; i <= factorialNumber; i++) {
            // Multiplică valoarea curentă a lui result cu valoarea curentă a lui i și
            // stochează rezultatul înapoi în result
            factorialResult = factorialResult * i;
        }
        System.out.println("The factorial number is: " + factorialResult);

    }

    public static void sumOf3Numbers(Scanner scanner) {
        // Ex3
        System.out.println("Please enter the three numbers: ");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = 0;

        if (a >= b && b >= c)
            max = a;
        if (b >= a && b >= c)
            max = b;
        if (c >= b && b >= a)
            max = c;

        System.out.println("The maximum number is: " + max);
    }

    public static void isPrime(Scanner scanner) {
        // Task 4 - Check if a number is prime or not
        System.out.println("Type a positive number to check if it's prime: ");
        int primeNumber = scanner.nextInt();
        // Plecam de la premisa ca numarul este prim
        boolean isPrime = true;
        // Folosește o buclă for pentru a verifica dacă numărul este divizibil cu
        // oricare număr între 2 și primeNumber/2
        for (int i = 2; i < primeNumber / 2; i++) {
            // Verifică dacă primeNumber este divizibil cu i
            if (primeNumber % i == 0) {
                // Dacă primeNumber este divizibil cu i, atunci nu este prim
                isPrime = false;
                // Odata gasim un divizor nu are rost sa continue
                break;
            }
        }
        // Verifică valoarea lui isPrime pentru a afișa rezultatul corespunzător
        if (isPrime) {
            System.out.println("The number " + primeNumber + " is prime");
        } else {
            System.out.println("The number " + primeNumber + " is not prime");
        }
    }

    public static void fibonacci(Scanner scanner) {
        // Task 5 - Print the Fibonacci sequence
        System.out.print("Type Fibonacci number: ");
        int fibonacciNumber = scanner.nextInt();

        if (fibonacciNumber <= 0) {
            System.out.println("Type a positive number: ");
        } else {
            // Inițializează primii doi termeni ai sirului lui Fibonacci
            int firstFibonacci = 0;
            int secondFibonacci = 1;

            System.out.println("Fibonacci sequence:");
            for (int i = 0; i < fibonacciNumber; i++) {
                // Afișează valoarea curentă a lui firstFibonacci
                System.out.print(firstFibonacci + " ");

                int next = firstFibonacci + secondFibonacci;
                // Actualizează valorile pentru următoarea iterație
                firstFibonacci = secondFibonacci;
                secondFibonacci = next;
            }
        }
    }

    public static void isPalindrome(Scanner scanner) {
        // Ex6
        System.out.println("Please provide a string: ");
        scanner.nextLine();
        String[] wordLetters = scanner.nextLine().split("");
        int i = 0;
        int j = wordLetters.length - 1;

        boolean cond = true;
        while (i <= j) {
            if (!wordLetters[i].equals(wordLetters[j])) {
                cond = false;
                break;
            }
            i++;
            j--;
        }

        if (cond) {
            System.out.println("The word is a palindrome");
        } else {
            System.out.println("The word is not a palindrome");
        }

    }

    public static void longestWord(Scanner scanner) {
        // EX 7
        System.out.println("Please enter a phrase: ");
        scanner.nextLine();
        String[] words = scanner.nextLine().split(" ");

        String result = "";
        for (String word : words) {
            if (word.length() >= result.length())
                result = word;
        }

        System.out.println("The longest word from the sentence is: " + result);
    }

    public static void anagrame(Scanner scanner) {
        // Ex 8
        System.out.println("Please enter the first word: ");
        scanner.nextLine();
        String firstWord = scanner.nextLine().toLowerCase();

        System.out.println("Please enter the second word: ");
        String secondWord = scanner.nextLine().toLowerCase();

        if (firstWord.length() != secondWord.length()) {
            System.out.println("The first word is not an anagram of the second word");
        } else {
            char[] firstWordLetters = firstWord.toCharArray();
            char[] secondWordLetters = secondWord.toCharArray();

            Arrays.sort(firstWordLetters);
            Arrays.sort(secondWordLetters);

            if (Arrays.equals(firstWordLetters, secondWordLetters))
                System.out.println("The first word is an anagram of the second word");
            else
                System.out.println("The first word is not an anagram of the second word");
        }
    }

    public static void sumOf2Numbers(Scanner scanner) {
        // Ex 9
        System.out.println("Please provide two numbers:");

        int sum = scanner.nextInt() + scanner.nextInt();

        System.out.println("The sum is: " + sum);
    }

    public static void mediaAritmetica(Scanner scanner) {
        // 10. Calculate the average of a list of numbers
        System.out.print("Introduceti numarul de elemente pentru a calcula media aritmetica: ");
        int elemente = scanner.nextInt();
        int total = 0;
        System.out.print("Introduceti numerele: ");
        for (int i = 0; i < elemente; i++) {
            total += scanner.nextInt();
        }
        double media = (double) total / elemente;
        System.out.println("Media aritmetica este: " + media);
    }

    public static void reverseString(Scanner scanner) {
        // Ex 11
        System.out.println("Please provide a string: ");
        scanner.nextLine();
        String[] wordLetters = scanner.nextLine().split("");

        int i = 0;
        int j = wordLetters.length - 1;
        while (i <= j) {
            String aux = wordLetters[i];
            wordLetters[i] = wordLetters[j];
            wordLetters[j] = aux;

            i++;
            j--;
        }

        System.out.println("The reversed string is: " + String.join("", wordLetters));

    }

    public static void evenOrOdd(Scanner scanner) {
        // Ex 12;
        System.out.println("Please provide a number: ");

        int num = scanner.nextInt();

        if (num % 2 == 0)
            System.out.println("The number is even");
        else
            System.out.println("The number is odd");
    }

    public static void largestNumberInArray(Scanner scanner) {
        // Ex 13;
        System.out.println("Please enter a your numbers separated by a space: ");
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split(" ");

        int max = Integer.parseInt(numbers[0]);
        for (String number : numbers) {
            if (Integer.parseInt(number) > max) {
                max = Integer.parseInt(number);
            }
        }

        System.out.println("The largest number is: " + max);
    }

    public static void smallestNumberInArray(Scanner scanner) {
        // Ex 14;
        System.out.println("Please enter a your numbers separated by a space: ");
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split(" ");

        int min = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            if (Integer.parseInt(numbers[i]) < min) {
                min = Integer.parseInt(numbers[i]);
            }
        }

        System.out.println("The smallest number is: " + min);
    }

    public static void numereDivizibile(Scanner scanner) {
        // Ex 15
        System.out.println("Please provide the number");
        int a = scanner.nextInt();

        System.out.println("\nPlease provide the divisor");
        int b = scanner.nextInt();

        if (a % b == 0)
            System.out.println("The number " + a + " is divisible by " + b);
        else
            System.out.println("The number " + a + " is not divisible by " + b);

    }

    public static void isPerfectSquare(Scanner scanner) {
        // Ex 16
        System.out.println("Please provide the number: ");

        int num = scanner.nextInt();
        int root = (int) Math.sqrt(num);

        if ((root * root) == num)
            System.out.println("The number " + num + " is a perfect square");
        else
            System.out.println("The number " + num + " is not a perfect square");

    }

    public static void sumOfDigits(Scanner scanner) {
        // Ex 17
        System.out.println("Please provide a number: ");

        int num = scanner.nextInt();

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        System.out.println("The sum of the digits is: " + sum);
    }

    public static void palindromNumber(Scanner scanner) {
        // Ex 18
        System.out.print("Introduceti un numar pentru a vedea daca este palindrom: ");
        int NrIntrod = scanner.nextInt();
        int InitialNr = NrIntrod;
        int NrInversat = 0;
        while (NrIntrod != 0) {
            NrInversat = NrInversat * 10 + NrIntrod % 10;
            NrIntrod /= 10;
        }
        boolean EstePalindrom = InitialNr == NrInversat;

        if (EstePalindrom == true) {
            System.out.println(" Numarul este palindrom.");
        } else
            System.out.println(" Numarul nu este palindrom.");

    }

    public static void mostUsedWord(Scanner scanner) {
        // Ex 19
        scanner.nextLine();
        System.out.println("Type a sentence:");
        String sentnce = scanner.nextLine();
        String[] splitSentence = sentnce.split(" ");
        // Variabile pentru a ține evidența cuvântului cu cele mai multe apariții
        int counter = 0;
        int maxCount = 0;
        String word = "";
        for (int i = 0; i < splitSentence.length; i++) {
            // Inițializează un contor pentru a număra aparițiile cuvântului curent
            counter = 1;
            for (int j = 0; j < splitSentence.length; j++) {
                // Verifică dacă cuvântul curent se potrivește cu cuvântul din bucla internă
                if (splitSentence[i].equals(splitSentence[j])) {
                    counter++;
                }
                // Verifică dacă contorul pentru cuvântul curent este mai mare decât numărul
                // maxim de apariții găsit până acum
                if (counter > maxCount) {
                    // Actualizăm numărul maxim de apariții și cuvântul corespunzător5
                    maxCount = counter;
                    word = splitSentence[i];
                }
            }
        }
        System.out.println("The most used word is " + word);
    }

    public static void passwordGenerator(Scanner scanner) {
        // Requirement 20: Generate a random password

        System.out.print("Scrieti cate caractere sa aiba parola: ");
        int LungimeParola = scanner.nextInt();
        String Caractere = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder parola = new StringBuilder(LungimeParola);
        for (int i = 0; i < LungimeParola; i++) {
            parola.append(Caractere.charAt(random.nextInt(Caractere.length())));
        }
        System.out.println("Parola random este: " + parola);

    }

    public static void distance2P(Scanner scanner) {
        // Requirement 21: Calculate the distance between two points

        System.out.print("Introduceti x1 si y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.print("Introduceti x2 si y2:  ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double Disanta = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        System.out.println("Distanta dintr puncte este: " + Disanta);
    }

    public static void mostUsedLetter(Scanner scanner) {
        // Task 22 - Find the most frequent letter in a string
        System.out.println("Type a string: ");
        scanner.nextLine();
        String commonLetter = scanner.nextLine();
        // Variabile pentru urmărirea caracterului cu cele mai multe apariții
        int maxCount2 = 1;
        char maxLetter = commonLetter.charAt(0); // Caracterul cu cele mai multe apariții, inițializat cu primul
                                                 // caracter din șir
        // 2 for-uri care compara prima litera cu restul literelor
        for (int i = 0; i < commonLetter.length(); i++) {
            // Contor pentru numărul de apariții al caracterului curent
            int letterCount = 1;
            // Verifică dacă caracterul curent se potrivește cu caracterul de la indexul j
            for (int j = i + 1; j < commonLetter.length(); j++) {
                // Verificăm dacă numărul de apariții este mai mare decât maximul găsit până
                // acum
                if (commonLetter.charAt(i) == commonLetter.charAt(j)) {
                    letterCount++;

                    if (maxCount2 < letterCount) {
                        // Actualizăm numărul maxim de apariții
                        maxCount2 = letterCount;
                        // Actualizăm caracterul cu cele mai multe apariții
                        maxLetter = commonLetter.charAt(i);
                    }
                }
            }
        }
        System.out.println("The letter " + " ` " + maxLetter + " ` " + " appears " + maxCount2 + " times");

    }

    public static void sumOfNNumbers(Scanner scanner) {
        // Requirement 23: Sum of the first n natural numbers

        System.out.print("Introduceti n pentru suma a n nr.: ");
        int n = scanner.nextInt();
        int Sum = 0;
        for (int i = 1; i <= n; i++) {
            Sum += i;
        }
        System.out.println("Suma primelor " + n + " numere naturale este: " + Sum);

    }

    public static void sumOfDigitsTill1(Scanner scanner) {
        // Ex 24
        System.out.println("Please provide a number: ");

        int num = scanner.nextInt();

        int sum = 0;
        while (num > 10) {
            sum += num % 10;
            num /= 10;
        }

        System.out.println("The sum of the digits is: " + sum);

    }

    public static void sumOfSquares(Scanner scanner) {
        // Ex 25
        System.out.println("Please provide n: ");

        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i * i;

        System.out.println("The sum of the first " + n + "numbers squared is: " + sum);

    }

    public static void keprakarNo(Scanner scanner) {
        // Ex 26
        System.out.print("Please provide a number: ");

        int num = scanner.nextInt();
        scanner.nextLine();
        int numPow2 = num * num;

        ArrayList<Integer> digitsR = new ArrayList<>();

        // Transform the number into an array of digits
        while (numPow2 != 0) {
            digitsR.add(numPow2 % 10);
            numPow2 /= 10;
        }

        // Step required to get the number in the correct order
        List<Integer> digits = digitsR.reversed();

        // The left number will be the first half of its square
        int leftNum = 0;
        for (int i = 0; i < digits.size() / 2; i++)
            leftNum = leftNum * 10 + digits.get(i);

        // The right number will be the second half of its square
        int rightNum = 0;
        for (int i = digits.size() / 2; i < digits.size(); i++)
            rightNum = rightNum * 10 + digits.get(i);

        // A valid kaprekar number will be equal the sum of the left and right number
        if (leftNum + rightNum == num)
            System.out.println(
                    "The number " + num + " is a kaprekar number, formed from: " + leftNum + " and " + rightNum);
        else
            System.out.println("The number " + num + " is a not kaprekar number");
    }

    public static void harshadNo(Scanner scanner) {
        System.out.print("Please provide a number: ");

        int num = scanner.nextInt();
        scanner.nextLine();

        int copy = num;
        int digitSum = 0;
        while (copy > 0) {
            digitSum += copy % 10;
            copy /= 10;
        }

        if (num % digitSum == 0)
            System.out.println("The number " + num + " is a harshad number");
        else
            System.out.println("The number " + num + " is a not harshad number");

    }
}