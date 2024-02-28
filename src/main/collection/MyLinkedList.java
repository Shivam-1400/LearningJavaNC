package main.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList {
    public static void main(String [] ag){
        LinkedList<Object> ll= new LinkedList<>();
        ll.add(123);
        ll.add(234);
        ll.add("Shivam");
        ll.add(false);
        ll.add(12.12f);
        ll.add(12.12);

        System.out.println(ll);
        System.out.println("=================");

        Iterator<Object> it= ll.iterator();
        while (it.hasNext()){
            System.out.println(it.next()+", ");
        }
        System.out.println("=================");

        Iterator<Object> dit= ll.descendingIterator();
        while (dit.hasNext()){
            System.out.println(dit.next()+", ");
        }


    }
}
//iterator
//descending iterator