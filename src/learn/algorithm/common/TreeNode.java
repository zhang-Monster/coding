package learn.algorithm.common;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/11 下午6:20
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
