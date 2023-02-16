import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs)  {

        /*
        * Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
        */

        // Passing in the base case for the recursion
        return Answer(strs , 0 , maximum(strs)) ; 

    }

    // This method takes the strs array, and returns the minimum length.
    // This acts as an upper limit to the number of recursion we will have to do
    private int maximum(String[] strs) {
        return Arrays.stream(strs)
        .mapToInt(x -> x.length())
        .min().orElse(0) ; 
    }

    private String Answer(String[] strs, int counter, int maximum) {
        // First we check that we have not reached the maximum number of recursions. 
        // If we have, we know that up this far, all string have a common prefix up to counter, so we take the first string (Which we can assume will exist) and take the first letters up to the counter index
        if(counter == maximum){
            return strs[0].substring(0 , counter ) ; 
        }
        else{
            // Reaching here means that we can safely check for the next character in each string 
            // We take the array, map each String to the character at the current counter, and count the number of distinct values
            long numberofUniqueCharacter = Arrays.stream(strs)
            .map(string -> string.charAt(counter))
            .distinct() 
            .count() ; 

            // If the number of distinct character is 1, then all String share the common character at the position counter. We increment the counter and call the method again. 
            if(numberofUniqueCharacter == 1){
                return Answer(strs , counter + 1 , maximum) ; 
            }
            // If we had more than one distinct character, then Strings do not share the common character at the position counter, but it does for all character before, so we take the first string (Which we can assume will exist) and take the first letters up to the counter index
            else{
                return strs[0].substring(0 , counter ) ; 
            }
        }
        
    }

}