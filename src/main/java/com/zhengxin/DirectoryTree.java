package com.zhengxin;

import java.util.List;

/**
 * @author zhengxin
 * @date 2018-04-03 09:06:43
 */
public class DirectoryTree {

    private Node first;

    private static class Node{

        String name;
        List<Node> child;

        public Node(String name, List<Node> child){
            this.name = name;
            this.child = child;
        }

    }

    public void createTree(String[] paths){

        for (String path : paths){
            String[] names = path.split("/");

            Node p = first;

            while (p != null){

            }



        }

    }

}
