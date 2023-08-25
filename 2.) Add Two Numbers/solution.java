class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head node to simplify handling the result
        ListNode current = dummyHead; // Current node for constructing the result list
        int carry = 0; // Initialize carry
        
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = carry + x + y;
            carry = sum / 10; // Update carry
            
            current.next = new ListNode(sum % 10); // Add a new node with the sum % 10
            current = current.next; // Move to the next node
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry); // If carry is left, add an additional node
        }
        
        return dummyHead.next; // Skip the dummy head and return the actual result
    }
}
