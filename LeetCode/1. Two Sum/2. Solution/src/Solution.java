import java.util.HashMap; 

public class Solution {

    /*
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
       You may assume that each input would have exactly one solution, and you may not use the same element twice.
       You can return the answer in any order. 
    */
    
    public int[] twoSum(int[] nums, int target) {
        return Answer(nums , target , 0 , new HashMap<>()) ; 
    }

    private int[] Answer(int[] nums, int target, int index, HashMap<Integer,Integer> map){

        if(map.containsKey(nums[index])){
            // If HashMap does have the key, then it means we have two numbers that add to the target
            // The first index will be stored in the map, with the key beign nums[index]
            // The second index is our index counter.
            int[] solution = {map.get(nums[index]) , index} ; 
            return solution ; 
        }
        else{
            // If HashMap does not have the key, then we do not have two numbers that add up to target yet
            // We store the difference between the target and the number at nums[index], and place the index as value if we need to get it
            map.put(target - nums[index] , index) ; 
            // We can use a recursive call, incrementing the index. 
            return Answer(nums , target, index + 1 , map) ; 
        }
    }
    
}
