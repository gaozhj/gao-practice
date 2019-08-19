package com.example.demo.practice;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaozijian
 * @date 2019/8/16 14:26
 * 7. 重建二叉树
 */

public class test5 {
    @Data
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    private Map<Integer,Integer>  indexForInOrders = new HashMap<>();
    /**
     *
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @return
     */
    public TreeNode reConstructBinaryTree(int[]pre, int[]in){
        for (int i = 0; i < in.length ; i++) {
            indexForInOrders.put(in[i],i);
        }
        return reConstructBinaryTree(pre, 0,pre.length-1,0);
    }

    /**
     *
     * @param pre
     * @param preL 父节点数？
     * @param preR 前序左子树或者右子树全部节点数？
     * @param inL
     * @return
     */
    public TreeNode reConstructBinaryTree(int[]pre, int preL, int preR, int inL){
        if (preL > preR){
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;

        System.out.println(preL+"  "+inIndex+"  "+leftTreeSize+"  "+preR+"  "+inL);
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);

        return root;
    }
    public void printPostOrder(TreeNode root){
        if (root != null){

            printPostOrder(root.getLeft());
            System.out.print(root.getVal());
            printPostOrder(root.getRight());
        }
    }
    public void run(){
        // 二叉树的先序序列
        int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        // 二叉树的中序序列
        int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        System.out.println("preL"+"  "+"inIndex"+"  "+"leftTreeSize"+"  "+"preR"+"  "+"inL");
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        // 后序打印二叉树
        printPostOrder(root);
    }
    public static void main(String[] args) {
        test5 test5 = new test5();
        test5.run();
    }
}
