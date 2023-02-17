public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself. */

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
            // We use the next ListNode for each ListNode (As we just did the calculation using those values)
            // we use the carriedOverValue method to calculate the carriedOver for the next recursion
            // To stop us from having val that are greater than 10, we decrement val by 10*carriedOverValue 
            return Addition(l1.next , l2.next, CarriedOverValue(val) , new ListNode(val - 10*CarriedOverValue(val)  , store )) ; 
        }
    }

    private int CarriedOverValue(int value){
        // This method retuns 0 for numbers less than 10, and 1 for numbers greater than 10, but less than 20
        // The addition of two single positive digit numbers is always less than 19. If we carry over 1, the answer is always less than 20. 
        // The addition of two single positive digit numbers is always greater than -1. 
        // So we only need this to work for 0-19. 
        return (value - value%10)/10 ; 
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

