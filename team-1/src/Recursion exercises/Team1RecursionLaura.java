/**
 * recursion
 */
public class Team1RecursionLaura {

    public static void main(String[] args) {
        int[] numbers = {16, 2, 10};
        //longest word
        System.out.println("cel mai lung cuvant este " + longestWord("oare o sa mearga".split(" "), 0, ""));
        // average
        System.out.println("media este " + average(numbers, 0, 0, 0));
        // largest num
        System.out.println("cel mai mare numar este " + largestInList(numbers, 0, 0));
        // smallest num
        System.out.println("cel mai mic numar este " + smallestInList(numbers,0, numbers[0]));
        // sum of up to n
        System.out.println("sum of n numbers is " + sumOfNaturalNums(5, 0, 0));
        // sum of squares up to n
        System.out.println("sum of squares of n numbers is " + sumOfSquares(2, 0, 0));
    }


    // - Find the longest word in a sentence
    public static String longestWord(String[] text, int i, String longest){
        if(text[0].length() < text[i].length()) longest = text[i];
        
        if(i == text.length - 1) return longest; 
        return longestWord(text, i + 1, longest);
    }


    // - Calculate the average of a list of numbers
    public static int average(int[] numbers, int i, int sum, int average){
        if( i <= numbers.length - 1){
            sum += numbers[i];
            average = sum / numbers.length;
            return average(numbers, i + 1, sum, average);
        }
        return average;
    }


    // - Find the largest number in a list
    public static int largestInList(int[] numbers, int i, int largest){
        if(largest < numbers[i]) largest = numbers[i];
        if (i < numbers.length - 1){
            return largestInList(numbers, i + 1, largest);
        }
        return largest;
    }


        // - Find the smallest number in a list
        public static int smallestInList(int[] numbers, int i, int smallest){
            if(smallest > numbers[i]) smallest = numbers[i];
            if (i < numbers.length - 1){
                return smallestInList(numbers, i + 1, smallest);
            }
            return smallest;
        }

        // - Find the sum of the first n natural numbers
        public static int sumOfNaturalNums(int n, int i, int sum){
            if(i <= n){
                sum += i;
                return sumOfNaturalNums(n, i + 1, sum);
            } else {
                return sum;
            }
        }

        // - Find the sum of the squares of the first n natural numbers
        public static int sumOfSquares(int n, int i, int sum){
            if(i <= n){
                sum += i * i;
                return sumOfSquares(n, i + 1, sum);
            } else {
                return sum;
            }
        }
}
