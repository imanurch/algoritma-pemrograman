import java.util.Scanner;

public class Siakad {
    static Scanner inp = new Scanner(System.in);
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];    
    static int jumlahData=0;

    public static void tambahData(){
        String nama, nim;
        System.out.println("Silahkan Tambah Data");
        System.out.print("Masukkan Nama : ");
        nama = inp.next();
        System.out.print("Masukkan NIM : ");
        nim = inp.next();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData ++;
    }

    public static void tampilData(){
        int i=0;
        System.out.println("Berikut Data Anda");        
        System.out.println("|             Nim |            Nama |");
        while(i<jumlahData){
            System.out.printf("| %15s | %15s |\n", mahasiswa[i].getNim(), mahasiswa[i].getNama());
            i++;
        }
    }

    public static void main(String[]args){
        int menu;
        do{
            System.out.println("\nMenu SIAKAD \n1. Tambah Data \n2. Lihat Data \n3. Keluar");
            System.out.print("Pilihan Menu : ");
            menu = inp.nextInt();

            switch(menu){
                case 1 : tambahData(); break;
                case 2 : tampilData(); break;
                case 3 : System.out.print("Terima Kasih");
            }
        } while (menu != 3);
    }
    
}
