import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //inputan nama siswa
        System.out.println("Masukkan nama siswa : ");
        String nama = input.nextLine();

        //inputan nilai siswa
        System.out.println("Masukkan nilai siswa : ");
        int nilai = input.nextInt();

        //menentukan grade
        char grade = 'X';
        if(nilai >= 90 && nilai<= 100){
            grade = 'A';
        } else if (nilai >= 80 && nilai <= 89) {
            grade = 'B';
        } else if (nilai >= 70 && nilai<= 79) {
            grade = 'C';
        } else if (nilai >= 60 && nilai<= 69) {
            grade = 'D';
        } else if (nilai < 60) {
            grade = 'E';
        }

        System.out.println("=== Hasil Penilaian ===");
        System.out.println("Nama Siswa : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);

        input.close();
    }
}