package com.zhengxin.algorithm.tree;

/**
 * Created by zhengxin on 16/12/14.
 */
public class BTree2 {

    public static void main(String[] args){


        Node node2 = new Node(2, 0, null);
        Node node1 = new Node(1, 0, node2);
        Node node0 = new Node(0, -1,node1);


        Node node3 = new Node(3, 1, null);

        Node[] nodes = new Node[]{node0,node1,node2,node3};



    }
}


class Node{

    private Node next;
    private int data;
    private int parent;


    public Node(int data, int parent,Node next){
        this.data = data;
        this.parent = parent;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
