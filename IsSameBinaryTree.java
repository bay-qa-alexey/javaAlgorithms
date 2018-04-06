// 100. Same Tree (easy)
// Given two binary trees, write a function to check if they are the same or not.
// Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


public class IsSameBinaryTree {

    static public void main(String[] args) {

        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(20);
        TreeNode p4 = new TreeNode(15);
        TreeNode p5 = new TreeNode(7);

        p1.left = p2;
        p1.right = p3;
        p3.left = p4;
        p3.right = p5;

        TreeNode q1 = new TreeNode(3);
        TreeNode q2 = new TreeNode(9);
        TreeNode q3 = new TreeNode(20);
        TreeNode q4 = new TreeNode(15);
        TreeNode q5 = new TreeNode(7);

        q1.left = q2;
        q1.right = q3;
        q3.left = q4;
        q3.right = q5;

        IsSameBinaryTree isSameBinaryTree = new IsSameBinaryTree();
        System.out.println(isSameBinaryTree.isSameTree(p1, q1));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {return true;}
        return p!=null && q!=null & p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
