package com.zhengxin;

import java.util.Stack;

/**
 * @author zhengxin
 * @date 2018-03-18 16:16:17
 */
public class BinTree {

//    private Node head;

    private static class Node<T>{

        private T data;
        private Node lchild;
        private Node rchild;

        public Node(T data, Node lchild, Node rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }

    }

    public static Node testTree(){
        return new Node("A", new Node("B", new Node("D", null, null), null), new Node("C", null, null));
    }


    private BinTree() {}

    // 先序遍历递归
    public static void preOrder(Node t) {
        if (t == null) {
            return;
        }
        System.out.print(t.data.toString());
        preOrder(t.lchild);
        preOrder(t.rchild);
    }

    // 中序遍历递归
    public static void InOrder(Node t) {
        if (t == null) {
            return;
        }
        InOrder(t.lchild);
        System.out.print(t.data.toString());
        InOrder(t.rchild);
    }

    // 后序遍历递归
    public static void PostOrder(Node t) {
        if (t == null) {
            return;
        }
        PostOrder(t.lchild);
        PostOrder(t.rchild);
        System.out.print(t.data.toString());
    }

    // 先序遍历非递归
    public static void preOrder2(Node t) {
        Stack<Node> s = new Stack<>();
        while (t != null || !s.empty()) {
            while (t != null) {
                System.out.print(t.data.toString());
                s.push(t);
                t = t.lchild;
            }
            if (!s.empty()) {
                t = s.pop();
                t = t.rchild;
            }
        }
    }

    // 中序遍历非递归
    public static void InOrder2(Node t) {
        Stack<Node> s = new Stack<>();
        while (t != null || !s.empty()) {
            while (t != null) {
                s.push(t);
                t = t.lchild;
            }
            if (!s.empty()) {
                t = s.pop();
                System.out.print(t.data.toString());
                t = t.rchild;
            }
        }
    }

    // 后序遍历非递归
    public static void PostOrder2(Node t) {
        Stack<Node> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Integer i = new Integer(1);
        while (t != null || !s.empty()) {
            while (t != null) {
                s.push(t);
                s2.push(new Integer(0));
                t = t.lchild;
            }
            while (!s.empty() && s2.peek().equals(i)) {
                s2.pop();
                System.out.print(s.pop().data.toString());
            }

            if (!s.empty()) {
                s2.pop();
                s2.push(new Integer(1));
                t = s.peek();
                t = t.rchild;
            }
        }
    }

    public static void main(String[] args) {


        Node head = testTree();

        /**
         *      a
         *     /  \
         *    b   c
         *   /
         *  d
         */

        BinTree.preOrder(head);
        System.out.println();
        BinTree.preOrder2(head);
        System.out.println();
        BinTree.InOrder(head);
        System.out.println();
        BinTree.InOrder2(head);
        System.out.println();
        BinTree.PostOrder(head);
        System.out.println();
        BinTree.PostOrder2(head);
    }
}
