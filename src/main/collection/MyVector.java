package main.collection;

import java.util.Iterator;
import java.util.Vector;

public class MyVector {
    public static void main(String args[]){
        Vector<Object> v= new Vector<>();
        v.add(123);
        v.add("Shivam");
        v.add(true);
        for(Object o: v){
            System.out.println(o+" "+ o.getClass());
        }
        Object o= v.clone();
        System.out.println(o+" "+ o.getClass());

        Iterator<Object> iterate = v.iterator();
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
    }
}

//vector are thread safe (synchronized)
//vector size double when run out of space

