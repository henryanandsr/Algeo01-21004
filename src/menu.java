import java.util.*;  
public class menu {
    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("\nMENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi linier berganda");
        System.out.println("6. Keluar");
        System.out.println("Pilih menu : ");
        input = sc.nextInt();
        return 0;
    }
    public static int spl(){
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("\n1. Metode eliminasi Gauss");  
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");
        System.out.println("Pilih menu : ");
        input = sc.nextInt();
        return 0;
    }
}
