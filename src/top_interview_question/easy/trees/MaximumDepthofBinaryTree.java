package top_interview_question.easy.trees;

public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {

        return 0;
        
    }

    public static void main(String[] args) {

        /**
         * 
         * Input: root = [3,9,20,null,null,15,7]
         * Output: 3
         * 
         *        3
         *      /   \
         *     9    20
         *          / \
         *        15   7
         * 
         */

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right= node7;

        MaximumDepthofBinaryTree aa = new MaximumDepthofBinaryTree();
        System.out.println("maxDepth: " + aa.maxDepth(node3));
        

    }
}

