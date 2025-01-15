// John Dufresne 1/15/25

public class Solution {
    // Need to switch to commented out ListNode within the ListNode class
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            if(n == 1)
                return null;
            else 
                return head;
        }
        
        int i = 0, length = listLength(head); 
        ListNode current = head;
        ListNode prev = current;
        while(current != null && i != length - n){
            prev = current;
            current = current.next;
            i++;
        }

        if(current.next == null){
            prev.next = null;
        }
        else {
            current.val = current.next.val;
            current.next = current.next.next;
        }

        return head;
    }

    public static int listLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(current != null) { 
            length++; 
            current = current.next;
        }
        return length;
    }

    public ListNode reverseList(ListNode head) {
        
        return head;
    }
}
