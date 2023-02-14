public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return Reverser(Addition(l1 , l2 , 0 , new ListNode() )) ; 

    }
    
    private ListNode Addition(ListNode l1 , ListNode l2 , int carriedOver, ListNode store){
        ListNode EmptyListNode = new ListNode(0) ; 
        // check that the listNodes aren't null. If they are we replace them with emptyListNodes
        if(l1 == null){
            l1 = EmptyListNode ; 
        }
        if(l2 == null){
            l2 = EmptyListNode ; 
        }
        // If both listNodes were null, then we don't have any more numbers to calculate
        if(l1 == EmptyListNode && l2 == EmptyListNode){
            // We add any carriedOver number to the front of the listNode if it wasn't 0. Otherwise we return the listNode
            if(carriedOver != 0){
                store = new ListNode(carriedOver , store) ; 
            }
            return store ; 
        }
        // If one listNode is not empty, then we need to perform some calculation
        else{
            int val = carriedOver + l1.val + l2.val ;
            // We now recursively call the method. 
            // We remove the values of the listNodes, (As we just did the calculation using those values)
            // we use the carriedOverValue method to calculate the carriedOver for the next recursion
            // To stop us from having val that are greater than 10, we decrement val by 10*carriedOverValue 
            return Addition(l1.next , l2.next, CarriedOverValue(val) , new ListNode(val - 10*CarriedOverValue(val)  , store )) ; 
        }
    }

    private int CarriedOverValue(int value){
        // If the value is 2-digit number, we need to carry the 1 over, and decrement the val by 10. 
        if(value > 9){
            return 1 ; 
        }
        // If the value is 1-digit number, we do not need carry over any value or decrement val by 10
        // Both of the above can be done using the number 0, as it's only called at the end of Addition() method
        else{
            return 0 ; 
        }
    }
    
    // The reverser method takes a listNode and reverses the order of the ListNode 
    private ListNode Reverser(ListNode l){
        // We do a single operation outside the while loop
        ListNode result = new ListNode(l.val) ; 
        l = l.next ; 
        while(l.next != null){
            // While the listNode still has size, we create a new result, with the head of the current listnode added to the head of a new listnode, and the previous result added as the tail 
            result = new ListNode(l.val , result) ; 
            // the listNode current head is deleted, and the listNode decrements in size
            l = l.next ; 
        }
        // Once we are done, we return the result 
        return result ; 
    }
}

