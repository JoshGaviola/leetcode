/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode* next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode* next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        if (!head || !head->next) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast->next && fast->next->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        // Split the list into two halves
        ListNode* secondHalf = slow->next;
        slow->next = nullptr;

        // Step 2: Reverse the second half of the linked list
        ListNode* prev = nullptr;
        ListNode* current = secondHalf;
        ListNode* next;

        while (current) {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }
        secondHalf = prev;

        // Step 3: Merge the two halves to reorder the list
        ListNode* firstHalf = head;

        while (secondHalf) {
            ListNode* firstNext = firstHalf->next;
            ListNode* secondNext = secondHalf->next;
            firstHalf->next = secondHalf;
            secondHalf->next = firstNext;
            firstHalf = firstNext;
            secondHalf = secondNext;
        }
    }
};
