package main.concurrentProgramming;

class Chats{
    boolean flag= false;

    synchronized void first(String msg){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(msg);
        notify();
        flag= !flag;
    }
    synchronized void second(String msg){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(msg);
        flag= !flag;
        notify();
    }
}
class P1 implements Runnable{
    String []msgs= {"Hi", "How are you?", "I am godd to"};
    Chats obj;
    Thread  t;
    String pname;
    P1(String pname, Chats ref){
        this.pname= pname;
        obj= ref;
//        start();
        new Thread(this).start();
    }

    public void run(){
        for(int i=0; i< msgs.length; i++){
            obj.first(pname+"--->>>"+msgs[i]);
        }
    }
//    void start(){
//        if(t== null){
//            t= new Thread(this);
//            t.start();
//        }
//    }
}
class P2 implements Runnable{
    String []msgs= {"Hi", "I'm doing good. HBU?", "Great"};
    Chats obj;
    Thread  t;
    String pname;
    P2(String pname, Chats ref){
        this.pname= pname;
        obj= ref;
//        new Thread(this).start();
        start();
    }

    public void run(){
        for(int i=0; i< msgs.length; i++){
            obj.second(pname+"--->>>"+msgs[i]);
        }
    }
    void start(){
        if(t== null){
            t= new Thread(this);
            t.start();
        }
    }
}
public class InterThreadComm {
    public static void main(String []args){
        Chats ch1= new Chats();
        P1 p1= new P1("Karan", ch1);
        P2 p2= new P2("Shivam", ch1);
    }
}
