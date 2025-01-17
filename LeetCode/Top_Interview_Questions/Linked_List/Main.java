public class Main {
    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static ListNode findNode(ListNode head, int val) {
        if(head == null) return null;

        ListNode current = head;
        while(current != null) {
            if(current.val == val) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* 
            Delete Node 
            Test Case 1: [4,5,1,9], node = 5 
        */
        // int[] values1 = {4, 5, 1, 9};
        // ListNode head1 = createLinkedList(values1);
        // ListNode node_to_delete = findNode(head1, 5);
        // Solution node_1 = new Solution();
        // System.out.println("Before deletion:");
        // printLinkedList(head1);
        // node_1.deleteNode(node_to_delete);
        // System.out.println("After deletion:");
        // printLinkedList(head1);

        //-----------------------------------------------------------------------------

        /* 
            Remove Nth Node From End of List
            Input: head = [1,2,3,4,5], n = 2
            Output: [1,2,3,5] 
        */
        // int[] values = {1,2};
        // ListNode head = createLinkedList(values);
        // Solution solution = new Solution();
        // System.out.println("Before Nth from end deletion");
        // printLinkedList(head);
        // head = solution.removeNthFromEnd(head, 1);
        // System.out.println("After Nth from end deletion");
        // printLinkedList(head);

        //-----------------------------------------------------------------------------

        /* 
            Reverse a Linked List 
            Input: head = [1,2,3,4,5]
            Output: [5,4,3,2,1]
        */
        // int[] values = {1,2,3,4,5};
        // ListNode head = createLinkedList(values);
        // Solution solution = new Solution();
        // System.out.println("Before Reverse");
        // printLinkedList(head);
        // head = solution.reverseList(head);
        // System.out.println("After Reverse");
        // printLinkedList(head);

        //-----------------------------------------------------------------------------

        /* 
            Merge 2 Sorted Lists 
            Input: list1 = [1,2,4], list2 = [1,3,4]
            Output: [1,1,2,3,4,4]
        */
        int[] list1 = {1,2,3,4}, list2 = {1};
        ListNode head1 = createLinkedList(list1);
        ListNode head2 = createLinkedList(list2);
        Solution solution = new Solution();
        System.out.println("Merged Lists");
        printLinkedList(solution.mergeTwoLists(head1, head2));
        
        //-----------------------------------------------------------------------------

        /* 
            Palindrome Linked List 
            Input: head = [1,2,3,4,5]
            Output: [5,4,3,2,1]
        */

        //-----------------------------------------------------------------------------
        
        /* 
            Linked List Cylce
            Input: head = [1,2,3,4,5]
            Output: [5,4,3,2,1]
        */
    }
}