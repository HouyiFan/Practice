import java.util.Stack;

public class Binary_Search_Tree_Iterator_173 {
    public class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.fillStack(root);
        }

        // Time: O(1)
        // Space: O(h), where h is the height of BST
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        // Time: O(1) in average
        // Space: O(h), where h is the height of BST
        /** @return the next smallest number */
        public int next() {
            TreeNode node = this.stack.pop();
            this.fillStack(node.right);
            return node.val;
        }

        private void fillStack(TreeNode node) {
            TreeNode cur = node;
            while (cur != null) {
                this.stack.push(cur);
                cur = cur.left;
            }
        }
    }
}
