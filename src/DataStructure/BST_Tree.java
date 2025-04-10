package DataStructure;

public class BST_Tree {
    public TreeNode root;

    public BST_Tree() {
        root = null;
    }

    public boolean contains(int value) {
        // Nếu value < node.value tìm kiếm bên trái
        // Nếu value > node.value tìm kiếm bên phải
        // Nếu value == node.value => True
        // Nếu node.value == null => False
        if (root == null) {
            return false;
        } else {
            TreeNode current = root;
            while (true) {
                if (current == null) {
                    return false;
                }
                if (value > current.data) {
                    current = current.right;
                } else if (value < current.data) {
                    current = current.left;
                } else {
                    return true;
                }
            }
        }
    }
    // Container recursive
    public boolean container(int value) {
        return containsRecursive(root, value);
    }
    
    private boolean containsRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        } 
        if (value < current.data) {
            return containsRecursive(current.left, value);
        } else {
            return containsRecursive(current.right, value);
        }
    }
    public void insert(int value) {
        root = insert(root, value);
    }
    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
        } else {
            if (value < node.data) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
        }
        return node;
    }
    
}
