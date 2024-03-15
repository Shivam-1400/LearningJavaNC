package main.syncCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SyncArrayList {
    public static void main(String[] args) throws InterruptedException {
        Collection<Integer> syncArray = Collections.synchronizedCollection(new ArrayList<>());

        Runnable listOperation= ()->{
            syncArray.add(1);
            syncArray.add(2);
            syncArray.add(3);
            syncArray.add(4);
            syncArray.add(5);
            System.out.println(syncArray.size());
        };

        Thread t1= new Thread(listOperation);
        Thread t2= new Thread(listOperation);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(syncArray.size());


        ArrayList<Integer> ar= new ArrayList<>();
        Runnable add=()->{
            ar.add(1);
            ar.add(2);
            ar.add(3);
            ar.add(4);
            ar.add(5);
            System.out.println(ar.size());
        };

        Thread a1= new Thread(add);
        Thread a2= new Thread(add);

        a1.start();;
        a2.start();

        a1.join();
        a2.join();

        System.out.println(ar.size());


    }
}
