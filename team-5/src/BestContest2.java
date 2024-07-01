import java.util.*;
public class BestContest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are your choices:");
        System.out.println("1- Calculate the area of a circle");
        System.out.println("2- Calculate the factorial of a number");
        System.out.println("3- Find the maximum of three numbers");
        System.out.println("4- Check if a number is prime or not");
        System.out.println("5- Fibonnaci Series");
        System.out.println("6- Check if a string is a palindrome");
        System.out.println("7- Find the longest word in a sentence");
        System.out.println("8- Check if two strings are anagrams of each other");
        System.out.println("9- Calculate the sum of two numbers");
        System.out.println("10- Calculate the average of a list of numbers");
        System.out.println("11- Reverse a string");
        System.out.println("12- Check if the number is ever or odd");
        System.out.println("13- Find the largest number in a list");
        System.out.println("14- Find the smallest number in a list");
        System.out.println("15- Check if a number is divisible by a nother number");
        System.out.println("16- Check if a number is a perfect square");
        System.out.println("17- Find the sum of the digits of a number");
        System.out.println("18- Check if a number is palindrom");
        System.out.println("19- Find the most common word in a phrase");
        System.out.println("20- Generate a random password");
        System.out.println("21- Check the difference between 2 points");
        System.out.println("22- Find the most frequent letter in a string");
        System.out.println("23- Find the sum of the first n natural numbers");
        System.out.println("24- Find the sum of the digits of a number until is a single digit");
        System.out.println("25- Find the sum of the squares of the first n natural numbers");

        System.out.println("Please enter a number: ");
        if(scanner.hasNextInt()) {
            int choice = scanner.nextInt();



            switch (choice){
                case 1:
                    System.out.println("Enter the radius of the circle: ");
                    double radius = scanner.nextDouble();
                    areaOfACircle(radius);
                    break;
                case 2:
                    System.out.println("Enter the number you want to calculate factorial for: ");
                    int factorialChoice = scanner.nextInt();
                    factorial(factorialChoice);
                    break;
                case 3:
                    System.out.println("Find the maximum of three numbers: ");
                    System.out.println("Enter the first number: ");
                    int firstNumber = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    int secondNumber = scanner.nextInt();
                    System.out.println("Enter the third number: ");
                    int thirdNumber = scanner.nextInt();
                    System.out.println(maximumOfThree(firstNumber, secondNumber, thirdNumber));
                    break;
                case 4:
                    System.out.println("Enter the number you want to check if it's prime");
                    int prime = scanner.nextInt();
                    isPrime(prime);
                    break;
                case 5:
                    System.out.println("Enter how many numbers from Fibonacci series you want to see: ");
                    int fibonacciNumber = scanner.nextInt();
                    System.out.print("0" +" "+ "1");
                    fibonnaciSeries(fibonacciNumber - 2 );
                    break;
                case 6:
                    System.out.println("Enter a string to check if it's a palindrom");
                    String palindromUser = scanner.next();
                    isPalindrome(palindromUser);
                    break;
                case 7:
                    System.out.println("Introdu fraza: ");
                    String fraza2 =scanner.next();
                    cuvant_mare(fraza2);
                    break;
                case 8:
                    System.out.println("Enter first string");
                    String firstString = scanner.next();
                    firstString += scanner.nextLine();
                    System.out.println("Enter second string");
                    String secondString = scanner.next();
                    secondString += scanner.nextLine();
                    char[] firstWordChars = firstString.toLowerCase().toCharArray();
                    char[] secondWordChars = secondString.toLowerCase().toCharArray();
                    areAnagram(firstWordChars, secondWordChars);
                    break;
                case 9:
                    Scanner s7=new Scanner(System.in);
                    System.out.println("introdu numerele pt suma");
                    int num1=s7.nextInt();
                    int num2=s7.nextInt();
                    int suma=num1+num2;
                    System.out.println("suma numerelor:"+suma);
                    break;
                case 10:
                    System.out.println("Enter a bunch of numbers and write DONE after you finished inserting numbers");
                    ArrayList<Integer> myList = new ArrayList<>();
                    while(scanner.hasNextInt()){
                        int i = scanner.nextInt();
                        myList.add(i);
                    }
                    System.out.println(average(myList));
                    break;
                case 11:
                    System.out.println("Enter a string that you want to have reversed");
                    String enteredString = scanner.next();
                    enteredString += scanner.nextLine();
                    System.out.println(reverse(enteredString));
                    break;
                case 12:
                    System.out.println("Enter a number to check if it's odd or even");
                    int oddOrEven = scanner.nextInt();
                    paritate(oddOrEven);
                    break;
                case 13:
                    int[] numbers = {5, 10, 1, 9, 2};
                    cel_mai_mare(numbers);
                    System.out.println("Cel mai mare numar din vector este :" + cel_mai_mare(numbers));
                    break;
                case 14:
                    int[] smallNumbers = {5, 10, 1, 9, 2};
                    cel_mai_mic(smallNumbers);
                    System.out.println("cel mai mic numar din vector este "+cel_mai_mic(smallNumbers));
                    break;
                case 15:
                    System.out.println("Enter first number");
                    int firstNumber2 = scanner.nextInt();
                    System.out.println("Enter second number");
                    int secondNumber2 = scanner.nextInt();
                    if( firstNumber2 % secondNumber2 == 0)
                        System.out.println(firstNumber2 + " Is divisible by " + secondNumber2);
                    else
                        System.out.println(firstNumber2 + " Is not divisible by " + secondNumber2);
                    break;
                case 16:
                    System.out.println("Enter a number to check if it's a perfect square");
                    double numberForSquare = scanner.nextDouble();
                    if(checkPerfectSquare(numberForSquare))
                        System.out.println("The given number is a perfect square");
                    else
                        System.out.println("The given number is not a perfect square");
                    break;
                case 17:
                    System.out.println("Enter a number and I'll add the digits of the number for you");
                    int digitSum = scanner.nextInt();
                    String individualDigits = String.valueOf(digitSum);
                    System.out.println(sumOfDigits(individualDigits));
                    break;
                case 18:
                    System.out.println("Enter the number you want");
                    int number = scanner.nextInt();
                    isPalindrome(String.valueOf(number));
                    break;
                case 19:
                    System.out.println("Enter the string you'd like to check for the most common word");
                    String commonWord = scanner.next();
                    commonWord += scanner.nextLine();
                    System.out.println(findMostCommonWord(commonWord));
                    break;

                case 20:
                    System.out.println("Cate caractere sa fie parola:");
                    Scanner s11 = new Scanner(System.in);
                    int size_pass=s11.nextInt();
                    String password = "";
                    for(int i=0;i<size_pass;i++){
                        char randomChar= random_password();
                        password=password+randomChar;
                    }
                    System.out.println("Parola este:  "+password);
                    break;

                case 21:
                    System.out.println("Enter the X coordinate of first point");
                    int x1 = scanner.nextInt();
                    System.out.println("Enter the Y coordinate of first point");
                    int y1 = scanner.nextInt();
                    System.out.println("Enter the X coordinate of second point");
                    int x2 = scanner.nextInt();
                    System.out.println("Enter the Y coordinate of second point");
                    int y2 = scanner.nextInt();
                    System.out.println(distance(x1, y1, x2, y2));
                    break;
                case 22:
                    System.out.println("Enter the string you want: ");
                    String stringToCheck = scanner.next();
                    stringToCheck += scanner.nextLine();
                    String correctString = stringToCheck.replaceAll("\\s","");
                    System.out.println(mostFrequentLetter(correctString));
                    break;
                case 23:
                    System.out.println("Please enter how many natural numbers you want to see the addition to: ");
                    int lengthOfSum = scanner.nextInt();
                    System.out.println(sumOfFirstNaturalNumbers(lengthOfSum));
                    break;
                case 24:
                    System.out.println("Please enter a number to find out the sum of all the digits except the last one: ");
                    String numberForDigits = scanner.next();
                    System.out.println(sumOfNumberTillDigit(numberForDigits));
                    break;
                case 25:
                    System.out.println("Enter how many natural numbers you want to see the addition of their squares to: ");
                    int lengthOfSquare = scanner.nextInt();
                    System.out.println(sumOfSquaresFirstNaturalNumbers(lengthOfSquare));
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } else {
            System.out.println("Not a valid choice");
        }

    }

    private static void areaOfACircle(double radius)
    {
        double area = Math.PI * radius * radius; // Calculate the area of a circle
        System.out.println("The Area of the circle is " + area);
    }
    static void factorial(int numar) {
        if (numar < 0) {
            System.out.println("Nu exista");
            return;
        }
        int rezultat = 1;
        for (int i = 1; i <= numar; i++) {
            rezultat = rezultat * i;
        }
        System.out.println("Factorialul este " + rezultat);
    }
    private static int maximumOfThree (int a, int b, int c) {
        //nu este necesara o variabilă temporară
        int temp;

        if(a > b)       // Storam valoarea mai mare in variabila temporara
            temp = a;
        else {
            temp = b;
        }

        if(temp > c)    // verificam daca valoarea din variabila temporara e mai mare decat C si returnam ce-i mai mare
            return temp;
        else
            return c;
    }
    private static int isPrime(int numberPrime) {
        boolean isPrime = true;
        for (int i = 2; i < numberPrime / 2; i++) {
            if (numberPrime % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (!isPrime) {
            System.out.println(numberPrime + " is not a prime number");
        } else {
            System.out.println(numberPrime + " is a prime number");
        }
        return isPrime ? 1 : 0;
    }
    static int n1 = 0, n2 = 1, n3 = 0;//n3 are ca valoarte default 0
    private static void fibonnaciSeries (int count) {
        //Daca afișăm n3 după ce se fac calculele, omitem afișarea primilor 2 termeni din șir. se poate da un sout la n1 la începutul if-ului
        if (count > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            fibonnaciSeries(count - 1);
        }
    }
    private static void isPalindrome(String palindrome) {
        String reverse = "";
        for (int i = palindrome.length() - 1 ; i >= 0 ; i--)
        {
            reverse = reverse + palindrome.charAt(i); // Reverse the string by adding from last letter to first
        }
        if(palindrome.equals(reverse))
            System.out.println("The string you entered is a palindrome");
        else
            System.out.println("The string you entered is not a palindrome");
    }
    public static void cuvant_mare(String fraza2){
        String delims=" ";
        String cuvant_mare2="";
        String[] cuvant= fraza2.split(delims);
        for(int i=0; i<cuvant.length; i++){
            System.out.println(cuvant[i]);
            String cuvant2=cuvant[i];
            if (cuvant2.length() > cuvant_mare2.length()) {
                cuvant_mare2 = cuvant2;
            }
        }

        System.out.println(cuvant_mare2);
    }
    private static boolean areAnagram(char[] str1, char[] str2) {
        int n1 = str1.length;
        int n2 = str2.length;

        if(n1 != n2) {
            System.out.println("The strings are not anagrams to eachother");
            return false;

        }
        // Le facem lower case deoarece o anagrama n-ar trebui sa fie case sensitive

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        //Compare sorted strings
        for (int i = 0; i < n1; i++)
            if(str1[i] != str2[i]) {
                System.out.println("The strings are not anagrams to eachother");
                return false;
            }
        System.out.println("Strings are anagrams to eachother");
        return true;
    }
    private static double average(ArrayList<Integer> list) {
        double average = list.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        return average;
    }
    private static String reverse(String theString){
        String reversedString = "";
        for (int i = theString.length() - 1; i >= 0; i--)
            reversedString += theString.charAt(i);
        return reversedString;
    }
    public static void paritate(int numar_paritate){


        if(numar_paritate % 2 == 0)// verificam daca numarul e divizibil cu 2
        {
            System.out.println("Numarul este par");
        }
        else {
            System.out.println("Numarul este impar");
        }

    }
    public static int cel_mai_mare(int[] numbers) {

        int cel_mai_mare = numbers[0];
        for (int number : numbers) {
            if (number > cel_mai_mare) {
                cel_mai_mare = number;
            }
        }
        return cel_mai_mare;
    }
    public static int cel_mai_mic(int[] numbers) {
        int smallest = numbers[0];
        for (int number : numbers) {
            if (number < smallest) {
                smallest = number;
            }
        }
        return smallest;
    }
    private static boolean checkPerfectSquare(double number){
        //Calculam square root of the given number
        double sqrt = Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);

    }
    private static int sumOfDigits (String number) {
        int sum = 0;
        for(int i = 0; i < number.length(); i++)
            sum += number.charAt(i) - '0';
        return sum;
    }
    private static String findMostCommonWord (String inputString) {
        if(inputString == null || inputString.isEmpty())
            return null;

        inputString = inputString.toLowerCase();
        String[] words = inputString.replaceAll("[^a-zA-Z ]", "").split("\\s");

        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String mostCommonWord = null;
        int maxCount = 0;
        for(Map.Entry<String,Integer> entry : wordCount.entrySet()){
            if (entry.getValue() > maxCount)
            {
                mostCommonWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommonWord;
    }
    public static char random_password() {
        Random rand = new Random();
        int random_number = rand.nextInt(256);
        char randomChar = (char) random_number;
        return randomChar;

    }
    private static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    private static char mostFrequentLetter(String phrase) {

        HashMap<Character, Integer> mp = new HashMap<>();
        int n = phrase.length();
        char ans = 0;
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            char c = phrase.charAt(i);
            mp.put(c,mp.getOrDefault(c,0) + 1);
            if(count < mp.get(c)) {
                ans = c;
                count = mp.get(c);
            }
        }
        return ans;
    }
    private static int sumOfFirstNaturalNumbers (int length) {
        int sum = 0;
        for (int i = 0; i < length; i++)
            sum += i;
        return sum;
    }
    private static int sumOfNumberTillDigit (String number) {
        //la un  input de 324 rezultatul este 5, deoarece face suma fara ultima cifra, desi trebuia sa se faca suma pana cand numarul ramane cu un singur digit => 324 = 4 +2 = 6
        int sum = 0;
        for(int i = 0; i < number.length() - 1; i++)
            sum += number.charAt(i) - '0';
        return sum;
    }
    private static int sumOfSquaresFirstNaturalNumbers (int length) {
        int sum = 0;
        for (int i = 0; i < length; i++)
            sum += i * i;
        return sum;
    }

}
