import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        //input nama karyawan
        System.out.print("Masukkan Jenis Karyawan : ");
        String namaKaryawan = input.nextLine().toLowerCase();

        //input jam masuk (24 jam, contoh 815 = 08:15)
        System.out.print("Masukkan Jam Masuk : ");
        int jamMasuk = input.nextInt();

        //input gaji harian
        System.out.print("Masukkan Gaji Harian : ");
        double gajiHarian = input.nextDouble();

        String status;
        double potongan = 0;

        if (jamMasuk <= 800){
            status = "Tepat Waktu";
        } else if (jamMasuk <= 815) {
            status = "Terlambat Ringan";
            potongan = 0.01 * gajiHarian;
        } else if (jamMasuk <= 830) {
            status = "Terlambat Sedang";
            potongan = 0.03 * gajiHarian;
        }else {
            status = "Terlambar Berat";
            potongan = 0.05 * gajiHarian;
        }

        double gajiTotal = gajiHarian - potongan;

        System.out.println("=== Status Kehadiran ===");
        System.out.println("Nama Karyawan : " +namaKaryawan);
        System.out.println("Jam Masuk : " +jamMasuk);
        System.out.println("Status Kehadiran : "+status);
        System.out.println("Potongan Gaji : "+potongan);
        System.out.println("Gaji Diterima : "+gajiTotal);

        input.close();
    }
}