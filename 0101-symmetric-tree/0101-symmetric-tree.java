class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // both null → symmetric
        if (t1 == null && t2 == null) return true;

        // one null → not symmetric
        if (t1 == null || t2 == null) return false;

        // check value + mirror condition
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}