// 106. Construct Binary Tree from Inorder and Postorder Traversal


import java.util.HashMap;

public class ConstructBinaryTreeInorderPostorder {

    static public void main(String[] args) {

        ConstructBinaryTreeInorderPostorder constructBinaryTreeInorderPostorder = new ConstructBinaryTreeInorderPostorder();
        int[] inorder = {4,2,5,1,6,7,3,8};
        int[] postorder = {4,5,2,6,7,8,3,1};
        int[] preorder = {1,2,4,5,3,7,6,8};

        TreeNode head = constructBinaryTreeInorderPostorder.buildTree(inorder, postorder);
        constructBinaryTreeInorderPostorder.printLevels(head);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inFinish = inorder.length-1;
        int postStart = 0;
        int postFinish = postorder.length-1;
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecursive(inorder, inStart, inFinish, postorder, postStart, postFinish, inorderMap);
    }

    public TreeNode buildTreeRecursive(int[] inorder, int inStart, int inFinish, int[] postorder, int postStart, int postFinish, HashMap inorderMap) {
        if(inStart > inFinish || postStart > postFinish) {return null;}

        int nodeValue = postorder[postFinish];
        TreeNode rezult = new TreeNode(nodeValue);

        int nodePosition = (int) inorderMap.get(nodeValue);

        rezult.left = buildTreeRecursive(inorder, inStart, nodePosition-1, postorder, postStart, postStart + (nodePosition-inStart-1), inorderMap);
        rezult.right = buildTreeRecursive(inorder, nodePosition+1, inFinish, postorder, postStart+(nodePosition-inStart), postFinish-1, inorderMap);

        return rezult;
    }

    public void printLevels(TreeNode root){
        for(int i=1;i<=maxDepth(root);i++){
            printLevelOrder(root, i);
            System.out.println();
        }
    }

    public void printLevelOrder(TreeNode t, int level){
        if(t==null) {
            System.out.print("null ");
            return;}
        if(level==1) System.out.print(t.val+ " ");
        if(level > 1){
            printLevelOrder(t.left, level-1);
            printLevelOrder(t.right, level-1);
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {return 0;}
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}
