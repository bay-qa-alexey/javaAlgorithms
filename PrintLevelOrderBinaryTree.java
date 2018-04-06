

public class PrintLevelOrderBinaryTree {

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

        PrintLevelOrderBinaryTree printLevelOrderBinaryTree = new PrintLevelOrderBinaryTree();
        printLevelOrderBinaryTree.printLevels(element1);


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
