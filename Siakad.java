import java.util.Scanner;

public class Siakad {
    static Scanner inp = new Scanner(System.in);
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];    
    static int jumlahData=0;

    // FITUR MENAMBAHKAN DATA
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

    // FITUR MENAMPILKAN DATA
    public static void tampilData(){
        int i=0;
        System.out.println("Berikut Data Anda");        
        System.out.println("|             Nim |            Nama |");
        while(i<jumlahData){
            System.out.printf("| %15s | %15s |\n", mahasiswa[i].getNim(), mahasiswa[i].getNama());
            i++;
        }
    }

    // FITUR MENGURUTKAN DATA
    public static void urutkanData() {
        System.out.println("\nPilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. BUBBLE SORT");
        System.out.println("4. QUICK SORT");
        System.out.println("5. SHELL SORT");
        System.out.println("6. Kembali ke menu sebelumnya");
        System.out.print("Pilih algoritma = ");
        int algo = inp.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                bubbleSort();
                break;
            }
            case 4: {
                quickSort(mahasiswa, 0, jumlahData-1);
                break;
            }
            case 5: {
                shellSort();
                break;
            }
        }
        if(algo !=6){
            tampilData();
        }
    }

    // EXCHANGE SORT
    public static void exchangeSort() {
        for (int x = 0; x<jumlahData; x++) {
            for (int y = x+1; y<jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim())>=1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    // SELECTION SORT
    public static void selectionSort(){
        for(int i=0;i<jumlahData-1;i++){
            int pos=i;
            for(int j=i+1;j<jumlahData;j++){
                if(mahasiswa[pos].getNim().compareTo(mahasiswa[j].getNim())>=1){
                    pos = j;
                }
            }
            if(pos !=i){
                Mahasiswa temp = mahasiswa[i];
                mahasiswa[i] = mahasiswa[pos];
                mahasiswa[pos] = temp;  
            }
        }

    }

    // BUBBLE SORT
    public static void bubbleSort(){
        for(int i=0; i<jumlahData; i++){
            for(int j=1; j<jumlahData-i; j++){
                if(mahasiswa[j-1].getNim().compareTo(mahasiswa[j].getNim())>=1){
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j-1];
                    mahasiswa[j-1] = temp;
                }
            }
        }
    }
    
    // QUICK SORT
    public static void quickSort(Mahasiswa[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    public static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for(j=low+1; j<=high; j++){
            if(arr[j].getNim().compareTo(arr[low].getNim())<=1){
                swap(arr, ++p, j);
            }
        }
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    // SHELLSORT
    public static void shellSort(){
        for (int gap = jumlahData/2; gap > 0; gap /= 2){
            for (int i = gap; i < jumlahData; i += 1){
                Mahasiswa temp = mahasiswa[i];
                int j;
                for (j = i; j >= gap && mahasiswa[j - gap].getNim().compareTo(mahasiswa[i].getNim())>=1; j -= gap){
                    mahasiswa[j] = mahasiswa[j - gap];
                }
                mahasiswa[j] = temp;
            }
        }
    }

    // FITUR MENCARI DATA
    public static void cariData() {
        System.out.println("\nPilih tipe pencarian");
        System.out.println("1. LINEAR SEARCH");
        System.out.println("2. BINARY SEARCH");
        System.out.println("3. Kembali ke menu sebelumnya");
        System.out.print("Pilih algoritma = ");
        int algo = inp.nextInt();
        if (algo == 1 || algo == 2){
            System.out.print("Tuliskan NIM/nama yang ingin dicari = ");
            String search = inp.next();
            int id = -1;
            switch (algo) {
                case 1: {
                    id = linearSearch(search);
                    break;
                }
                case 2: {
                    id = binarySearch(0, jumlahData-1, search);
                    break;
                }
            }
            if(id == -1){
                System.out.println("Data tidak ditemukan");
            } 
            else{
                System.out.println("|             Nim |            Nama |");
                System.out.printf("| %15s | %15s |\n", mahasiswa[id].getNim(), mahasiswa[id].getNama());
            } 
        }
    }

    // LINEAR SEARCH
    public static int linearSearch(String search){
        for (int i=0; i<jumlahData; i++){
            if((mahasiswa[i].getNim().compareTo(search)==0) || (mahasiswa[i].getNama().compareTo(search)==0)){
                return i;
            }
        }
        return -1;
    }

    // BINARY SEARCH
    public static int binarySearch(int l, int r, String search){
        selectionSort();
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (mahasiswa[mid].getNim().compareTo(search)==0)
                return mid;

            if (mahasiswa[mid].getNim().compareTo(search)>=1)
                return binarySearch(l, mid - 1, search);

            return binarySearch(mid + 1, r, search);
        }
        return -1;
    }

    // EDIT DATA
    public static void editData(){
        System.out.print("Tuliskan NIM data yang ingin diubah = ");
        String search = inp.next();
        int index = linearSearch(search);

        if(index == -1){
            System.out.println("Data tidak ditemukan");
        }
        else {
            System.out.printf("| %15s | %15s |\n", mahasiswa[index].getNim(), mahasiswa[index].getNama());
            System.out.print("Apakah anda ingin mengubah data di atas? (y/n) = ");
            char konfirm = inp.next().charAt(0);
            if(konfirm == 'y' || konfirm == 'Y'){
                System.out.print("Ubah Nama : ");
                String nama = inp.next();
                System.out.print("Ubah NIM : ");
                String nim = inp.next();
                // mahasiswa[jumlahData] = new Mahasiswa();
                mahasiswa[index].setNim(nim);
                mahasiswa[index].setNama(nama);
            }
            System.out.println("Data berhasil diubah");
            System.out.printf("| %15s | %15s |\n", mahasiswa[index].getNim(), mahasiswa[index].getNama());
        }
    }

    // HAPUS DATA
    public static void hapusData(){
        
    }

    // MAIN MENU
    public static void main(String[]args){
        int menu;
        do{
            System.out.println("\nMenu SIAKAD\n1. Tambah Data\n2. Lihat Data\n3. Urutkan Data\n4. Cari Data \n5. Edit Data \n6. Hapus Data \n7. Keluar");
            System.out.print("Pilihan Menu : ");
            menu = inp.nextInt();

            switch(menu){
                case 1 : tambahData(); break;
                case 2 : tampilData(); break;
                case 3 : urutkanData(); break;
                case 4 : cariData(); break;
                case 5 : editData(); break;
                // case 6 : hapusData(); break;
                case 7 : System.out.print("Terima Kasih");
            }
        } while (menu != 7);
    }
    
}


