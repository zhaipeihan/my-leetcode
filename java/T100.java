package cc.peihan.polaris.core.t;

import java.util.ArrayList;
import java.util.List;

public class T100 {
    public static void main(String[] args) {
        T100 t100 = new T100();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode4.setLeft(treeNode5);
        treeNode4.setRight(treeNode6);

        boolean result = t100.isSameTree(treeNode1, treeNode4);
        System.out.println(result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> pOrder = new ArrayList<>();
        List<String> qOrder = new ArrayList<>();
        LDR(p,pOrder);
        LDR(q,qOrder);
        return pOrder.equals(qOrder);
    }

    private void LDR(TreeNode node, List<String> order) {
        if (node == null) {
            order.add("#");
            return;
        }
        visit(node, order);
        LDR(node.left, order);
        LDR(node.right, order);
    }

    private void visit(TreeNode node, List<String> order) {
        order.add(String.valueOf(node.val));
    }
}