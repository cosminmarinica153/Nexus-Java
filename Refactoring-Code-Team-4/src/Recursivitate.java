//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Recursivitate {

    public static void main(String[] args) {
        long start = System.nanoTime();
        // System.out.println(factorial(10));
        // System.out.print("0 " + " " + "1");
        // fibonnaciSeries(10 - 2);
        // String palindromeCheck = "Ana are mere";
        // String reversedString = reverseStringRecursive(palindromeCheck); // 5465500 Nano seconds
        // reverseString(palindromeCheck);                                 // 5707900 Nano seconds
        // int sum = sumOfNaturalNumbers(20);
        // System.out.println(sum);
        // sumOfNaturalNumbersRecursive(10);
        // sumOfFirstNaturalNumbers(10);
        // System.out.println(sumOfDigitsRecursive(12354698));     // 234700 Nano seconds
        // System.out.println(sumOfDigits("12354698"));            // 180100 Nano seconds
        int[] array = {10, 8, 2, 3, 5, 18, 29, 23};
        System.out.println(avgRecursive(array, 0, array.length));

        long end = System.nanoTime();

        long totalTime = end - start;
        System.out.println("Total runtime is: " + totalTime);


    }

    private static int factorial(int number)
    {
        if(number >= 1)
            return number * factorial(number - 1);
        else
            return 1;
    }

    static int n1 = 0, n2 = 1, n3 = 0;
    private static void fibonnaciSeries (int count) {

        if(count > 0)
        {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3 );
            fibonnaciSeries(count -1);
        }
    }

    private static String reverseStringRecursive(String str)
    {
        if(str.length() == 0)
            return str;
        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }
    private static String reverseString(String theString){
        String reversedString = "";
        for (int i = theString.length() - 1; i >= 0; i--)
            reversedString += theString.charAt(i);
        return reversedString;

    }


    private static int sumOfNaturalNumbersRecursive(int n)
    {
        if (n != 0)
            return n + sumOfNaturalNumbersRecursive(n - 1);
        else
            return n;

    }
    private static int sumOfFirstNaturalNumbers(int length)
    {
        int sum = 0;
        for (int i = 0; i < length; i++)
            sum += i;
        return sum;
    }

    private static int sumOfDigitsRecursive (int n)
    {
        if (n == 0)
            return 0;
        return (n % 10 + sumOfDigitsRecursive(n / 10));
    }

    private static int sumOfDigits (String number)
    {
        int sum = 0;
        for(int i = 0; i < number.length(); i++)
            sum += number.charAt(i) - '0';
        return sum;
    }
    private static int smallestNumberRecursive(int[] arr, int index)
    {
        if (index == 1)
            return arr[index];

        return Math.min(arr[index - 1], smallestNumberRecursive(arr, index - 1));
    }

    private static int biggestNumberRecursive(int[] arr, int index)
    {
        if(index == 1)
            return arr[index];
        return Math.max(arr[index - 1], biggestNumberRecursive(arr, index - 1));
    }

    private static double avgRecursive(int[] arr, int index, int n)
    {
        if (index == n - 1)
            return arr[index];
        if(index == 0)
            return (arr[index] + avgRecursive(arr, index + 1, n));

        return (arr[index] + avgRecursive(arr, index + 1, n));
    }


}