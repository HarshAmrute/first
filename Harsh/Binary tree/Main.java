public class Main {

    // Inner TreeNode class
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        // Constructor
        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        // Create the root node
        TreeNode root = new TreeNode(10);

        // Create and assign children
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(20);

        // Display the tree
        System.out.println("Tree Structure:");
        printTree(root, 0);

        // Calculate and display height
        System.out.println("Height of the tree: " + findHeight(root));
    }

    // Method to calculate the height of the tree
    static int findHeight(TreeNode node) {
        if (node == null) 
            return -1; // Return -1 if counting edges
        
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Method to print the tree (rotated 90 degrees)
    static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        // Print right subtree first
        printTree(node.right, level + 1);

        // Indentation for the current level
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 4 spaces per level
        }

        // Print node value
        System.out.println(node.value);

        // Print left subtree
        printTree(node.left, level + 1);
    }
}
