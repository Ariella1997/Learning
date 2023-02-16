public class Main {
    public static void main(String[] args) {

        // Test code using the examples given on LeetCode

        Solution solution = new Solution() ; 

        String example1 = solution.longestCommonPrefix(new String[] {"flower","flow","flight"}) ; 
        String example2 = solution.longestCommonPrefix(new String[] {"dog","racecar","car"}) ; 

        printResult(example1, example2);
        
    }

    private static void printResult(String... arrays) {
        for(String result : arrays){
            System.out.println(result) ; 
        }
    }
}
