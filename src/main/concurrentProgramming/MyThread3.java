package main.concurrentProgramming;

class PrintTable2 implements Runnable{
    Thread t;
    int num, ed;
    String name;
    boolean suspended= false;
    PrintTable2(int n, int ed, String name){
        this.num= n;
        this.ed= ed;
        this.name= name;
        System.out.println("Creating thread "+ name);
    }
    public void run(){
        System.out.println("Running Thread "+ name+"->"+ " from 1 to "+ ed+ Thread.currentThread()+"---");
        for(int i=1; i<= ed; i++){
            System.out.println(num+"*"+i+"="+(num*i));
            try {
                Thread.sleep(1000);
                while (suspended){
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Thread " +  t.getName() + " exiting.");
    }
    void start(){
        System.out.println("Starting thread "+ name);
        if(t== null){
            t= new Thread(this, name);
            t.start();
        }
    }
    void suspend(){
        suspended= true;
    }
    synchronized void resume(){
        suspended= false;
        notify();
    }
}

public class MyThread3 {
    public static void main(String []ar){
        PrintTable2 t2= new PrintTable2(2, 10, "Two");
        PrintTable2 t1= new PrintTable2(1, 10, "One");

        t1.start();
        t2.start();

        try {
            Thread.sleep(200);
            t1.suspend();
            System.out.println("thread "+ t1.name+" suspended");
            Thread.sleep(100);
            t1.resume();
            System.out.println("thread "+ t1.name+ " resumed");


            Thread.sleep(1000);
            t2.suspend();
            System.out.println("thread "+ t2.name+" suspended");
            Thread.sleep(100);
            t2.resume();
            System.out.println("thread "+ t2.name+ " resumed");


        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
