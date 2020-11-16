package myproject;


import myproject.model.Dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dc = new Dictionary("Macmillan","Lazaryan",7000,"English","Aremnian");
        System.out.println(dc);
    }
}
