public class Main {
    public static void main(String[] args) {

        // Test code using the examples given on LeetCode
        
        Solution solution = new Solution() ; 

        int[] example1nums = {2,7,5,11} ; 
        int example1target = 9 ; 

        int[] example2nums = {3,2,4} ; 
        int example2target = 6 ; 

        int[] example3nums = {3,3} ; 
        int example3target = 6 ; 

        int[] example1Answer = solution.twoSum(example1nums , example1target) ; 
        int[] example2Answer = solution.twoSum(example2nums , example2target) ; 
        int[] example3Answer = solution.twoSum(example3nums , example3target) ; 

        printResult(example1Answer,example2Answer,example3Answer) ; 
        
    }

    public static void printResult(int[]... arrays){
        for(int[] array : arrays ){
            for(int number : array){
                System.out.print(number + " ") ; 
            }
            System.out.println() ; 
        }
    } 
}
