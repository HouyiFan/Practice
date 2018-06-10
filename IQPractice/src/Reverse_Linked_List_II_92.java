
public class Reverse_Linked_List_II_92 {

    // Using 4 pointer: dummy, pre, start, then
    // Time: O(m + n)
    // Space: O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while (i < m - 1) {
            pre = pre.next;
            i++;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        //reverse the list from m to n
        while (i < n - 1) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            i++;
        }
        return dummy.next;
    }
}
