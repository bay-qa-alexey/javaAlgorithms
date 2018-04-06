// 104. Maximum Depth of Binary Tree (easy)
// Given binary tree [3,9,20,null,null,15,7]



public class MaxDepthOfBinaryTree {

    static public void main(String[] args) {
        TreeNode element1 = new TreeNode(3);
        TreeNode element2 = new TreeNode(9);
        TreeNode element3 = new TreeNode(20);
        TreeNode element4 = new TreeNode(15);
        TreeNode element5 = new TreeNode(7);

        element1.left = element2;
        element1.right = element3;
        element3.left = element4;
        element3.right = element5;

        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        System.out.println(maxDepthOfBinaryTree.maxDepth(element1));
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {return 0;}
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}
