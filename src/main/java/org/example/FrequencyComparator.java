package org.example;

import java.util.Comparator;

public class FrequencyComparator implements Comparator<MyNode> {
    @Override
    public int compare(MyNode o1, MyNode o2) {
        return Integer.compare(o1.getFrequency(), o2.getFrequency());
    }

}
