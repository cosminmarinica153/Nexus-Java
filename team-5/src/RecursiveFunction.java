import java.util.Scanner;

public class RecursiveFunction {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tasks();
        System.out.println("Choose which exercise you want to run! ");
        int choice = scanner.nextInt();
        Cases(choice);
    }

    private static void Tasks() {
        String[] tasks = {
                "Calculate the area of a circle",
                "Calculate the factorial of a number",
                "Find the maximum of three numbers",
                "Check if a number is prime or not",
                "Print the Fibonacci sequence",
                "Check if a string is a palindrome or not",
                "Find the longest word in a sentence",
                "Check if two strings are anagrams of each other",
                "Calculate the sum of two numbers",
                "Calculate the average of a list of numbers",
                "Reverse a string",
                "Check if a number is even or odd",
                "Find the largest number in a list",
                "Find the smallest number in a list",
                "Check if a number is divisible by another number",
                "Check if a number is a perfect square",
                "Find the sum of the digits of a number",
                "Check if a number is a palindrome or not",
                "Find the most common word in a phrase",
                "Generate a random password",
                "Calculate the distance between two points",
                "Find the most frequent letter in a string",
                "Find the sum of the first n natural numbers",
                "Find the sum of the digits of a number until it is a single digit",
                "Find the sum of the squares of the first n natural numbers",
                "Press '0' to quit"
        };

        for (int i = 0; i < tasks.length; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }

    private static void Cases(int choice) {
        switch (choice) {
            case 1:
                System.out.println("You chose to calculate the area of a circle.");
                area();
                break;
            case 2:
                System.out.println("You chose to calculate the factorial of a number.");
                System.out.println("Type a number to find out it's factorial: ");
                int factorialNumber = scanner.nextInt();
                System.out.println("Factorial of " + factorialNumber + " is " + factorial(factorialNumber));
                break;
            case 3:
                System.out.println("You chose to find the maximum of three numbers.");
                System.out.println("Type the length of your array: ");
                int number = scanner.nextInt();
                int[] array = new int[number];
                System.out.println("Type your numbers: ");
                for (int i = 0; i < number; i++) {
                    array[i] = scanner.nextInt();
                }
                int max = maximum(array, 0);
                System.out.println(max);
                break;
            case 4:
                System.out.println("You chose to check if a number is prime or not.");
                int prime = scanner.nextInt();
                int div = 2;
                prime(prime, div);
                break;
            case 5:
                System.out.println("You chose to print the Fibonacci sequence.Type a number");
                int fibonacci = scanner.nextInt();
                int firstNumber = 0, secondNumber = 1;
                fibonacci(fibonacci, firstNumber, secondNumber);
                break;
            case 6:
                System.out.println("You chose to check if a string is a palindrome or not. Type a String.");
                scanner.nextLine();
                String text = scanner.nextLine();
                if (palindrome(text, 0)) {
                    System.out.println("It's Palindrome");
                } else {
                    System.out.println("Not palindrome");
                }
                break;
            case 7:
                System.out.println("You chose to find the longest word in a sentence.Type a sentence");
                scanner.nextLine();
                String words = scanner.nextLine();
                System.out.println("The longest word is " + longestWord(words, 0, ""));
                break;
            case 8:
                System.out.println("You chose to check if two strings are anagrams of each other.");
                System.out.println("Not implemented yet");
                break;
            case 9:
                System.out.println("You chose to calculate the sum of two numbers.");
                System.out.println("Type the first number");
                int firstSumNumber = scanner.nextInt();
                System.out.println("Type the second number");
                int secondSumNumber = scanner.nextInt();
                System.out.println("The sum of the first number " + firstSumNumber + " and the second number " + secondSumNumber + " is: " + sum(firstSumNumber, secondSumNumber));
                break;
            case 10:
                System.out.println("You chose to calculate the average of a list of numbers.Type how many numbers you want to have");
                int arraySize = scanner.nextInt();
                int[] list = new int[arraySize];
                System.out.println("Type arrays numbers: ");
                for (int i = 0; i < list.length; i++) {
                    list[i] = scanner.nextInt();
                }
                System.out.println(average(list, 0, 1, 0));
                break;
            case 11:
                System.out.println("You chose to reverse a string.");
                String string = "mama";
                System.out.println(reverseString(string, string.length() - 1, ""));
                break;
            case 12:
                System.out.println("You chose to check if a number is even or odd. Type a number");
                int evenOrOdd = scanner.nextInt();
                if (evenOrOdd(evenOrOdd))
                    System.out.println("It's even");
                else
                    System.out.println("It's odd");
                break;
            case 13:
                System.out.println("You chose to find the largest number in a list.Type how long the array you want to be.");
                int arraysSize = scanner.nextInt();
                int[] arrays = new int[arraysSize];
                System.out.println("Type arrays numbers: ");
                scanner.nextLine();
                for (int i = 0; i < arrays.length; i++) {
                    arrays[i] = scanner.nextInt();
                }
//                int[] arrays = {2,3,-99,102,4,5,642,4};
                System.out.println("The biggest number is: " + biggestNumber(arrays, 0, Integer.MIN_VALUE));
                break;
            case 14:
                System.out.println("You chose to find the smallest number in a list.Type how long the array you want to be.");
                int smallArraysSize = scanner.nextInt();
                int[] smallArrays = new int[smallArraysSize];
                System.out.println("Type arrays numbers: ");
                scanner.nextLine();
                for (int i = 0; i < smallArrays.length; i++) {
                    smallArrays[i] = scanner.nextInt();
                }
//                int[] arrays = {2,3,-99,102,4,5,642,4};
                System.out.println("The smallest number is: " + smallestNumber(smallArrays, 0, Integer.MAX_VALUE));
                break;
            case 15:
                System.out.println("You chose to check if a number is divisible by another number.");

                break;
            case 16:
                System.out.println("You chose to check if a number is a perfect square.");

                break;
            case 17:
                System.out.println("You chose to find the sum of the digits of a number. Type your number: ");
                int sumNUmber = scanner.nextInt();
                System.out.println("The sum is: " + sumOfDigits(sumNUmber,0));
                break;
            case 18:
                System.out.println("You chose to check if a number is a palindrome or not.");

                break;
            case 19:
                System.out.println("You chose to find the most common word in a phrase.");

                break;
            case 20:
                System.out.println("You chose to generate a random password.");

                break;
            case 21:
                System.out.println("You chose to calculate the distance between two points.");

                break;
            case 22:
                System.out.println("You chose to find the most frequent letter in a string.");

                break;
            case 23:
                System.out.println("You chose to find the sum of the first n natural numbers.");

                break;
            case 24:
                System.out.println("You chose to find the sum of the digits of a number until it is a single digit.");

                break;
            case 25:
                System.out.println("You chose to find the sum of the squares of the first n natural numbers.");

                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 25.");
                break;
        }
    }

    private static void area() {
        System.out.println("Enter the radius of the circle:");
        double radius = scanner.nextDouble();
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of a circle is: " + area);
    }

    private static int factorial(int factorial) {
        if (factorial <= 1) {
            return 1;
        } else {
            return factorial * factorial(factorial - 1);
        }
    }

    private static int maximum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        } else {
            int maxNumber = maximum(array, index + 1);
            return array[index] > maxNumber ? array[index] : maxNumber;
        }
    }

    private static void prime(int prime, int div) {
        if (prime < 2) {
            System.out.println("It's not prime");
            return;
        }
        if (div * div > prime) {
            System.out.println("It's prime");
            return;
        }
        if (prime % div == 0) {
            System.out.println("It's not prime");
            return;
        }
        prime(prime, div + 1);
    }

    private static void fibonacci(int fibonacciNumbers, int a, int b) {
        if (fibonacciNumbers > 0) {
            int c = a + b;
            System.out.print(a + " ");
            a = b;
            b = c;
            fibonacci(fibonacciNumbers - 1, a, b);
        }

    }

    private static boolean palindrome(String text, int i) {
        if (i >= text.length() / 2)
            return true;
        if (text.charAt(i) != text.charAt(text.length() - i - 1))
            return false;
        return palindrome(text, i + 1);
    }

    private static String longestWord(String sentence, int count, String longestWord) {
        String[] words = splitSentence(sentence);
        if (words.length == count) {
            return longestWord;
        }
        if (words[count].length() > longestWord.length()) {
            longestWord = words[count];
        }
        return longestWord(sentence, count + 1, longestWord);
    }

    private static String[] splitSentence(String sentence) {
        String split = "";
        String[] splitSentence = sentence.split(" ");
        return splitSentence;
    }

    private static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static double average(int[] list, int index, double average, int sum) {
        if (index == list.length) {
            return (double) sum / list.length;
        }
        sum += list[index];
        return average(list, index + 1, average, sum);
    }

    private static String reverseString(String string, int index, String stringReversed) {
        if (index < 0) {
            return stringReversed;
        }
        stringReversed += string.charAt(index);
        return reverseString(string, index - 1, stringReversed);
    }

    private static boolean evenOrOdd(int number) {
        return number % 2 == 0;
    }

    private static int biggestNumber(int[] array, int index, int biggestNumber) {
        if (index == array.length) {
            return biggestNumber;
        }
        if (array[index] > biggestNumber) {
            biggestNumber = array[index];
        }
        return biggestNumber(array, index + 1, biggestNumber);
    }

    private static int smallestNumber(int[] array, int index, int smallestNumber) {
        if (index == array.length) {
            return smallestNumber;
        }
        if (array[index] < smallestNumber) {
            smallestNumber = array[index];
        }
        return smallestNumber(array, index + 1, smallestNumber);
    }

    private static int sumOfDigits(int number, int sum) {
        if (number == 0) {
            return sum;
        }
        int digit = number % 10;
        sum += digit;
        return sumOfDigits(number/10, sum);
    }

}
