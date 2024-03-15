package main.concurrentProgramming;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ThreadUsingCallable implements Callable<String> {
    int time;
    ThreadUsingCallable(int time){
        this.time= time;
    }

    public String call() throws Exception {
        int randomNum= new Random().nextInt(10);
        Thread.sleep((5-time)* 1000);
        return Thread.currentThread().getName()+" "+ randomNum;
    }
}
public class Callable1 {
    public static void main(String[] args) {
        FutureTask<Integer>[] tasks= new FutureTask[5];
        for(int i=0; i< 5; i++){
            Callable callable= new ThreadUsingCallable(i);
            tasks[i]= new FutureTask<>(callable);
            Thread t= new Thread(tasks[i]);
            t.start();

            try {
                System.out.println(tasks[i].get());
            } catch (InterruptedException| ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
//        ThreadUsingCallable th1= new ThreadUsingCallable();
//        ThreadUsingCallable th2= new ThreadUsingCallable();
//        try {
//            String res1= th1.call();
//            System.out.println(res1);
//            String res2= th2.call();
//            System.out.println(res2);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}

