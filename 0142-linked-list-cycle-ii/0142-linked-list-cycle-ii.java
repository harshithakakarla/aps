public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) 
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {   // Cycle detected
                // Step 2: Find start of cycle
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;   // Start of cycle
            }
        }

        return null;  // No cycle
    }
}