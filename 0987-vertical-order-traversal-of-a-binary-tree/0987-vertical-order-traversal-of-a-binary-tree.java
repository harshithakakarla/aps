import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        // sort by col, then row, then value
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // col
            if (a[1] != b[1]) return a[1] - b[1]; // row
            return a[2] - b[2]; // value
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] node : list) {
            int col = node[0], val = node[2];

            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }

            result.get(result.size() - 1).add(val);
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;

        list.add(new int[]{col, row, root.val});

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}