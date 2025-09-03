import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        //input nama pembeli
        System.out.print("Masukkan Nama Pembeli : ");
        String namaPembeli = input.nextLine();

        //input total belanja
        System.out.print("Masukkan Total Belanja : ");
        double totalBelanja = input.nextDouble();
        input.nextLine();

        //input status membership
        System.out.print("Masukkan status membership (regular/premium/non-member): ");
        String statusMembership = input.nextLine().toLowerCase();


        int diskonPersen = 0;
        if (statusMembership.equals("regular")){
            if (totalBelanja >= 500000){
                diskonPersen = 10;
            } else if (totalBelanja >= 100000) {
                diskonPersen = 5;
            }
        } else if (statusMembership.equals("premium")) {
            if (totalBelanja >= 500000){
                diskonPersen = 20;
            } else if (totalBelanja >= 300.000) {
                diskonPersen = 15;
            } else if (totalBelanja >= 100.000) {
                diskonPersen = 10;
            }
        } else if (statusMembership.equals("non-member")) {
            diskonPersen = 0;
        }else {
            System.out.println("Status membership tidak valid");
            input.close();
            return;
        }

        double nominalDiskon = ((double)diskonPersen / 100) * totalBelanja;
        double totalBayar = totalBelanja - nominalDiskon;

        System.out.println("=== Detail Pembeli ===");
        System.out.println("Nama Pembeli = " +namaPembeli);
        System.out.println("Total Belanja = "+totalBelanja);
        System.out.println("Persentase Diskon = "+diskonPersen + "%");
        System.out.println("Nominal Diskon = "+nominalDiskon);
        System.out.println("Total Bayar = "+totalBayar);

        input.close();
    }
}