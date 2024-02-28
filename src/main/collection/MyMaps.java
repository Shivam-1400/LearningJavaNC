package main.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MyMaps {
    public static void main(String []args){
        int [] ar= {15, 1, 11, 11, 11, 11, 11, 12, 12, 12, 13, 13 ,13,14, 15, 11, 12, 13, 12, 14,11, 15, 12};

        HashMap<Integer, Integer> hm= new HashMap<>();
        TreeMap<Integer, Integer> tm= new TreeMap<>();
        LinkedHashMap<Integer, Integer> lm= new LinkedHashMap<>();

        for(int a: ar){
            hm.put(a, hm.getOrDefault(a, 0)+1);
            tm.put(a, hm.getOrDefault(a, 0)+1);
            lm.put(a, hm.getOrDefault(a, 0)+1);
        }

        System.out.println(hm);
        System.out.println(tm);
        System.out.println(lm);

        Hashtable<Integer, Integer> ht= new Hashtable<>();
        for(int a: ar){
            ht.put(a, ht.getOrDefault(a, 0)+1);
        }
        System.out.println(ht);



    }
}

//hm- {1=1, 11=7, 12=6, 13=4, 14=2, 15=3}
//tm- {1=2, 11=8, 12=7, 13=5, 14=3, 15=4}
//lm- {15=4, 1=2, 11=8, 12=7, 13=5, 14=3}