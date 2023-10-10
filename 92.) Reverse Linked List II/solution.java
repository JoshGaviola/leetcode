/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null) {
        return null;
    }

    // Create a dummy node before the head to handle the case when left is 1
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    // Move to the node before the left position
    for (int i = 1; i < left; i++) {
        prev = prev.next;
    }

    ListNode leftNode = prev.next;
    ListNode rightNode = leftNode;
    ListNode temp;

    // Reverse the sublist from left to right
    for (int i = left; i < right; i++) {
        temp = leftNode.next;
        leftNode.next = temp.next;
        temp.next = prev.next;
        prev.next = temp;
    }

    return dummy.next;
}

}