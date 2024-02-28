package main.collection;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList {
    public static void main(String[] args) throws InterruptedException {
//        List<Integer> ls= new ArrayList<>();
//        ls.add(1);
//        ls.add(2);
//        System.out.println(ls);
//        List<Integer> ls2= new ArrayList<>();
//        ls.add(11);
//        ls2.addAll(0, ls);
//        System.out.println(ls2);
//        System.out.println(ls.hashCode());
//        System.out.println(ls2.hashCode());

//        ls.wait(10000);
//        System.out.println(ls);
//        System.out.println(ls2);

        List<Object> lsO= new ArrayList<>();
        lsO.add("Shivam");
        lsO.add(123);
        lsO.add(12.12f);
        lsO.add('1');
        lsO.add(true);
        lsO.add(1234.1234);

        for(Object o: lsO){
            System.out.println(o+ " "+ o.getClass());
        }

        System.out.println("Iterator--------");
        Iterator<Object> it= lsO.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}

