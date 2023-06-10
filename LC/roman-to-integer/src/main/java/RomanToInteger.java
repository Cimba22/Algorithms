import java.util.HashMap;
import java.util.Map;

//Runtime of this solution is 7ms

//Algorithm
//        Iterate over each character of the given string of roman numerals.
//        Compare the value of the current roman character with its right roman character.
//        If the current value is greater than or equal to the value of the symbol to the right, add the current character's value to the total variable.
//        If the current value is less than the value of the symbol to the right, subtract the current character's value from the total variable.
public class RomanToInteger {

    public static int romToInt(String s){

        Map<Character, Integer> symbolAndValue = new HashMap<Character, Integer>();

        symbolAndValue.put('I', 1);
        symbolAndValue.put('V', 5);
        symbolAndValue.put('X', 10);
        symbolAndValue.put('L', 50);
        symbolAndValue.put('C', 100);
        symbolAndValue.put('D', 500);
        symbolAndValue.put('M', 1000);
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");

        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            number = number + (symbolAndValue.get(s.charAt(i)));
        }
        System.out.println("The corresponding Integer value is: "+ number);
        return number;
    }

    public static void main(String[] args) {
        romToInt("MCMXV");
    }
}
