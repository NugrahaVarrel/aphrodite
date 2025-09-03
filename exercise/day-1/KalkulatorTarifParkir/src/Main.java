import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //input jenis kendaraan
        System.out.print("Masukkan jenis kendaraan : ");
        String jenisKendaraan = input.nextLine();

        //input lama parkir (jam)
        System.out.print("Berapa lama parkir : ");
        int lamaParkir = input.nextInt();

        int tarif = 0;
        if (jenisKendaraan.equals("motor")){
            if (lamaParkir <= 2){
                tarif = 2000;
            }else {
                tarif = 2000 + (lamaParkir - 2) * 1000;
            }if (tarif > 10000){
                tarif = 10000;
            }
        }else if (jenisKendaraan.equals("mobil")) {
            if (lamaParkir<=2){
                tarif = 50000;
            }else {
                tarif = 50000 + (lamaParkir - 2) * 2000;
            }if (tarif > 25000){
                tarif = 25000;
            }
        }else{
            System.out.println("Jenis Kendaraan tidak valid");
            input.close();
            return;
        }
        // buat output sout
        System.out.println("=== Tarif Parkir ===");
        System.out.println("Jenis Kendaraan = " + jenisKendaraan);
        System.out.println("Lama Parkir = " + lamaParkir);
        System.out.println("Total Biaya = Rp. " + tarif);
    }
}