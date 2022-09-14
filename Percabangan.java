import java.util.Scanner;

public class Percabangan {
    public static void main(String[]args){
        String nama, ket;
        int nilai;

        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan nama = ");
        nama = inp.next();
        System.out.print("Masukkan nilai = ");
        nilai = inp.nextInt();

        if(nilai >= 60){
            ket = " Lulus";
        }
        else{
            ket = " Tidak Lulus";
        }

        System.out.println(nama + ket);
    }
}
