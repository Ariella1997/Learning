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

        HashMap<Character,Integer> romanToInt = new HashMap<>() ; 
        romanToInt.put('I' , 1) ; 
        romanToInt.put('V' , 5) ; 
        romanToInt.put('X' , 10) ; 
        romanToInt.put('L' , 50) ; 
        romanToInt.put('C' , 100) ; 
        romanToInt.put('D' , 500) ; 
        romanToInt.put('M' , 1000) ; 

        // Perform a recursive operation, giving the starting case
        return Answer(s , romanToInt, 0) ; 
    }

    private int Answer(String s , HashMap<Character,Integer> map, int accumulator){
        // If the length is 0, we have reached the end, and simple need to return what was accumulated 
        if(s.length() == 0){
            return accumulator ; 
        }
        // If the next two characters in the string exist in the map and the second character is larger than the first character, it means we have something like IV or IX, 
        // 1. remove the first two characters from the string 
        // 2. increment the accumulator by the value of the larger value minus the value of the smaller value
        else if( s.length() >= 2 && ( map.get(s.charAt(1)) > map.get(s.charAt(0)))){
            return Answer(s.substring(2 , s.length()) , map , accumulator + map.get(s.charAt(1)) - map.get(s.charAt(0))) ; 
        }
        // If the next two characters in the string did not exist in the map, we 
        // 1. remove the first character from the string 
        // 2. increment the accumulator by the value of the one character in the map.
        else{
            return Answer(s.substring(1, s.length()) , map , accumulator + map.get(s.charAt(0))) ; 
        }
    }

}