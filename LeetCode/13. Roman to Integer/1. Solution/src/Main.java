public class Main {
    public static void main(String[] args) {

        // Test code using the examples given on LeetCode

        Solution solution = new Solution() ; 

        int example1 = solution.romanToInt("III") ; 
        int example2 = solution.romanToInt("LVIII") ; 
        int example3 = solution.romanToInt("MCMXCIV") ; 

        printResult(example1, example2, example3) ; 
        
    }

    private static void printResult(int... arrays) {
        for(int result : arrays){
            System.out.println(result) ; 
        }
    }
}
