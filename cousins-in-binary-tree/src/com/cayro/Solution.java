package com.cayro;

import com.sun.source.tree.Tree;

import java.util.Objects;

public class Solution {

    private int depthX = 0, depthY = 0;
    private TreeNode parentX, parentY;


    public boolean isCousins(TreeNode root, int x, int y) {

        int[] relativesX = findRelatives(root, x, 0, 0);
        int parentX = relativesX[0];
        int depthX = relativesX[1];

        int[] relativesY = findRelatives(root, y, 0, 0);
        int parentY = relativesY[0];
        int depthY = relativesY[1];

        return parentX != 0 && parentY != 0 && depthX != 0 && depthY != 0 && (parentX != parentY) && (depthX == depthY);
    }

    private int[] findRelatives(TreeNode traversal, int z, int parent, int depth) {

        if (Objects.isNull(traversal)) {
            return new int[0];
        }

        if (traversal.val == z) {
            return new int[]{parent, depth};
        }
        int[] relativesLeft = findRelatives(traversal.left, z, traversal.val, depth + 1);
        if (relativesLeft.length != 0) {
            return relativesLeft;
        }
        int[] relativesRight = findRelatives(traversal.right, z, traversal.val, depth + 1);
        if (relativesRight.length != 0) {
            return relativesRight;
        }

        return new int[0];
    }

    public boolean isCousins2(TreeNode root, int x, int y) {
        findRelatives2(root, null, x, y, 0);
        return parentX != null && parentY != null && depthX != 0 && depthY != 0 && (parentX != parentY) && (depthX == depthY);
    }

    private void findRelatives2(TreeNode traversal, TreeNode parent, int x, int y, int depth) {

        if (Objects.isNull(traversal)) {
            return;
        }

        if (traversal.val == x) {
            parentX = parent;
            depthX = depth;
        } else if (traversal.val == y) {
            parentY = parent;
            depthY = depth;
        } else {
            findRelatives2(traversal.left, traversal, x, y, depth + 1);
            findRelatives2(traversal.right, traversal, x, y, depth + 1);
        }
    }

}
