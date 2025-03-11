package week3;

public class test3_2 {
    String name;
    String surName;
    int age;
    
    public test3_2(){
        name = "Thanaphon";
        surName = "Sitthimat";
        age = 21;

    }

public static void main(String[]args){
    test3_2 me;
    long id;
    String value;

    id = 6706021410249L; //ทำไมต้องใส่ L ?
    me = new test3_2();

    value = "\" " + me.name + " " + me.surName + " \"";
    value += ", " + me.age + " Year Olds." ;
    System.out.println(id);
    System.out.println(value);
    System.out.println("============================================");


    id = 670000000000L;
    me.name = "Natcha";
    me.surName = "morlum";
    me.age = 27;
    value = "\" " + me.name + " " + me.surName + " \"";
    value += ", " + me.age + " Year Olds." ;
    System.out.println(id);
    System.out.println(value);
}

}
