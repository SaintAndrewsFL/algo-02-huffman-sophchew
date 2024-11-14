package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class HuffmanTree {

    MyNode rootNode;

    public HuffmanTree(MyNode rootNode) {
        this.rootNode = rootNode;
    }

    public void BFS() {
        Queue<MyNode> level = new LinkedList<>();
        int threshold = 1;
        int emptyCounted = 0;
        int count = 0;

        level.add(rootNode);//first level
        while(!level.isEmpty()) {
            MyNode node = level.remove();
            System.out.print(node.toString() + "    ");
            count++;

            if(node.getLeftChild() != null) {
                level.add(node.getLeftChild());
            } else {
                emptyCounted++;
            }
            if(node.getRightChild() != null) {
                level.add(node.getRightChild());
            } else {
                emptyCounted++;
            }
            if(count == threshold) {
                System.out.println();
                count = 0;
                threshold*=2;
                threshold -= emptyCounted;
                emptyCounted = 0;

            }
        }




    }




}

