package CLASS1;

/*
---------------------------------------------
🧠 CONCEPT: Invert a Binary Tree
---------------------------------------------

Also known as **Mirror a Binary Tree**.

➡️ Inversion means swapping every left child with its corresponding right child 
in the entire binary tree.

---------------------------------------------
📘 EXAMPLE:
---------------------------------------------

Original Tree:
        1
       / \
      2   3
     / \   \
    4  5    6

After Inversion:
        1
       / \
      3   2
     /   / \
    6   5  4

---------------------------------------------
🧩 APPROACH (Recursive):
---------------------------------------------

1️⃣ Base Case:
    - If root == null → return null

2️⃣ Recursively invert the left and right subtrees:
    - invertTree(root.left)
    - invertTree(root.right)

3️⃣ Swap the left and right pointers of the current node.

4️⃣ Return the root (so the parent node can link it properly).

---------------------------------------------
🕹️ DRY RUN EXAMPLE:
---------------------------------------------

Original Tree:
        1
       / \
      2   3

Step 1: Start with root (1)
Step 2: Recursively invert left (2) and right (3)
Step 3: Swap (2) and (3)

Result:
        1
       / \
      3   2
✅ Done!

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

public class InvertBinaryTree {

    // Function to invert the binary tree
    public static TreeNode invertTree(TreeNode root) {
        // Base case
        if (root == null)
            return null;

        // Recursively invert left and right subtrees
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        // Swap left and right pointers
        root.left = rightInverted;
        root.right = leftInverted;

        return root;
    }

    // Helper function for inorder traversal (to verify inversion)
    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Original Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Inorder before inversion:");
        inorder(root);

        // Invert the tree
        invertTree(root);

        System.out.println("\nInorder after inversion:");
        inorder(root);
    }
}
