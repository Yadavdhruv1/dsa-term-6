package CLASS1;

// 🌳 PREORDER TRAVERSAL IN BINARY TREE
// -------------------------------------------
// 🧩 Definition:
// Preorder traversal means visiting nodes in this order:
//      ROOT → LEFT → RIGHT
//
// That is, we first process the current node (root),
// then recursively traverse its left subtree,
// and finally traverse its right subtree.
//
// Example Tree:
//         1
//        / \
//       2   3
//      / \   \
//     4   5   6
//
// Preorder Traversal Output → [1, 2, 4, 5, 3, 6]
//
// -------------------------------------------
// 🧠 RECURSIVE APPROACH:
//
// void preorder(Node root) {
//     if (root == null) return;
//
//     System.out.print(root.data + " "); // 1️⃣ Visit root
//     preorder(root.left);               // 2️⃣ Go left
//     preorder(root.right);              // 3️⃣ Go right
// }
//
// 🔹 Time Complexity: O(N) — each node is visited once
// 🔹 Space Complexity: O(H) — recursion stack (H = height of tree)
//
// -------------------------------------------
// 🧾 DRY RUN EXAMPLE:
// Tree:
//        1
//       / \
//      2   3
//     / \
//    4   5
//
// Step-by-step:
// preorder(1) → print(1)
//    preorder(2) → print(2)
//        preorder(4) → print(4)
//        preorder(5) → print(5)
//    preorder(3) → print(3)
//
// ✅ Output → [1, 2, 4, 5, 3]
//
// -------------------------------------------
// 📘 Summary:
// ➤ Order: ROOT → LEFT → RIGHT
// ➤ Simple recursive DFS traversal.
// ➤ Commonly used for copying or serializing a tree.

// Java Code Implementation:
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class PreorderTraversal {

    // Recursive Preorder Traversal
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " "); // 1️⃣ Visit root
        preorder(root.left);               // 2️⃣ Go left
        preorder(root.right);              // 3️⃣ Go right
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.print("Preorder Traversal: ");
        preorder(root);
    }
}

