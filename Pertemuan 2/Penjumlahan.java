import java.util.Scanner;
public class Penjumlahan{
    public static void main(String[]args){
        int x,y,hasil;
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan nilai x = ");
        x = inp.nextInt();
        System.out.print("Masukkan nilai y = ");
        y = inp.nextInt();
        hasil = x+y;
        System.out.println("Hasil penjumlahan x + y = " + hasil);
    }
}