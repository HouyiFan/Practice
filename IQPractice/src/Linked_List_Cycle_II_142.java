import java.util.HashSet;

public class Linked_List_Cycle_II_142 {

    // Two pointers (fast pointer and slow pointer)
    // Time: O(n)
    // Space: O(1)
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;

    }

    // Hash Table
    // Time: O(n), in the worst case, there is no cycle, and we add n nodes to set
    // Space: O(n), in the worst case, the size of set is n
    public static ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<ListNode> list = new HashSet<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }

}
