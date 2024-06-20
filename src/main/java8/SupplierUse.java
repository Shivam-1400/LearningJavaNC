package main.java8;

import java.util.function.Supplier;

public class SupplierUse {
    public static void main(String[] args) {
        Supplier<String> getString= ()-> "This is supplier value";
        System.out.println(getString.get());
    }
}
