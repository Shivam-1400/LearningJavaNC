package main.collection;

import java.util.Iterator;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args){
        Stack<Object> st= new Stack<>();
        st.add(123);
        st.add(234);
        st.add("Shivam");
        st.add(false);
        st.add(12.12f);
        st.add(12.12);

        System.out.println(st);
        System.out.println("==============");
        printStack(st);

        System.out.println("==============");
        Iterator<Object> it= st.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }
    static void printStack(Stack<Object> st){
        if(st.size()== 0){
            return;
        }
        Object o= st.pop();
        System.out.println(o+" "+ o.getClass());
        printStack(st);
        st.add(o);



    }
}
//iterator
//add
//pop
//reverse print using recursion

