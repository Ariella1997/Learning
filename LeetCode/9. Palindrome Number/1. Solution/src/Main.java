public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution() ; 

        // Test code using the examples given on LeetCode

        boolean example1 = solution.isPalindrome(121) ; 
        boolean example2 = solution.isPalindrome(-121) ; 
        boolean example3 = solution.isPalindrome(10) ; 

        printResult(example1,example2,example3) ; 

        
    }

    public static void printResult(boolean... arrays){
        for(boolean bool : arrays ){
            System.out.println(bool) ; 
        }
    } 
}
