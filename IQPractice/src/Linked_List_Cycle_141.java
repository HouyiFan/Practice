import java.util.HashSet;

public class Linked_List_Cycle_141 {

    // Two pointers (fast pointer and slow pointer)
    // Time: O(n)
    // Space: O(1)
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Hash Table
    // Time: O(n), in the worst case, there is no cycle, and we add n nodes to set
    // Space: O(n), in the worst case, the size of set is n
    public static boolean hasCycle1(ListNode head) {
        HashSet<ListNode> list = new HashSet<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        System.out.println(hasCycle(head)); // false
        head.next = new ListNode(0);
        System.out.println(hasCycle1(head)); // false
        head.next.next = head;
        System.out.println(hasCycle(head)); // true
        System.out.println(hasCycle1(head)); // true
    }

}
