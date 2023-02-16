public class Solution {
    public boolean isPalindrome(int x) {

        /*
        * Given an integer x, return true if x is a palindrome, and false otherwise.
        */

        return PalindromeChecker(x) ; 
        
    }

    private boolean PalindromeChecker(int x){
        // Convert answer into a string
        String y = String.valueOf(x) ; 
        // Counter will keep track of where the string stops being a Palindrome
        int counter = 0 ; 
        // Since we are checking from one end of the string to another, we only need to check up to the halfwaypoint of the String. 
        // We only need to perform n/2 checks for even length strings, and (n-1)/2 checks for odd Strings (as we do not need to check the character in the middle). This can be given as a formula floor(n/2)
        for( counter = 0 ; counter < Math.floor(y.length()/2) ; counter++){
            // The moment that we meet a character that would make the string not a Palindrome, we break out of the loop. 
            if(!String.valueOf(y.charAt(counter)).equals(String.valueOf(y.charAt(y.length() - 1 - counter)))){
                break ; 
            }
        }
        // If the counter got to the end, then it was a Palindrome. If the counter broke early, then it's false. 
        return (counter == Math.floor(y.length()/2)) ; 
    }
}
