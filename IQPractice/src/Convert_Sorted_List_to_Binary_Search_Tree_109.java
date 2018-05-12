import java.util.LinkedList;
import java.util.Queue;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    // Time: O(nlogn), where n is the number of elements in linked list
    // Since each level of recursive call requires a total of n/2 traversal
    // steps in the list, and there are a total of logn number of levels
    // (the height of the balanced tree).
    // Space: O(n)
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    private static TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

    // Similar solution to #108
    // Time: O(nlogn)
    // Space: O(n)
    public static TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        int low = 0;
        int high = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            high++;
        }
        return helper(head, low, high);
    }

    private static TreeNode helper(ListNode head, int low, int high) {
        if (low > high) {
            return null;
        }
        ListNode temp = head;
        int mid = low + (high - low) / 2;
        int i = 0;
        while (i < mid) {
            temp = temp.next;
            i++;
        }
        if (temp != null) {
            TreeNode root = new TreeNode(temp.val);
            root.left = helper(head, low, mid - 1);
            root.right = helper(head, mid + 1, high);
            return root;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = sortedListToBST(head);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            System.out.println(temp.val);
        }

    }

}
