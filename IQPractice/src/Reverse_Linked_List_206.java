
public class Reverse_Linked_List_206 {

    // Recursive method
    // Time: O(n)
    // Space: O(n) The extra space comes from implicit stack space due to recursion.
    // The recursion could go up to n levels deep.
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = this.reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // iterative method
    // Time: O(n)
    // Space: O(1)
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}
