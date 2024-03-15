package main.concurrentProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.concurrent.*;

class SumCallable implements Callable<String>{
    int n;
    SumCallable(int n){
        this.n= n;
    }
    public String call() throws Exception{
        int sum=0;
        Thread.sleep(1000);

        for(int i=1; i<= n; i++){
            sum+= i;
        }
        return Thread.currentThread().getName()+"----"+sum;
    }
}
public class Callable2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService pool= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> ls= new ArrayList<>();
        for(int i=0; i<=100; i++){
            Future<String> future= pool.submit(new SumCallable(i));
            ls.add(future);
//            System.out.println(Thread.currentThread().getName()+"----"+future.get()+" ");
        }

        for(Future f: ls){
            System.out.println(f.get(2, TimeUnit.SECONDS));
        }
        pool.shutdown();
    }
}
