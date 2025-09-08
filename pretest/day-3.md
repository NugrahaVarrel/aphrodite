# Pre-Test: Spring Data JPA & Spring Web Development

## Bagian A – Pilihan Ganda (10 Soal)

1. Annotation apa yang digunakan untuk menandai sebuah class sebagai **Entity** di JPA?

```
 a) `@Table`
 b) `@Entity` (benar)
 c) `@Column`
 d) `@Repository`

```

2. Untuk membuat **primary key** otomatis bertambah di JPA, annotation yang digunakan adalah:

```
 a) `@GeneratedValue`
 b) `@Id`
 c) `@PrimaryKey` (benar)
 d) `@AutoIncrement`
```

3. Apa fungsi `JpaRepository` di Spring Data JPA?

```
   a) Menyediakan konfigurasi database
   b) Menyediakan implementasi CRUD secara otomatis (benar)
   c) Membuat koneksi HTTP
   d) Mengganti controller
```

4. Annotation apa yang digunakan untuk **REST Controller** di Spring Web?

```
   a) `@Controller`
   b) `@RestController` (benar)
   c) `@Service`
   d) `@Component`
```

5. Untuk membuat mapping endpoint `/api/users` dengan method GET, digunakan:

```
   a) `@GetMapping("/api/users")` (benar)
   b) `@PostMapping("/api/users")`
   c) `@RequestMapping("/api/users", method=POST)`
   d) `@RestMapping("/api/users")`
```

6. Annotation `@Column(nullable = false)` berarti:

   ```
   a) Kolom boleh kosong
   b) Kolom tidak boleh `null`(benar)
   c) Kolom tidak akan muncul di tabel
   d) Kolom adalah primary key
   ```

7. Apa kegunaan `@Autowired` dalam Spring?

   ```
   a) Mengatur database schema
   b) Melakukan dependency injection (benar)
   c) Menambahkan logging
   d) Membuat endpoint REST
   ```

8. Saat kita menggunakan `findById(id)` pada `JpaRepository`, return type biasanya adalah:

```
 a) `Entity`
 b) `Optional<Entity>` (benar)
 c) `List<Entity>`
 d) `Map<String, Entity>`
```

9. Annotation `@RequestBody` digunakan untuk:

```
 a) Mengambil query parameter dari URL
 b) Mengambil data JSON dari body request (benar)
 c) Mengambil header request
 d) Mengambil path variable
```

10. Spring Boot secara default menggunakan database apa untuk **in-memory testing**?

```
    a) MySQL
    b) PostgreSQL
    c) H2 (benar)
    d) MongoDB
```

---

## Bagian B – True / False (5 Soal)

1. `@Entity` hanya bisa digunakan sekali di satu aplikasi. (F)
2. `@Repository` digunakan untuk menandai interface JPA repository. (T)
3. `@RestController` sudah termasuk `@ResponseBody` secara default. (T)
4. `JpaRepository` harus selalu diimplementasikan secara manual. (F)
5. `@PathVariable` digunakan untuk mengambil nilai dari URL. (T)

---

## Bagian C – Isian Singkat (5 Soal)

1. Sebutkan perbedaan utama antara `@Controller` dan `@RestController` di Spring Web.
**
- @Controller: Digunakan untuk mengembalikan view (HTML/   JSP), Harus menggunakan @ResponseBody jika ingin mengembalikan data langsung. sedangkan 
- @RestController: Gabungan dari @Controller dan @ResponseBody, otomatis mengembalikan data (JSON/XML) tanpa perlu @ResponseBody.
**
2. Apa perbedaan `save()` dan `saveAll()` di JPA?
**
- save(): Menyimpan satu entitas ke database. (object )
- saveAll(): Menyimpan banyak entitas sekaligus dalam bentuk List atau Iterable. (array of object)
**
3. Bagaimana cara membuat relasi **OneToMany** antara `User` dan `Order` di JPA?
*
- Menentukan arah relasi
- Menandai relasi dengan anotasi JPA
- Menentukan pemilik relasi (owning side)
- Mengatur nama kolom foreign key
```java
@Entity
public class User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}

@Entity
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```
*

4. Apa fungsi dari `application.properties` di Spring Boot?
**
Digunakan untuk menyimpan konfigurasi aplikasi, seperti:

- koneksi database (spring.datasource.*)
- port server (server.port)
- konfigurasi JPA, logging, dan lainnya.
**
5. Sebutkan 2 keuntungan menggunakan Spring Data JPA dibanding JDBC manual.
**
- Mengurangi boilerplate code: Tidak perlu menulis SQL dan mapping manual.
- Query otomatis: Bisa membuat query hanya dengan nama method (findByNama, findByTanggalBetween, dll).
**

---

## Bagian D – Perbaikan Kode (5 Soal)

**Soal 1**

```java
@Entity
public class User {
   @Id
   private Long id;
   private String name;
}
```

Buat agar id auto increment.

```java
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITy)
   private Long id;
   private String name;
}
```

---

**Soal 2**

```java
@RestController
public class UserController {
   @GetMapping("/users")
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
}
```

Perbaiki error dependency injection `userRepository`.

```java
@RestController
public class UserController {

   @Autowired
   private UserRepository userRepository;

   @GetMapping("/users")
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
}
```

---

**Soal 3**

```java
public interface UserRepository {
   User findByName(String name);
}
```

Ubah agar bisa menggunakan Spring Data JPA.

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   // Query derivation otomatis
   User findByName(String name);
}
```


---

**Soal 4**

```java
@PostMapping("/users")
public User addUser(User user) {
   return userRepository.save(user);
}
```

Perbaiki agar data bisa diterima dari request body JSON.

```java
@PostMapping("/users")
   public User addUser(@RequestBody User user) {
       return userRepository.save(user);
   }
```

---

**Soal 5**

```java
@Entity
public class Order {
   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   private User user;
}
```

Tambahkan mapping di sisi `User` agar relasi bidirectional.

```java
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Order> orders;
}
```
---
