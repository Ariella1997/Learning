public class Solution {
    public int[] twoSum(int[] nums, int target) { 

        /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        */

        // Create an array that will contain the solution 
        int[] solution = new int[2] ; 
        // Boolean value will act as the break condition. At the start, the solution is not found
        boolean solutionFound = false ; 
        while(!solutionFound){
            // Iterate over all the elements in the array
            for(int i = 0 ; i < nums.length ; i++){
                // To reduce the number of checks, the second iterator only iterates over elements to the right of the current "i" index
                // Anything to the left would have already been checked
                for(int j = i+1 ; j < nums.length ; j++){
                    // condition is met, we place the indexes in the solution, and then mark that the solution has been found (breaking from the while loop)
                    if(nums[i] + nums[j] == target){
                        solution[0] = i ; 
                        solution[1] = j ;
                        solutionFound = true ; 
                    }
                }
            }
        }

        // return the solution. 
        return solution ; 
    }
}