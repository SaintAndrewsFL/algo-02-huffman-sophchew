package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HuffmanAlgo {


    public static HuffmanTree encode(String text) {
        // STEP 1: Frequency table
        HashMap<String, Integer> frequencyTable = new HashMap<>();
        for (int i = 1; i <= text.length(); i++) {
            String c = text.substring(i - 1, i);
            if (frequencyTable.containsKey(c)) {
                frequencyTable.replace(c, frequencyTable.get(c) + 1);
            } else {
                frequencyTable.put(c, 1);
            }
        }
        System.out.println(frequencyTable);

        // STEP 2: Priority Queue by frequency
        FrequencyComparator comp = new FrequencyComparator();
        PriorityQueue<MyNode> queue = new PriorityQueue<>(comp);
        Iterator tableIterator = frequencyTable.entrySet().iterator();
        while (tableIterator.hasNext()) {
            Map.Entry element = (Map.Entry) tableIterator.next();
            MyNode node = new MyNode((Integer) element.getValue(), ((String) element.getKey()).charAt(0));
            queue.add(node);
        }

        // STEP 3: Building Huffman Tree

        while (queue.size() > 1) {
            MyNode node1 = queue.remove();
            MyNode node2 = queue.remove();

            MyNode combinedNode = new MyNode(node1, node2);
            queue.add(combinedNode);
        }

        HuffmanTree tree = new HuffmanTree(queue.remove());
        return tree;



    }

    public static String decode(HuffmanTree tree, String text) { // right-1 left-0
        MyNode currentNode = tree.rootNode;
        String toReturn = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).equals("0")) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode.getLeftChild() == null) {
                toReturn += currentNode.getVal().toString();
                currentNode = tree.rootNode;
            }

        }

        return toReturn;

    }

    public static String readText(String textFile) {
        try {
            Scanner in = new Scanner(new FileReader(textFile));
            StringBuilder sb = new StringBuilder();
            while (in.hasNextLine()) {
                sb.append(in.nextLine());
            }
            in.close();
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "";
    }

    public static boolean writeToFile(String text, String fileLocation) {
        try {
            // Writing into the file
            Files.writeString(Path.of(fileLocation), text);
            return true;


        } catch (IOException e) {
            // Handling any I/O exceptions
           System.out.println(e);
            return false;
        }
    }


}
