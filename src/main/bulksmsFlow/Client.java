package main.bulksmsFlow;

public class Client {
    static int index= 100;
    final int feedId;
    String name;

    int feedVal;

    public Client(String name, int feedVal){
        feedId= index;
        index++;

        this.name= name;
        this.feedVal= feedVal;
    }
}
