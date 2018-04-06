// 105. Construct Binary Tree from Preorder and Inorder Traversal (fast)


import java.util.HashMap;

public class ConstructBinaryTreePreorderInorder {

    static public void main(String[] arg) {

        ConstructBinaryTreePreorderInorder constructBinaryTreePreorderInorder = new ConstructBinaryTreePreorderInorder();
        int[] inorder = {4,2,5,1,6,7,3,8};
        int[] postorder = {4,5,2,6,7,8,3,1};
        int[] preorder = {1,2,4,5,3,7,6,8};

        TreeNode head = constructBinaryTreePreorderInorder.buildTree(preorder, inorder);
        constructBinaryTreePreorderInorder.printLevels(head);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0;
        int inFinish = inorder.length-1;
        int preStart = 0;
        int preFinish = preorder.length-1;
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecursive(inorder, inStart, inFinish, preorder, preStart, preFinish, inorderMap);
    }

    public TreeNode buildTreeRecursive(int[] inorder, int inStart, int inFinish, int[] preorder, int preStart, int preFinish, HashMap inorderMap) {
        if(inStart > inFinish || preStart > preFinish) {return null;}

        int nodeValue = preorder[preStart];
        TreeNode rezult = new TreeNode(nodeValue);

        int nodePosition = (int) inorderMap.get(nodeValue);

        rezult.left = buildTreeRecursive(inorder, inStart, nodePosition-1, preorder, preStart + 1, preStart + 1 + (nodePosition-inStart-1), inorderMap);
        rezult.right = buildTreeRecursive(inorder, nodePosition+1, inFinish, preorder, preStart + 1 + (nodePosition-inStart), preFinish, inorderMap);

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
