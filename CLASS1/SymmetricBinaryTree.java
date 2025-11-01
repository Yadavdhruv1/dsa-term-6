package CLASS1;

/*
---------------------------------------------
🧠 CONCEPT: Symmetric Binary Tree
---------------------------------------------

A Binary Tree is called **symmetric** if it is a mirror image of itself
around its center.

In simple terms:
➡️ The left subtree should be a mirror image of the right subtree.

---------------------------------------------
📘 EXAMPLE:
---------------------------------------------

        1
       / \
      2   2
     / \ / \
    3  4 4  3     ✅ Symmetric Tree

        1
       / \
      2   2
       \   \
        3   3     ❌ Not Symmetric

---------------------------------------------
🧩 APPROACH (Recursive):
---------------------------------------------

1️⃣ If the tree is empty → return true  
2️⃣ Else, check if the left and right subtrees are mirrors of each other  
    🔸 Check if both nodes exist and have the same value  
    🔸 Recursively verify:
        - left.left vs right.right
        - left.right vs right.left  

---------------------------------------------
🕹️ DRY RUN EXAMPLE:
---------------------------------------------

Tree:
        1
       / \
      2   2
     / \ / \
    3  4 4  3

Step-by-step:
- Compare (1, 1) → same ✅  
- Compare (2, 2) → same ✅  
- Compare (3, 3) and (4, 4) → both same ✅  
=> Therefore, symmetric ✅

---------------------------------------------
*/

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SymmetricBinaryTree {

    // Function to check if a tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null)
            return true;

        // Check if left and right subtrees are mirrors
        return isMirror(root.left, root.right);
    }

    // Helper function to check mirror condition
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both are null → symmetric
        if (t1 == null && t2 == null)
            return true;

        // If only one is null → not symmetric
        if (t1 == null || t2 == null)
            return false;

        // Check if current nodes are same and subtrees are mirrors
        if (t1.data != t2.data)
            return false;

        // Recursively check mirror condition
        boolean leftMirror = isMirror(t1.left, t2.right);
        boolean rightMirror = isMirror(t1.right, t2.left);

        return leftMirror && rightMirror;
    }

    public static void main(String[] args) {
        // Create symmetric tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is the tree symmetric? " + isSymmetric(root));
    }
}
