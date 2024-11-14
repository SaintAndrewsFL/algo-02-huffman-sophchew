package org.example;

public class Main {
    public static void main(String[] args) {


        HuffmanTree tree =  HuffmanAlgo.encode("This tea is delightful");
        tree.BFS();

     //   System.out.println(HuffmanAlgo.readText("/Users/chews/Desktop/textFile2.txt"));
      //  HuffmanAlgo.writeToFile("Does this work?", "/Users/chews/Desktop/textFile2.txt");

    }
}