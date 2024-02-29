package main.concurrentProgramming;
//using runnable interface
class PrintTable implements Runnable{
    Thread t;
    int num, ed;
    PrintTable(int num, int ed){
        this.num= num;
        this.ed= ed;
    }
    @Override
    public void run() {
        System.out.println("table of "+ num+" from 1 to "+ ed+ Thread.currentThread()+"---");
        for(int i=1; i<= ed; i++){
            System.out.println(num+"*"+i+"="+(num*i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    void start(){
        if(t== null){
            t= new Thread(this);
            t.start();
        }
//        t.start();
    }

}
public class MyThread2 {
    public static void main(String[] args){
        PrintTable t1= new PrintTable(2, 10);
        PrintTable t2= new PrintTable(3, 10);
        t1.start();
        t2.start();
    }
}
