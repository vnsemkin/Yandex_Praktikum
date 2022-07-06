package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	ArrayList<String> zoo = new ArrayList<>();
        zoo.add("Шиншилла");
        zoo.add("Крокодил");
        zoo.add("Лев");
        zoo.add("Медведь");
        zoo.add("Слон");

        System.out.println("Сегодня в зоопарке можно увидеть кормления " + zoo.size() + " животных:");
        System.out.println("Это будут: ");
    for (String animal : zoo) {
        System.out.println(animal);
    }
    System.out.println("Расписание кормлений:");
    System.out.println("В 9:00 - " + zoo.get(1));
    System.out.println("В 10:00 - " + zoo.get(4));
    System.out.println("В 11:00 - " + zoo.get(0));
    System.out.println("В 12:00 - " + zoo.get(2));
    System.out.println("В 13:00 - " + zoo.get(3));

    }
}
