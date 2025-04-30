// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = head.next;

        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.next != null) {
            ListNode nextStart = current.next.next;
            ListNode second = current.next;

            second.next = current;
            current.next = nextStart;

            if (prev != null) {
                prev.next = second;
            }

            prev = current;
            current = nextStart;
        }

        return newHead;
    }

    private static ListNode addNode(ListNode head, int val) {
        ListNode current = new ListNode();
        current = head;

        while (current.next != null) {
            current = current.next;
        }

        ListNode newNode = new ListNode(val, null);
        current.next = newNode;

        return head;
    }

    private static void printList(ListNode head) {
        ListNode current = new ListNode();
        current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            if (current.next != null) {
                System.out.print("-> ");
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        SwapNodePairs solution = new SwapNodePairs();

        head = addNode(head, 2);
        head = addNode(head, 3);
        head = addNode(head, 4);
        head = solution.swapPairs(head);

        printList(head);
    }
}
