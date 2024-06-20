package main.java8;

import javax.swing.*;
import java.util.function.Function;

public class FunctionUse {
    public static void main(String[] args) {
        Function<Integer, String> setGetValue= val-> val*10 +" is value 10 times "+val;

        System.out.println(setGetValue.apply(20));
    }
}
