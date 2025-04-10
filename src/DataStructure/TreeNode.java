package DataStructure;

public class TreeNode {
    int data;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int value) {
        data = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        data = value;
        this.left = left;
        this.right = right;
    }
}
