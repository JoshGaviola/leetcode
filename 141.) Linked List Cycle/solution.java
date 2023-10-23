/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false; // No cycle if the list is empty or has only one node
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;      // Move the slow pointer by one step
        fast = fast.next.next; // Move the fast pointer by two steps

        if (slow == fast) {
            return true; // If the pointers meet, there is a cycle
        }
    }

    return false; // No cycle found
}

}