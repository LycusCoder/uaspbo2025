### 🚀 Harap berikan repo :star:

# Sistem Pengelolaan Data Universitas

## Ujian Akhir Semester
### Pemrograman Berorientasi Objek

Disusun untuk memenuhi UAS mata kuliah Pemrograman Berorientasi Objek  
**Dosen Pengampu**: Rifki Dwi K, S.KOM

### Anggota Kelompok
- Bara Abiyyi Muslimin: 23215051
- Siti Novia Desi Nurkhikmah: 23215006
- Siti Furkotun Najiyah: 23215056
- Feldi Sanjaya: 23215055
- M. Yasir Ilham Nabil: 23215040
- M. Fahren Andrean Rangkuti: 23215030
- Muhamad Affif: 24225046

## Deskripsi Proyek
Proyek ini adalah sistem pengelolaan data universitas berbasis Java yang dirancang untuk mengelola data akademik. Sistem ini mencakup tiga peran utama:

1. **BAUK (Bagian Administrasi Umum dan Keuangan)**:
   - Mengatur data mahasiswa dan dosen.

2. **Dosen**:
   - Mengatur nilai mahasiswa.

3. **Mahasiswa**:
   - Melihat nilai dan rata-rata mereka.

Data disimpan dalam file teks `universitas.txt` untuk memastikan data tetap tersimpan meskipun program ditutup. Proyek ini menerapkan prinsip Object-Oriented Programming (OOP).

## Contoh Kode
Berikut adalah contoh fungsi utama yang menjalankan aplikasi:

```java
public static void main(String[] args) {
    loadData();
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("=== SELAMAT DATANG DI APLIKASI UNIVERSITAS ===");
        System.out.println("Pilih peran:");
        System.out.println("1. Bauk");
        System.out.println("2. Dosen");
        System.out.println("3. Mahasiswa");
        System.out.println("4. Keluar");
        System.out.print("Masukkan pilihan: ");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: menuBauk(scanner); break;
            case 2: menuDosen(scanner); break;
            case 3: menuMahasiswa(scanner); break;
            case 4: saveData(); return;
            default: System.out.println("Pilihan tidak valid.");
        }
    }
}

## Lisensi
Proyek ini dilisensikan di bawah [MIT License](https://opensource.org/licenses/MIT). Anda bebas untuk menggunakan, menyalin, dan memodifikasi kode ini sesuai kebutuhan Anda, dengan menyertakan salinan lisensi ini dalam distribusi Anda.

Terima kasih telah melihat proyek ini!
