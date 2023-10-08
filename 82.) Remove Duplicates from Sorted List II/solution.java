public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
        return head; // Empty list or a list with a single node, no duplicates.
    }

    ListNode dummy = new ListNode(0); // Create a dummy node to simplify edge cases.
    dummy.next = head;
    ListNode prev = dummy; // Pointer to the last node without duplicates.

    while (head != null) {
        boolean hasDuplicates = false;

        while (head.next != null && head.val == head.next.val) {
            head = head.next;
            hasDuplicates = true;
        }

        if (hasDuplicates) {
            // Skip all nodes with duplicate values.
            prev.next = head.next;
        } else {
            // Move the prev pointer forward.
            prev = prev.next;
        }

        head = head.next;
    }

    return dummy.next;
}
