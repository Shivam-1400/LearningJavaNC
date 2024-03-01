package main.concurrentProgramming;

class Resources{
    static Object ob1= new Object();
    static Object ob2= new Object();
}

class Thread1 implements Runnable{
    Thread t;
    Resources resource;
    String name;
    Thread1(String name, Resources o){
        this.name= name;
//        resource= o;
        new Thread(this, name).start();
    }
    public void run(){
        System.out.println("Starting thread "+ this+ " "+ name);
        synchronized(Resources.ob1){
            System.out.println(name+" is holding resource ob1");

//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(name+" is waiting for resource ob2");
            synchronized (Resources.ob2){
                System.out.println(name+" holding resources ob1 and ob2");
            }
        }
    }
}
class Thread2 implements Runnable{
    Thread t;
    Resources resource;
    String name;
    Thread2(String name, Resources o){
        this.name= name;
//        resource= o;
        new Thread(this, name).start();
    }
    public void run(){
        System.out.println("Starting thread "+ this+ " "+ name);
        synchronized(Resources.ob2){
            System.out.println(name+" is holding resource ob2");

//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(name+" is waiting for resource ob1");
            synchronized (Resources.ob1){
                System.out.println(name+" holding resources ob1 and ob2");
            }
        }
    }
}
public class Deadlock {
    public static void main(String []args){
        Resources obj= new Resources();
        Thread1 t1= new Thread1("Karan", obj);
        Thread2 t2= new Thread2("Shiva", obj);
        
    }

}

//synchronized block and deadlock
//to solve deadlock in this program, change order of resource in 2nd thread,
//synchronized ob1 and then synchronized ob2