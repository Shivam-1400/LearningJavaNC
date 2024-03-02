package main.concurrentProgramming;

public class MyThreadLocal {
    public static void main(String args[]) {
        RunnableDemo obj = new RunnableDemo();

        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);
        Thread t4 = new Thread(obj);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}

class RunnableDemo implements Runnable {
    int count;
    ThreadLocal<Integer> threadCount = new ThreadLocal<Integer>();

    public void run() {
        count++;
        if(threadCount.get() != null) {
            threadCount.set(threadCount.get() + 1);
        }
        else {
            threadCount.set(0);
        }
        System.out.println("Counter: " + count);
        System.out.println("threadLocalCounter: " + threadCount.get());
    }
}

