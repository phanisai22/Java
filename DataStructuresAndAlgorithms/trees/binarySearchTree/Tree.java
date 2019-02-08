package trees.binarySearchTree;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null)
            root = new TreeNode(value);
        else
            root.insert(value);
    }

    public TreeNode get(int value) {
        if (root == null)
            return null;
        return root.get(value);
    }

    public int min() {
        if (root == null)
            return 100000;
        return root.min();
    }

    public int max() {
        if (root == null)
            return 100000;
        return root.max();
    }

    public void InOrder() {
        if (root == null)
            return;
        root.InOrder();
    }

}
