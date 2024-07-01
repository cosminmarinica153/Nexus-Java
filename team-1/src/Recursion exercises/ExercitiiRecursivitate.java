import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;
import java.util.Map;
/**
 * ExercitiiRecursivitate
 */
public class ExercitiiRecursivitate {

    public static void main(String[] args) {
        // System.out.println("Factorialul numarului este: " + factorialRec(5));
        // System.out.println("Numarul " + isPrimeRec(1, 4));
        // fibonacciRec(5, 0 ,1 ,0);

        // int[] numbers = {1, 10 ,900 ,290}; 
        // System.out.println("cel mai mare numar din sir este: " + maxRec(numbers, numbers[0], 0));
        //System.out.println("textul " + isPalindromRec("1223", 0));

        //System.out.println("Cuvintele " + isAnagrameRec("acest", "secat", 0, 0, 0));
        // String text = "Atat se poate";
        // System.out.println("Stringul invers este: " + reverseStringRec(text, "", text.length()-1));
        //System.out.println(nrPalindromRec(12331, 12321, 0));
        //System.out.println("Suma cifrelor este: " + sumOfDigitsRec(123, 0));
        //System.out.println("Suma cifrelor este: " + sumOfDigitsOCifraRec(123, 0));

        // String caractere = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*+=";
        // System.out.println("parola ta este: " + parolaRec("", caractere, 10));
        HashMap<String,Integer> m = new HashMap<String,Integer>();
        System.out.println(common("aa aa bb cc",m,""));


    }

    public static int factorialRec(int numar){
        if (numar == 0) {
            return 1;
        }
        return numar * factorialRec(numar - 1);
    }

    public static String isPrimeRec(int numar, int i){
        if (numar == 2 || numar == 3) {
            return "este prim";
        }
        if (numar % i ==0){
            return "nu e prim";
        }
        if (i > numar / 2) {
            return "este prim";
        }
        return isPrimeRec(numar, i + 1);
    }

    public static void fibonacciRec(int n, int a, int b) {
        if (n == 0) {
            return;
        }
        System.out.print(a + " ");
        fibonacciRec(n-1, b, a + b);
    }

    public static int maxRec(int[] numbers, int max, int i){
        if(max < numbers[i]) max = numbers[i];
        if (i < numbers.length-1) {
            return maxRec(numbers, max, i + 1);
        }
        return max;
    }

    public static String isPalindromRec(String text, int i){
        if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
            return "nu e palindrom";
        }
        if (i > text.length() / 2) {
            return "e palindrom";
        }
        return isPalindromRec(text, i+1);
    }

    public static String isAnagrameRec(String cuv1, String cuv2, int i, int sumCuv1, int sumCuv2){
        if (cuv1.length() != cuv2.length()) {
            return "nu sunt anagrame";
        }
        sumCuv1 += cuv1.codePointAt(i);
        sumCuv2 += cuv2.codePointAt(i); 

        if (sumCuv1 == sumCuv2 && i == cuv1.length()-1) {
            return "sunt anagrame";
        }
        else if(i == cuv1.length()-1 ){
            return "nu sunt anagrame";
        }
        return isAnagrameRec(cuv1, cuv2, i + 1, sumCuv1,sumCuv2);
    }

    public static String reverseStringRec(String text, String reveString ,int i){
        if (i == 0 ) {
            reveString += text.charAt(i);

            return reveString; 
        }
        reveString += text.charAt(i);
        return reverseStringRec(text, reveString, i-1);
    }

    public static String nrPalindromRec(int numar, int copyNr, int reverseNr){
        if (copyNr == 0 && numar != reverseNr) {
            return "nr nu este palindrom";
        }
        reverseNr = reverseNr * 10 + copyNr % 10;
        if (numar == reverseNr) {
            return "nr este palindrom";
        }
        return nrPalindromRec(numar, copyNr/10, reverseNr);
    }
    
    public static int sumOfDigitsRec(int nr, int sum){
        if (nr == 0) {
            return sum;
        }
        sum += nr %10;
        return sumOfDigitsRec(nr/10, sum);
    }

    public static int sumOfDigitsOCifraRec(int nr, int sum){
        if (nr < 10) {
            return sum;
        }
        sum += nr %10;  
        return sumOfDigitsOCifraRec(nr/10, sum);
    }

    public static String parolaRec(String parola, String caractere, int lungime){
        if (lungime == 0) {
            return parola;
        }
        int random = ThreadLocalRandom.current().nextInt(0, caractere.length()-1);
        parola += caractere.charAt(random);
        return parolaRec(parola, caractere, lungime-1);
    }

    public static String common(String s, HashMap<String,Integer> m, String max){
        if (s.isEmpty()) {
            return max;
        }
        int i = 0;
        String word = "";
        while (s.charAt(i) != ' ' && i < s.length()-1 ) {
            word += Character.toString(s.charAt(i++));
        }
        if (!m.containsKey(word)) {
            m.put(word,1);
        }
        else{
            m.put(word,m.get(word)+1);
        }
        if (m.get(max) != null) {
            if (m.get(max) < m.get(word)) {
                max = word;
            }
        }
        else{
            max = word;
        }

        return common(s.substring(i+1), m, max);
       

       

    }
    //ALTA VARINATA DE CEL MAI FOLOSIT CUVANT DOAR CA FARA HASHMAPS 
    // public static String MCW(String[] s, int i, int j, int max, String mcw, int verif) {
    //     if (i >= s.length) {
    //         return mcw;
    //     }

    //     if (j >= s.length) {
    //         if (verif > max) {
    //             max = verif;
    //             mcw = s[i];
    //         }
    //         return MCW(s, i + 1, max, 0, mcw, i + 1);
    //     }

    //     if (s[i].equals(s[j])) {
    //         verif++;
    //     }

    //     return MCW(s, i, max, verif, mcw, j + 1);
    // }
}
