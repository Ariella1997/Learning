import java.util.HashMap; 

public class Solution {

    /*
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
       You may assume that each input would have exactly one solution, and you may not use the same element twice.
       You can return the answer in any order. 
    */
    
    public int[] twoSum(int[] nums, int target) {

        // HashMap will store values that we pass through
        HashMap<Integer,Integer> map= new HashMap<>() ;
        // solution will hold our solution 
        int[] solution = new int[2] ;  

        // Iterate over the array
        for(int i = 0 ; i < nums.length ; i++){
            // If we do have a matching key, we place the index of the key and the current index into the solution, and break from the loop
            if(map.containsKey(nums[i])){
                solution[0] = map.get(nums[i]); 
                solution[1] = i ; 
                break ; 
            }
            // If we have not seen the necessary number, we place the required number as the key and the index as the value into the HashMap
            else{
                map.put(target - nums[i] , i) ; 
            }
        }

        return solution ; 

    }   
}
