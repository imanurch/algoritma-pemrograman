import java.util.Scanner;

public class pola {
    public static void main(String[]args){
        int n,i,j;
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan nilai n = ");
        n = inp.nextInt();

        for(i=1; i<=n; i++){
            for(j=1; j<=n; j++){
                if((j<=i || j>=(n+1)-i) && (j>=i || j<=(n+1)-i)){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
