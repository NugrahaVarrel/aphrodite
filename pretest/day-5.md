## _Java Spring Boot & Spring Security_

### ✳️ Bagian 1: Pilihan Ganda (Dasar)

1. Apa anotasi yang digunakan untuk mendefinisikan sebuah REST controller?

   - A. `@Service`
   - B. `@Component`
   - C. `@RestController` (BENAR)
   - D. `@Repository`

2. Di Spring, anotasi apa yang digunakan untuk menyuntikkan dependency ke dalam class?

   - A. `@Autowired` (BENAR)
   - B. `@Injectable`
   - C. `@Import`
   - D. `@Mapper`

3. Di lapisan arsitektur Spring, Service berfungsi untuk:

   - A. Menangani permintaan HTTP
   - B. Menyimpan data ke database langsung
   - C. Menyimpan log aplikasi
   - D. Menyimpan logika bisnis (BENAR)

4. Class model di Java Spring biasanya digunakan untuk:

   - A. Menyimpan konfigurasi Spring
   - B. Menyimpan logika controller
   - C. Menyimpan struktur data (seperti data user, produk, dll.) (BENAR)
   - D. Mengatur pemetaan URL

5. Jika kita ingin membuat method yang bisa diakses oleh endpoint `/hello`, anotasi apa yang digunakan?

   - A. `@RestEndpoint("/hello")`
   - B. `@Path("/hello")`
   - C. `@GetMapping("/hello")` (BENAR)
   - D. `@Route("/hello")`

---

### ✳️ Bagian 2: Benar / Salah

6. `@Service` digunakan untuk menandai class sebagai lapisan Controller. (SALAH)
7. Kita bisa membuat class model tanpa anotasi apapun jika hanya digunakan sebagai POJO. (BENAR)
8. `@Autowired` bisa digunakan di constructor maupun field. (BENAR)
9. Spring Boot membutuhkan file `application.yml` agar bisa berjalan. (SALAH)
10. `@GetMapping` hanya bisa digunakan di class dengan anotasi `@Service`. (SALAH)

---

### ✳️ Bagian 3: Isian Singkat

11. Anotasi apa yang digunakan agar method bisa menangani permintaan POST?
    @PostMapping
12. Apa nama file konfigurasi default di Spring Boot?
    application.properties
13. Apa yang dimaksud dengan Dependency Injection?
    Dependency Injection (DI) adalah desain pola di mana objek menerima dependensinya dari luar alih-alih membuatnya sendiri.Di Spring, ini memungkinkan pengelolaan dan penggabungan komponen secara otomatis, biasanya menggunakan anotasi seperti @Autowired.
14. Bagaimana cara mendeklarasikan class `UserService` agar dikenali Spring sebagai Service?
    Tambahkan anotasi @Service di atas class
15. Apa perbedaan `@RestController` dan `@Controller`?
    @RestController adalah gabungan dari @Controller dan @ResponseBody, digunakan untuk REST API yang mengembalikan data (biasanya JSON). Sedangkan @Controller digunakan untuk web MVC tradisional yang mengembalikan view (HTML).

---

### ✳️ Bagian 4: Perbaiki Kode / Output

16. Perbaiki kode berikut agar dapat dijalankan sebagai Controller:

```java
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```
yang benar
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

17. Perbaiki kesalahan pada model berikut:

```java
public class Product {
    private String name;
    private int price;
}
```
yang benar
```java
public class Product {
    private String name;
    private int price;

    // Constructor
    public Product() {}

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

```

18. Apa output dari method berikut?

```java
@GetMapping("/sum")
public int sum() {
    return 2 + 3;
}
```
Output = 5


19. Kode service berikut error. Apa yang salah?

```java
@Service
public class UserService {
    private UserRepository userRepository;
}
```
yang benar
```java
@Service
public class UserService {
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
```

20. Apa masalah pada potongan kode berikut?

```java
@RestController
public class BookController {

    @GetMapping
    public String listBooks() {
        return "books";
    }
}
```
yang benar
```java
@RestController
public class BookController {

    @GetMapping("/books")
    public String listBooks() {
        return "books";
    }
}
```

---

### Bagian 5: Spring Security

#### Pilihan Ganda

21. Apa anotasi yang digunakan untuk mengaktifkan Spring Security di aplikasi Spring Boot?

- A. `@EnableSecurity`
- B. `@SpringSecurity`
- C. `@EnableWebSecurity` (BENAR)
- D. `@ActivateSecurity`

22. Komponen mana yang bertugas mengatur izin akses berdasarkan role atau otorisasi di Spring Security?

- A. `SecurityConfig`
- B. `UserDetailsService`
- C. `AuthenticationManager`
- D. `HttpSecurity` (BENAR)

23. Untuk membuat otentikasi berbasis user login yang dikustomisasi, interface apa yang harus diimplementasi?

- A. `UserRepository`
- B. `UserSecurity`
- C. `UserDetailsService` (BENAR)
- D. `SecurityService`

#### Benar / Salah

24. Spring Security hanya bisa digunakan untuk REST API yang menggunakan JWT. (SALAH)
25. `@PreAuthorize("hasRole('ADMIN')")` digunakan untuk membatasi method agar hanya bisa diakses oleh pengguna dengan role ADMIN. (BENAR)
26. `BCryptPasswordEncoder` digunakan untuk mengenkripsi password agar tidak disimpan dalam bentuk plain text. (BENAR) 

#### Isian Singkat

27. Apa class konfigurasi yang umum dibuat untuk menyesuaikan aturan login, logout, dan authorization di Spring Security?
    SecurityConfig (biasanya merupakan class yang meng-extend WebSecurityConfigurerAdapter atau menggunakan anotasi @Configuration dan @EnableWebSecurity)
28. Apa anotasi yang digunakan agar method hanya bisa diakses jika pengguna memiliki hak tertentu?
    @PreAuthorize

#### Perbaiki Kode / Analisis

29. Perbaiki potongan konfigurasi ini:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    return http.build();
}
```
yang benar
```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin").hasRole("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(withDefaults()); // import static org.springframework.security.config.Customizer.withDefaults
    return http.build();
}
```

30. Apa yang salah dengan konfigurasi login berikut?

```java
http
  .authorizeHttpRequests()
  .anyRequest().permitAll()
  .and()
  .formLogin();
```
yang benar
```java
http
  .authorizeHttpRequests(auth -> auth
      .requestMatchers("/admin").hasRole("ADMIN")
      .anyRequest().authenticated()
  )
  .formLogin(withDefaults());
```

---
