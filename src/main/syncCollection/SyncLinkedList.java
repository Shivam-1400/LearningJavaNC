package main.syncCollection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SyncLinkedList {
    public static void main(String[] args) {
        List<Integer> ls= Collections.synchronizedList(new LinkedList<>());
        ls.add(1);
    }
}
