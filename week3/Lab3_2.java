package week3;

public class Lab3_2 { 
    String name; 
    String surName; 
    int age; 
    /** Creates a new instance of Lab3_2 */ 
    public Lab3_2() { 
    name = "Somchai"; 
    surName = "Cheingpongpan"; 
    age = 24; 
    } 
   
    public static void main(String[] args) { 
    Lab3_2 person; 
    long id; 
    String value; 
    
    id = 5066260000L; 
    person = new Lab3_2(); 
    value = person.name + " " + person.surName; 
    value += ", " + person.age + " year old."; 
    System.out.println("ID : " + id); 
    System.out.println("Data person : " + value); 
    System.out.println("==============================="); 
    person.name = "John"; 
    person.surName = "Smith"; 
    person.age = 29; 
    value = person.name + " " + person.surName; 
    value += ", " + person.age + " year old."; 
    System.out.println("ID : " + id); 
    System.out.println("New data person : " + value); 
    } 
    
   }