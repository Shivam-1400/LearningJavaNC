package main.java8;

import java.util.function.Consumer;

class Animal{
    String name;
    Animal(){
        this.name= "No Name";
    }
    Animal(String name){
        this.name= name;
    }
}
public class ConsumerUse {
    public static void main(String[] args){
        Consumer<Animal> setAnimalName= animal-> animal.name= "No Name Wala Animal" ;

        Animal dog= new Animal("DOG");
        Animal cat= new Animal("CAT");

        System.out.println(dog.name);
        System.out.println(cat.name);

        setAnimalName.accept(dog);
        setAnimalName.accept(cat);

        System.out.println(dog.name);
        System.out.println(cat.name);

    }
}
