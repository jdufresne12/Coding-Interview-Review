// LEETCODE PROVIDED

// ONLY USED FOR DELETENODE
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
