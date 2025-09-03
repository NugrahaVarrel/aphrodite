import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        //input nama Anggota
        System.out.print("Masukkan nama anggota: ");
        String nama = input.nextLine();

        //input Jenis Anggota
        System.out.print("Masukkan jenis anggota (mahasiswa/dosen/umum): ");
        String jenis = input.nextLine().toLowerCase();

        //INput Hari Peminjaman
        System.out.print("Masukkan jumlah hari peminjaman: ");
        int hari = input.nextInt();

        int batasHari = 0;
        int dendaPerHari = 0;
        String status;
        int totalDenda = 0;

        if (jenis.equals("mahasiswa")) {
            batasHari = 14;
            dendaPerHari = 1000;
        } else if (jenis.equals("dosen")) {
            batasHari = 21;
            dendaPerHari = 2000;
        } else if (jenis.equals("umum")) {
            batasHari = 7;
            dendaPerHari = 500;
        } else {
            System.out.println("Jenis anggota tidak valid.");
            input.close();
            return;
        }


        if (hari <= batasHari) {
            status = "Tepat Waktu";
        } else if (hari - batasHari > 30) {
            status = "Suspensi";
            totalDenda = (hari - batasHari) * dendaPerHari;
        } else {
            status = "Terlambat";
            totalDenda = (hari - batasHari) * dendaPerHari;
        }


        System.out.println("=== Status Peminjaman ===");
        System.out.println("Nama Anggota     : "+nama);
        System.out.println("Jenis Anggota    : " +jenis);
        System.out.println("Hari Peminjaman  : " +hari);
        System.out.println("Status           : " +status);
        System.out.println("Total Denda      : Rp "+ totalDenda);

        input.close();

    }
}