// John Dufresne 1/15/25

import java.util.List;

public class Solution {
    // Need to switch to commented out ListNode within the ListNode class
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            if (n == 1)
                return null;
            else
                return head;
        }

        int i = 0, length = listLength(head);
        ListNode current = head;
        ListNode prev = current;
        while (current != null && i != length - n) {
            prev = current;
            current = current.next;
            i++;
        }

        if (current.next == null) {
            prev.next = null;
        } else {
            current.val = current.next.val;
            current.next = current.next.next;
        }

        return head;
    }

    public static int listLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode revHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return revHead;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Handle edge cases
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head, mergedList;

        if (list1.val < list2.val) {
            mergedList = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            mergedList = new ListNode(list2.val);
            list2 = list2.next;
        }
        head = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergedList.next = new ListNode(list1.val);
                mergedList = mergedList.next;
                list1 = list1.next;
            } else {
                mergedList.next = new ListNode(list2.val);
                mergedList = mergedList.next;
                list2 = list2.next;
            }
        }

        // Changed these to while loops to handle all remaining nodes
        while (list1 != null) {
            mergedList.next = new ListNode(list1.val);
            mergedList = mergedList.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            mergedList.next = new ListNode(list2.val);
            mergedList = mergedList.next;
            list2 = list2.next;
        }

        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;  // Empty list or single node is a palindrome
        }
        
        // Step 1: Find the middle of the linked list using slow/fast pointer
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow.next);
        
        // Step 3: Compare first half with reversed second half
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
}
