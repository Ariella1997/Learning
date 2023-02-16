import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {

        /*
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9. 
        X can be placed before L (50) and C (100) to make 40 and 90. 
        C can be placed before D (500) and M (1000) to make 400 and 900.

        Given a roman numeral, convert it to an integer.
        */

        // Construct a map containing the roman numerals, as well as their int values. 
        HashMap<String,Integer> RomanValues = new HashMap<String,Integer>() ; 
        RomanValues.put("I" , 1) ; 
        RomanValues.put("V" , 5) ; 
        RomanValues.put("X" , 10) ; 
        RomanValues.put("L" , 50) ; 
        RomanValues.put("C" , 100) ; 
        RomanValues.put("D" , 500) ; 
        RomanValues.put("M" , 1000) ; 
        RomanValues.put("IV" , 4) ; 
        RomanValues.put("IX" , 9) ; 
        RomanValues.put("XL" , 40) ; 
        RomanValues.put("XC" , 90) ; 
        RomanValues.put("CD" , 400) ; 
        RomanValues.put("CM" , 900) ; 

        // Perform a recursive operation, giving the starting case
        return Answer(s , RomanValues, 0) ; 
    }

    private int Answer(String s , HashMap<String,Integer> map, int accumulator){
        // If the length is 0, we have reached the end, and simple need to return what was accumulated 
        if(s.length() == 0){
            return accumulator ; 
        }
        // If the next two characters in the string exist in the map, we 
        // 1. remove the first two characters from the string 
        // 2. increment the accumulator by the value of the two characters that was stored in the map. 
        else if( s.length() >= 2 && map.containsKey(s.substring(0,2))){
            return Answer(s.substring(2 , s.length()) , map , accumulator + map.get(s.substring(0,2))) ; 
        }
        // If the next two characters in the string did not exist in the map, we 
        // 1. remove the first character from the string 
        // 2. increment the accumulator by the value of the one character in the map.
        else{
            return Answer(s.substring(1, s.length()) , map , accumulator + map.get(s.substring(0 , 1))) ; 
        }
    }

}