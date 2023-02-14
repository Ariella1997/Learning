public class Solution {
    public int[] twoSum(int[] nums, int target) { 
        int[] solution = {-1 , -1} ; 
        // Outerloop deals with the first index
            for(int i= 0 ; i< nums.length ; i++){
                // Innerloop ddeals with the second index. 
                // Note that the second loop will only evaluate indices after the first index, as we have already checked previous indices.
                for(int j = i+1 ; j < nums.length ; j++){
                    // If indices do add up to the target, we record them in the solution
                    if(nums[i] + nums[j] == target){
                        solution[0] = i ; 
                        solution[1] = j ;
                        break; 
                    }
                    // If indicies do not add up to the target, we will just increment the indicies until we do
                }
            }
        return solution ; 
    }
}