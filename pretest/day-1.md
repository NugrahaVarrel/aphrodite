## 🧠 **Pre-Test Backend Engineer (Java, OOP, Spring Boot)**

---

### 🔸 **A. Pilihan Ganda (5 Soal)**

1. Apa yang menjadi tanggung jawab utama seorang Backend Engineer?

   - A. Mendesain UI
   - **B. Mengelola logika aplikasi dan komunikasi data dengan database**
   - C. Membuat animasi
   - D. Membuat desain grafis

2. Dalam OOP Java, konsep **encapsulation** berarti:

   - **A. Menyembunyikan detail implementasi dan menyediakan akses lewat method**
   - B. Mewarisi method dari class lain
   - C. Menambahkan method ke dalam class
   - D. Menghubungkan dua class yang berbeda

3. `@Autowired` pada Spring Boot digunakan untuk:

   - A. Menjalankan program utama
   - B. Menyimpan konfigurasi properties
   - **C. Meng-inject dependency otomatis ke dalam bean**
   - D. Mendaftarkan endpoint baru

4. Mengapa sebaiknya logika bisnis diletakkan di service layer?

   - **A. Agar controller lebih ringan dan fokus pada request/response**
   - B. Agar lebih cepat dalam compile
   - C. Karena controller tidak mendukung operasi logika
   - D. Agar dapat digunakan langsung tanpa testing

5. Di bawah ini adalah cara yang benar membuat endpoint di Spring Boot:

   - A. `@Route("/api")`
   - B. `@Mapping("/api")`
   - **C. `@GetMapping("/api")`**
   - D. `@WebRoute("/api")`

---

### 🔸 **B. True / False (5 Soal)**

6. Dalam arsitektur backend, service biasanya dipanggil langsung dari frontend. **false**
7. Constructor Injection adalah cara yang direkomendasikan untuk dependency injection di Spring. **true**
8. `@Service` digunakan untuk menandai sebuah class sebagai penyedia logika bisnis. **true**
9. Semua logika bisa ditaruh dalam controller agar tidak perlu membuat banyak file. **false**
10. Spring Boot memerlukan `main()` method untuk menjalankan aplikasinya. **true**

---

### 🔸 **C. Jawaban Singkat Penjelasan (10 Soal)**

11. Jelaskan apa itu Backend dan bagaimana perannya dalam aplikasi.
    bagian dari aplikasi yang bekerja di balik layar (server-side), dan mengelola logika bisnis, database, autentikasi, dan komunikasi antara server dan client.
12. Apa perbedaan antara class dan object dalam Java?
    **Class** (blueprint/cetakan) untuk membuat object, berisi atribut (variabel) dan method (fungsi) yang mendefinisikan perilaku dan sifat, dan tidak memakan memori sebelum dibuat object. 
    analogi: class = blueprint rumah. (belum ada rumah nyata, hanya desainnya saja)
    **Object** (Instance) dari sebuah class (hasil nyata dari blueprint). memiliki data konkret (nilai variabelnya bisa berbeda-beda, dibuat menggunakan keyword *new*).
    analogi: object = rumah nyata yang dibangun dari blueprint.
13. Sebutkan dan jelaskan 2 prinsip OOP lainnya selain encapsulation.
    **Inheritance** adalah hubungan antara dua objek atau lebih. di mana terdapat sebuah objek utama yang mewariskan attribute maupun method yang dimilikinya kepada objek lainnya, baik itu sebagian maupun keseluruhan. contohnya, seekor anak kucing berjenis mamalia, mewarisi sifat dan juga bentuk fisik orang tuanya, seperti bulu, mata, telinga, bahkan suaranya.
    **Abstract** adalah class-class yang memiliki informasi abstrak dan metode-metode dari sekumpulan data. Abstract Class tidak bisa di ubah dan berlaku juga sebagai kerangka dalam penciptaan berbagai subclass
    **Polymorphism** adalah konsep di mana suatu objek berbeda-beda dapat di akses melalui satu interface. sebuah objek polymorphism dapat beradaptasi dengan metode apapun yang di implementasikan pada objek tersebut, dan setiap class memiliki interpretasinya tersendiri terhadap interfacenya.
14. Mengapa kita menggunakan annotation `@RestController`?
    @RestController adalah annotation di Spring Boot yang digunakan pada sebuah class controller untuk menandai bahwa class tersebut akan menanganai HTTP request dan hasilnya langsung berupa JSON/XML, bukan halaman view HTML. Kita menggunakan @RestController agar controller bisa mengembalikan data JSON/XML langsung ke client, mempermudah pembuatan REST API, lebih ringkas, dan efisien.
15. Apa keuntungan menggunakan Spring Boot dibanding membuat server dari nol di Java?
    Spring Boot membuat pembuatan server lebih cepat, sederhana, dan produktid dibanding membangun server dari nol di java, karena banyak fitur sudah tersedia dan otomatis dikonfigurasi.
16. Jelaskan cara kerja dependency injection di Spring Boot secara sederhana.
    Depedency Injection adalah konsep di mana objek tidak membuat sendiri depedencynya, tetapi depedency tersebut diberikan (di-"inject") dari luar oleh framework (dalam hal ini Spring Boot).
    Spring membuat object (bean), menyimpannya di container, lalu secara otomatis menyuntikannya ke class lain yang membutuhkan melalui @Autowired atau constructor injection.
17. Apa manfaat memisahkan controller dan service dalam arsitektur aplikasi?
    Memisahkan Controller dan Service membuat aplikasi lebih bersih, terstruktur, mudah dimaintain, muda diuji, dan siap untuk skala besar.
18. Jelaskan apa yang terjadi jika Anda tidak menambahkan `@Service` pada class yang berisi logika.
    Kalau tidak menambahkan @Service, maka class logika tidak akan dikelola Spring, tidak bisa di-inject ke controller, dan akan menyebabkan error pada runctime.
19. Apa itu `@RequestParam` dan kapan digunakan?
    @RequestParam digunakan untuk mengambil nilai parameter dari query string di URL, biasanya pada request GET. Sangat berguna untuk fitur filter, pencarian, sorting, pagination, dll.
20. Bagaimana cara menghubungkan controller ke service menggunakan constructor?
    Menghubungkan controller ke service dengan injection membuat kode lebih rapi, aman, mudah dimaintain, dan sesuai best practice Spring Boot.

---

### 🔸 **D. Koreksi Kode (5 Soal)**

> Jelaskan kesalahan dan berikan versi yang benar.

21.

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello(); // error
    }
}
// yang benar
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello() {
        return "Hello, World!";
    }
}

// variable helloService tidak pernah di definisikan atau ditidak pernah di desklarasikan.
// Depedency Injection tidak dilakukan
```

22.

```java
public class Person {
    public String name;

    public void Person(String name) {
        this.name = name;
    }
}
```

// yang benar
public class Person {
    public String name;

    // Constructor (benar)
    public Person(String name) {
        this.name = name;
    }
}

// public void person (string name) bukan constructor, melainkan method biasa, karena ada keyword void yang aritnya sebuah method yang mengembalikan void, bukan


23.

```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody name) {
        return "Hello, " + name;
    }
}
```
<!-- yang benar -->
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody String name) {
        return "Hello, " + name;
    }
}
<!-- Kesalahan: parameter @RequestBody name tidak ada tipe data.

Solusi: tambahkan tipe data → bisa String atau class khusus (DTO). -->

24.

```java
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

// controller
@RestController
public class InfoController {
    @GetMapping("/info")
    public String get() {
        InfoService info = new InfoService();
        return info.getInfo();
    }
}
//yang benar
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

// controller
@RestController
public class InfoController {
    @GetMapping("/info")
    public String get() {
        InfoService info = new InfoService(); // ❌ bikin object manual
        return info.getInfo();
    }
}
// yang benar
```
InfoService sudah diberi anotasi @Service, artinya Spring seharusnya yang membuat dan mengelola object InfoService sebagai bean.

Tetapi di controller, Anda malah pakai new InfoService() → ini mengabaikan dependency injection.

Object yang dibuat dengan new tidak dikelola oleh Spring (tidak bisa dipakai fitur seperti proxy, AOP, transaction management).

Jadi, meskipun jalan, itu bukan cara best practice.



25.

```java
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(int a, int b) {
        return a + b;
    }
}
```
//yang benar
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}

Salah: tidak ada anotasi → Spring tidak tahu cara mapping parameter.

Benar: pakai @RequestParam supaya Spring bisa ambil nilai dari query string.
