package org.example;

public class MyNode {
    private Integer frequency;
    private Character val;
    private MyNode leftChild;
    private MyNode rightChild;

    public MyNode(MyNode leftChild, MyNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        frequency = leftChild.getFrequency() + rightChild.getFrequency();
    }

    public MyNode(Integer frequency, Character val) {
        this.frequency = frequency;
        this.val = val;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Character getVal() {
        return val;
    }

    public MyNode getLeftChild() {
        return leftChild;
    }

    public MyNode getRightChild() {
        return rightChild;
    }

    public String toString() {
        return "frequency: " + frequency + " char: " + val;
    }

}
