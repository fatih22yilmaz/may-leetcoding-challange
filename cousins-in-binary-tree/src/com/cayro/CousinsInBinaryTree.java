package com.cayro;

public class CousinsInBinaryTree {

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode((4))), new TreeNode(3, null, new TreeNode(5)));


        System.out.println("Is cousins: " + solution.isCousins2(root, 4, 5));
    }
}
