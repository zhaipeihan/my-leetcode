package cc.peihan.polaris.core.t;

import java.util.LinkedList;

public class T104 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        System.out.println(new T104().maxDepth(treeNode1));
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode now = null;

        int cur, last, level = 0;

        while (!queue.isEmpty()) {
            cur = 0;
            last = queue.size();
            while (cur < last) {
                now = queue.poll();
                cur++;

                if (now.left != null) {
                    queue.offer(now.left);
                }

                if (now.right != null) {
                    queue.offer(now.right);
                }
            }
            level ++ ;
        }
        return level;
    }
}

