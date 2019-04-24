package com.zhengxin.algorithm.tree;

/**
 * Created by zhengxin on 16/12/13.
 */
public class BTree {

    public static TreeNode init(){

        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode6, null);
        TreeNode treeNode5 = new TreeNode(5);

        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode3 = new TreeNode(3);

        TreeNode root = new TreeNode(1, treeNode2, treeNode3);

        return root;
    }

    public static void preOrder(TreeNode root){

        if(null == root) return;

        System.out.print(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());

    }

    public static void midOrder(TreeNode root){

        if(null == root) return;

        midOrder(root.getLeft());
        System.out.print(root.getData());
        midOrder(root.getRight());

    }

    public static void postOrder(TreeNode root){

        if(null == root) return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData());

    }

    public static int countLeaf(TreeNode root){
        if(null == root) return 0;
        int m;
        int n;
        if(null == root.getLeft() && null == root.getRight()) return 1;
        else {
            m = countLeaf(root.getLeft());
            n = countLeaf(root.getRight());
            return (m + n);
        }
    }



    public static int depth(TreeNode root){
        int depthVal = 0;
        int depthLeft = 0;
        int depthRight = 0;
        if(null == root) return 0;
        else {
            depthLeft = depth(root.getLeft());
            depthRight = depth(root.getRight());
            depthVal = 1 + (depthLeft > depthRight ? depthLeft : depthRight);
        }

        return depthVal;
    }

    public static void main(String[] args){

        TreeNode root = init();

        preOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(countLeaf(root));
        System.out.println(depth(root));
        System.out.println();
        System.out.println();


    }



}

class TreeNode{

    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }


    public TreeNode(int data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
