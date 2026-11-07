Responsi Akhir Praktikum PBO – Sistem Manajemen Rumah Sakit

1. Identitas Mahasiswa

| Keterangan | Isi |
| Nama | Silmi Nadyya Nurbaeti |
| NIM | H1D025046 |
| Tema (digit terakhir NIM = 6) | Rumah Sakit |
| Mata Kuliah | Praktikum Pemrograman Berorientasi Objek |
| Institusi | Informatika, Fakultas Teknik, Universitas Jenderal Soedirman |

2. Deskripsi Singkat
Sistem simulasi rumah sakit: tenaga medis (Dokter dan Perawat) menangani
Pasien dengan logika yang bergantung pada stamina petugas dan tingkat keparahan pasien.

| File | Peran |
| `Pasien.java` | Entitas pasien (state, konstanta, atribut final) |
| `TenagaMedis.java` | Abstract superclass (memuat abstract method `tangani`) |
| `Dokter.java` | Subclass; implements 2 interface |
| `Perawat.java` | Subclass; implements 1 interface |
| `PemeriksaanPasien.java` | Interface 1 |
| `DapatOperasi.java` | Interface 2 |
| `Main.java` | Alur pengujian 10 persyaratan |

3. Pemetaan 10 Persyaratan
| No | Konsep | Lokasi |
| 1 | State & Behavior | `Pasien` (`tampilkanData()` void, `isKritis()` return), `TenagaMedis` (`istirahat()`, `hitungGajiTotal()`) |
| 2 | Immutability | `public static final`: `TenagaMedis.STAMINA_MAKS`, `Pasien.BATAS_KRITIS`, dll.; `private final`: `idPasien`, `idPegawai` |
| 3 | Enkapsulasi & Overloading | Semua atribut private + getter/setter, `this`, dua constructor di `Pasien`, `TenagaMedis`, `Dokter`, `Perawat` |
| 4 | Inheritance | `Dokter` & `Perawat` `extends TenagaMedis`; `Main` terpisah |
| 5 | Super Chaining | `super(...)` di constructor subclass; `super.tampilkanProfil()`, `super.hitungGajiTotal()` |
| 6 | Method Overriding | `@Override` pada `tampilkanProfil()`, `hitungGajiTotal()`, `tangani()`, dll. |
| 7 | Abstract Class | `abstract class TenagaMedis` + `abstract String tangani(Pasien)` |
| 8 | Logika State (if/else) | `tangani()` di `Dokter` & `Perawat` membaca/mengubah stamina, keparahan, dan status |
| 9 | Polimorfisme Interface | `PemeriksaanPasien p = new Dokter(...)` / `new Perawat(...)` |
| 10 | Multiple Interface | `Dokter implements PemeriksaanPasien, DapatOperasi` |

4. Cara Compile dan Run (Terminal)
Pastikan JDK terpasang (`javac -version`).

```bash
1. Masuk ke folder proyek
cd ResponsiPBO_RumahSakit
2. Compile semua file java
javac *.java
3. Jalankan program utama
java Main

5. Screenshot Luaran Program
Bagian 1:
![Output 1](screenshots/ss%20hasil1.png)

Bagian 2:
![Output 2](screenshots/ss%20hasil2.png)

Bagian 3:
![Output 3](screenshots/ss%20hasil3.png)
 
PENJELASAN SINGKAT OUTPUT:
| Bagian | Yang ditampilkan |
| [1] State dan Behavior | Data pasien Budi ditampilkan (method void), lalu dicek apakah kritis (method return value, hasilnya `true` karena keparahan 80). |
| [2] Immutability | Menampilkan konstanta `NAMA_RUMAH_SAKIT` dan `STAMINA_MAKS`, serta ID pasien yang bersifat final (tanpa setter). |
| [3] Enkapsulasi dan Overloading | Pasien dibuat dengan dua constructor berbeda. Nama dan umur Siti diubah lewat setter, lalu dibaca lewat getter. |
| [4] Inheritance | Dokter dan Perawat dimasukkan ke array bertipe `TenagaMedis`, dan keduanya terbukti turunan dari superclass tersebut. |
| [5] Super Chaining dan [6] Overriding | `tampilkanProfil()` pada subclass mencetak profil dasar dari superclass (`super.tampilkanProfil()`), lalu menambah info khusus (spesialisasi dokter atau shift perawat). |
| [7] Abstract Class dan [8] Logika State | `tangani()` menghasilkan perilaku berbeda tergantung kondisi: pasien kritis masuk rawat intensif, pasien sedang dapat rawat jalan, pasien ringan sembuh, dan petugas yang stamina-nya habis menolak bertugas. Stamina petugas serta keparahan dan status pasien berubah setelah penanganan. |
| [9] Polimorfisme Interface | Variabel bertipe `PemeriksaanPasien` memanggil `periksaPasien()`. Hasilnya berbeda: dokter mendiagnosis, perawat mengukur tanda vital. |
| [10] Multiple Interface | Dokter yang mengimplementasikan dua interface melakukan pemeriksaan sekaligus operasi. Keparahan pasien Dewa turun dari 90 menjadi 40, dan gaji dokter bertambah karena bonus operasi. |
