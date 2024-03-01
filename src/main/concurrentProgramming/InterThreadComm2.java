package main.concurrentProgramming;

import java.util.Arrays;

public class InterThreadComm2 {
    public static void main(String []args){

    }
}
class Work{
    boolean f1= false, f2= false,f3= false;
    synchronized void pr1(String msg){
        if(f1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("P1------>"+msg);

        f1= false;
        f2= true;
        f3= false;
        notifyAll();
    }
    synchronized void pr2(String msg){
        if(f2){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("P1------>"+msg);

        f1= false;
        f2= false;
        f3= true;
        notifyAll();
    }
    synchronized void pr3(String msg){
        if(f1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("P1------>"+msg);

        f1= true;
        f2= false;
        f3= false;
        notifyAll();
    }
}

