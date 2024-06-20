package main.java8;

import java.util.function.Predicate;

public class PredicateUse{
    public static void main(String[] args){
        System.out.println("Hello World");
        Predicate<String> checkLength= temp-> temp.length()> 5;
        Predicate<Integer> checkValue= num-> num- 10>0;

        System.out.println("Hello World  length > 10: "+checkLength.test("Hello World"));
        System.out.println("hello  length > 10: "+checkLength.test("hello"));

        Predicate<Integer> solveFunction= num-> {
            boolean b = checkLength.test(String.valueOf(num)) && checkValue.test(num);
            return b;
        };

        System.out.println(solveFunction.test(1020304));



    }
}
