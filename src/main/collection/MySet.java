package main.collection;

import java.util.*;

public class MySet {
    public static void main(String[] aza){
        int [] ar= {15, 1, 12, 15, 11, 11, 11, 11, 11, 12, 12, 12, 13, 13 ,13,14, 15, 11, 12, 13, 12, 14,11, 15, 12};

        HashSet<Integer> hs= new HashSet<>();
        TreeSet<Integer> ts= new TreeSet<>();
        LinkedHashSet<Integer> ls= new LinkedHashSet<>();

        for(int a: ar){
            hs.add(a);
            ts.add(a);
            ls.add(a);
        }
        System.out.println(hs);
        System.out.println(ts);
        System.out.println(ls);

    }
}
//[1, 11, 12, 13, 14, 15]
//[1, 11, 12, 13, 14, 15]
//[15, 1, 12, 11, 13, 14]
