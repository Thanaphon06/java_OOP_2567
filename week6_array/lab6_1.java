package week6_array;

public class lab6_1 {
    public static void main(String[] args) {
        int X[] = new int[10]; 
        int Y[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; 
        final int Array_Size = 10; 
        int Z[] = new int[Array_Size]; 

        
        enterXData(X);
        enterZData(Z, X, Y);
        getData(X, Y, Z);
    }
    
    
    public static void getData(int []X, int []Y, int []Z){
        System.out.println("\tIndex \tArray X \tArray Y \tArray Z");
        for (int i = 0; i < X.length; i++) {
            System.out.print("\t" + i + " \t" + X[i] + " \t\t" + Y[i] + " \t\t" + Z[i]); 
            System.out.println(); 
        }
    }

    
    public static void enterXData(int [] X){
        for (int i = 0; i < X.length; i++) {
            X[i] = i; 
        }
    }

    public static void enterZData(int []Z, int []X, int []Y){
        for (int i = 0; i < Z.length; i++) {
            Z[i] = X[i] * 5 + Y[i]; }
    }
}
