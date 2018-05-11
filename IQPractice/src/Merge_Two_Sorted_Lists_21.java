
public class Merge_Two_Sorted_Lists_21 {

    // Recursive method
    // Time: O(m + n), m is the size of l1, n is the size of l2
    // Space: O(m + n), system stack used by recursion
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    // Iterative method - add a prehead node
    // Time: O(n)
    // Space: O(1)
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prehead = new ListNode(-1); //whatever value you want
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return prehead.next;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 4, 1 -> 3 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4
        ListNode prehead = mergeTwoLists(l1, l2);
        System.out.print(prehead.val);
        prehead = prehead.next;
        while (prehead != null) {
            System.out.print(" -> " + prehead.val);
            prehead = prehead.next;
        }
    }

}
