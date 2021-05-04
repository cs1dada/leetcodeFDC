package top_interview_question.easy.trees;

public class ValidateBinarySearchTree {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public boolean recursiveCHK2(TreeNode root, Integer uplimit, Integer lowlimit) {

        if (root == null) {
            return true;
        }
        /**
         * 
         * if ((root.left!=null && root.val>root.left.val )) {
         * 
         * }
         * 
         * if ((root.right!=null && root.val<root.right.val)) {
         * 
         * } return recursiveCHK(root.left, uplimit, lowlimit) &&
         * recursiveCHK(root.right, uplimit, lowlimit);
         */

        // The current node's value must be between low and high.
        if ((uplimit != null && root.val > uplimit) || (lowlimit != null && root.val < lowlimit)) {
            return false;
        }
        // The left and right subtree must also be valid
        return recursiveCHK(root.left, root.val, lowlimit) && recursiveCHK(root.right, uplimit, root.val);

    }

    public boolean recursiveCHK(TreeNode root, Integer uplimit, Integer lowlimit) {

        if (root == null) {
            return true;
        }

        // The current node's value must be between low and high.
        if ((uplimit != null && root.val >= uplimit) || (lowlimit != null && root.val <= lowlimit)) {
            return false;
        }
        // The left and right subtree must also be valid
        return recursiveCHK(root.left, root.val, lowlimit) && recursiveCHK(root.right, uplimit, root.val);

    }

    public boolean isValidBST(TreeNode root) {
        return recursiveCHK( root,  null,  null);

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
        node20.right = node7;

        ValidateBinarySearchTree aa = new ValidateBinarySearchTree();
        System.out.println("maxDepth: " + aa.maxDepth(node3));

        System.out.println("valid: " + aa.isValidBST(node3));

    }
}
