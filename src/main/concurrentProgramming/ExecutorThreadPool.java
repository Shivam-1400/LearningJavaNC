package main.concurrentProgramming;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{
    int num;
    String name;
    Task(String name, int num){
        this.name = name;
        this.num=  num;
    }
    public void run(){
        for(int i=0; i<=5; i++){

//            System.out.println(name+" "+ num+ " "+ i+" ");
            if(i==0){
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                System.out.println(name+" created on "+ft.format(d));
            }
            else if(i==5){
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                System.out.println(name+" exited on "+ft.format(d));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+" completed----"+ Thread.currentThread());
    }
}
public class ExecutorThreadPool {
    public static void main(String []args){
        ExecutorService pool= Executors.newFixedThreadPool(2);

        Task t1= new Task("T1", 1);
        Task t2= new Task("T2", 2);
        Task t3= new Task("T3", 3);
        Task t4= new Task("T4", 4);
        Task t5= new Task("T5", 5);

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();


    }

}
