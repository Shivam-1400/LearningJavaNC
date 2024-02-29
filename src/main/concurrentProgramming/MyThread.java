package main.concurrentProgramming;
//using Thread class

class PrintingTable extends Thread{
    int num, ed;
    PrintingTable(int num, int ed){
        this.num= num;
        this.ed= ed;
    }
    public void run() {
        System.out.println("Printing table of " + num + " from 1 to " + ed);

        for (int i = 1; i <= ed; i++) {
            System.out.println(num + "*" + i + "=" + (num * i));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class MyThread {
    public static void main(String [] ars){
        PrintingTable t1= new PrintingTable(2, 10);
        PrintingTable t2= new PrintingTable(3, 10);
        t1.start();
        t2.start();
    }
}
