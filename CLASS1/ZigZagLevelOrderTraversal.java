package CLASS1;

/*
---------------------------------------------
🧠 CONCEPT: Zig-Zag (Spiral) Level Order Traversal
---------------------------------------------

➡️ In Zig-Zag or Spiral Level Order Traversal, 
we traverse the binary tree level by level like normal Level Order, 
but we **alternate the direction** of traversal on each level.

That means:
- First level → Left to Right  
- Second level → Right to Left  
- Third level → Left to Right  
... and so on.

---------------------------------------------
📘 EXAMPLE:
---------------------------------------------

Tree:
        1
       / \
      2   3
     / \ / \
    4  5 6  7

Normal Level Order: 1 2 3 4 5 6 7  
Zig-Zag Level Order: 1 3 2 4 5 6 7  

Explanation:
Level 1 → 1 (Left → Right)
Level 2 → 3 2 (Right → Left)
Level 3 → 4 5 6 7 (Left → Right)

---------------------------------------------
🧩 APPROACH (Using Queue + Direction Flag):
---------------------------------------------

1️⃣ Use a queue for normal level order traversal.  
2️⃣ Maintain a boolean flag `leftToRight` to track direction of traversal.  
3️⃣ For each level:
    - Create a list `subList` of size `levelSize`
    - If `leftToRight == true`, add elements from left to right  
      else, add them in reverse order (right to left)
4️⃣ After processing each level, flip the `leftToRight` flag.

---------------------------------------------
🕹️ DRY RUN EXAMPLE:
---------------------------------------------

Tree:
        1
       / \
      2   3
     / \
    4   5

Queue = [1]
leftToRight = true

Level 1: size = 1
→ subList = [1]
Add children → [2, 3]
ans = [[1]]
Flip flag → false

Level 2: size = 2
→ subList = [3, 2] (Right to Left)
Add children (4, 5)
ans = [[1], [3, 2]]
Flip flag → true

Level 3: size = 2
→ subList = [4, 5]
ans = [[1], [3, 2], [4, 5]] ✅

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

public class ZigZagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> subList = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add node value based on direction
                if (leftToRight)
                    subList.add(current.val);
                else
                    subList.add(0, current.val); // insert at beginning for reverse order

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }

            ans.add(subList);
            leftToRight = !leftToRight; // flip direction
        }

        return ans;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal obj = new ZigZagLevelOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Zig-Zag Level Order Traversal: " + obj.zigzagLevelOrder(root));
    }
}

