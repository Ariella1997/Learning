public class Main {
    public static void main(String[] args){

        // Test code using the examples given on LeetCode

        ListNode l1 = new ListNode(2 , new ListNode(4 , new ListNode(3))) ; 
        ListNode l2 = new ListNode(5 , new ListNode(6 , new ListNode(4))) ; 

        ListNode l3 = new ListNode(0 ) ; 
        ListNode l4 = new ListNode(0) ; 

        ListNode l5 = new ListNode(9 , new ListNode(9 , new ListNode(9 , new ListNode(9 , new ListNode(9, new ListNode(9, new ListNode(9 ))))))) ; 
        ListNode l6 = new ListNode(9 , new ListNode(9 , new ListNode(9 , new ListNode(9 )))) ; 

        Solution solution = new Solution() ; 

        ListNode example1 = solution.addTwoNumbers(l1, l2) ; 
        ListNode example2 = solution.addTwoNumbers(l3, l4) ; 
        ListNode example3 = solution.addTwoNumbers(l5, l6) ; 

        printResult(example1, example2 , example3) ; 

    }

    private static void printResult(ListNode... arrays) {
        for(ListNode listNode : arrays){
            while(listNode != null){
                System.out.print(listNode.val) ; 
                listNode = listNode.next ; 
            }
            System.out.println() ; 
        }
    }
}
