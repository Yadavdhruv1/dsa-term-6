package CLASS1;

/*
---------------------------------------------
🧠 CONCEPT: Level Order Traversal (Level-wise / Line-by-Line)
---------------------------------------------

➡️ In this version of Level Order Traversal, we print or store 
the nodes **level by level**, so each level appears separately.

It uses a **Queue** data structure to process nodes in breadth-first order.

---------------------------------------------
📘 EXAMPLE:
---------------------------------------------

Tree:
        1
       / \
      2   3
     / \   \
    4   5   6

Level Order Traversal (Level-wise):
Output:
[ [1], [2, 3], [4, 5, 6] ]

---------------------------------------------
🧩 APPROACH (Using Queue - BFS):
---------------------------------------------

1️⃣ Create a queue and push the root node.
2️⃣ While the queue is not empty:
    - Determine the number of nodes in the current level (`size`).
    - For each node in that level:
        → Pop from queue  
        → Add its value to a sublist  
        → Push its left and right children (if they exist)
    - After processing the level, add the sublist to the final answer list.

---------------------------------------------
🕹️ DRY RUN EXAMPLE:
---------------------------------------------

Tree:
        1
       / \
      2   3
     / \
    4   5

Queue process:

Step 1: queue = [1]
size = 1 → sublist = [1]
Add children → [2, 3]
ans = [[1]]

Step 2: queue = [2, 3]
size = 2 → sublist = [2, 3]
Add children (4,5) → [4, 5]
ans = [[1], [2, 3]]

Step 3: queue = [4, 5]
size = 2 → sublist = [4, 5]
ans = [[1], [2, 3], [4, 5]] ✅

---------------------------------------------
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class LevelOrderTraversalByLevel {

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (A == null)
            return ans;

        queue.offer(A);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> subList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            ans.add(subList);
        }

        return ans;
    }

    // Driver code for testing
    public static void main(String[] args) {
        LevelOrderTraversalByLevel obj = new LevelOrderTraversalByLevel();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Level Order Traversal (Level-wise): " + obj.solve(root));
    }
}

