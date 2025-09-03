//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        ### Soal Cerita – Operator di Java

//        1. **Cerita Kue Andi**
//        Andi punya 12 kue. Dia kasih 4 kue ke adiknya. Berapa kue yang tersisa? Operator apa yang bisa dipakai untuk menghitungnya?
        int kueAndi = 12;
        int kueAdikAndi = 4;
        int solusiPertama = kueAndi - kueAdikAndi;

        System.out.println("1. kue punya andi dari 12 lalu diberikan ke adiknya 4 sisanya = " +solusiPertama+ "solusi yang digunakan (-)" );
/*        2. **Cerita Ongkir Toko Online**
        Sebuah toko online pasang ongkir Rp 25.000. Saat promo, ongkir dipotong setengah. Berapa ongkir yang harus dibayar? Operator apa yang bisa dipakai untuk menghitungnya?
*/
        int ongkirTokoPermen = 25000;
        float promoTokoPermen = 0.5f;
        float solusiKedua = ongkirTokoPermen * promoTokoPermen;

        System.out.println("2. Ongkir dari toko online setelah promo menjadi " +solusiKedua+ " solusi yang digunakan (*) dengan diskonmya");
/*        3. **Cerita Permen Sinta**
        Sinta punya 20 permen dan mau dibagi rata ke 6 temannya. Berapa sisa permen yang tidak terbagi? Operator apa yang bisa dipakai untuk menghitung sisa pembagian?
*/
        int permenSinta = 20;
        int kebaikanSinta = 6;
        int solusiKetiga = permenSinta % kebaikanSinta;

        System.out.println("3. sisa permen sinta setelah dibagi " +solusiKetiga+ " solusi yang digunakan (%)");

/*        4. **Cerita Point Game**
        Seorang pemain game punya 80 point. Setiap naik level, point bertambah 15. Setelah naik level sekali, berapa total point pemain itu? Operator apa yang bisa dipakai untuk menambahkan point dengan cepat?
*/
        int pointPemainGame = 80;
        int jumlahNaikLevel = 1;
        int solusiKeiga = 15*pointPemainGame;

        System.out.println("4. hasilnya " +solusiKeiga+ "Operator yang digunakan (*)");
/*        5. **Cerita Tiket Bioskop**
          Budi mau nonton film. Syaratnya, hanya boleh masuk kalau umur ≥ 18. Jika umur Budi 16, apakah dia bisa masuk? Operator apa yang digunakan untuk membandingkan umur dengan syarat tersebut?
*/
        int umurBudi = 16;
        int batasUmur = 18;

        if (umurBudi >= batasUmur){
            System.out.println("Budi boleh masuk");
        }else{
            System.out.println(("Budi dilarang masuk"));
        }

    }
}



