class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) {
            return head; // Base case: if the list is empty or has only one element, it's already sorted.
        }

        // Split the list into two halves.
        ListNode* slow = head;
        ListNode* fast = head->next;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* secondHalf = slow->next;
        slow->next = nullptr;

        // Recursively sort the two halves.
        ListNode* sortedFirstHalf = sortList(head);
        ListNode* sortedSecondHalf = sortList(secondHalf);

        // Merge the sorted halves.
        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    ListNode* merge(ListNode* first, ListNode* second) {
        ListNode dummy(0);
        ListNode* current = &dummy;

        while (first && second) {
            if (first->val < second->val) {
                current->next = first;
                first = first->next;
            } else {
                current->next = second;
                second = second->next;
            }
            current = current->next;
        }

        current->next = (first) ? first : second;
        return dummy.next;
    }
};