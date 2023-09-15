class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            // Initialize pointers for the two nodes to be swapped
            ListNode node1 = current.next;
            ListNode node2 = current.next.next;

            // Perform the swap
            current.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            // Move the current pointer to the next pair
            current = node1;
        }

        return dummy.next;
    }
}
