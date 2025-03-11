package week3;

// File name : Lab3_4.java
public class Lab3_4 { 
    // main method begins execution of Java application 
    public static void main( String args[] ) 
    { 
    boolean result = false; 
    int number = 5; 
    String color = "red"; 
    
    System.out.println("When number = " + number + ", color = " + color );

   result = (number < 10) && (color == "red");
    System.out.print("result = (number < 10) && (color == \"red\") = "); 
    System.out.println(result); 
    
    result = (number < 10) & (color == "red"); 
    System.out.print("result = (number < 10) & (color == \"red\") = "); 
    System.out.println(result); 
    
    result = (number < 10) || (color == "red"); 
    System.out.print("result = (number < 10) || (color == \"red\") = "); 
    System.out.println(result); 
    
    result = (number < 10) | (color == "red"); 
    System.out.print("result = (number < 10) | (color == \"red\") = "); 
    System.out.println(result); 
    
    result = (number < 10) ^ (color == "red"); 
    System.out.print("result = (number < 10) ^ (color == \"red\") = "); 
    System.out.println(result); 
    
    result = !(number < 10) ; 
    System.out.println("result = !(number < 10) = " + result); 
    }
}