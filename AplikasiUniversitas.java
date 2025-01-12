import java.io.*;
import java.util.*;

public class AplikasiUniversitas {
    private static final String FILE_NAME = "universitas.txt";
    private static List<Dosen> dosenList = new ArrayList<>();
    private static List<Mahasiswa> mahasiswaList = new ArrayList<>();
    public static final String[] subjects = {"PBO", "Aljabar", "Indonesia", "Analisis", "Web1", "Arsitektur", "Web2"};

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
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        menuBauk(scanner);
                        break;
                    case 2:
                        menuDosen(scanner);
                        break;
                    case 3:
                        menuMahasiswa(scanner);
                        break;
                    case 4:
                        saveData();
                        System.out.println("Terima kasih telah menggunakan aplikasi.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static void menuBauk(Scanner scanner) {
        while (true) {
            System.out.println("\n=== PANEL FUNGSI BAUK ===");
            System.out.println("1. Tambah Dosen");
            System.out.println("2. Hapus Dosen");
            System.out.println("3. Tambah Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Kembali");
            System.out.print("Masukkan pilihan: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tambahDosen(scanner);
                    break;
                case 2:
                    hapusDosen(scanner);
                    break;
                case 3:
                    tambahMahasiswa(scanner);
                    break;
                case 4:
                    hapusMahasiswa(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahDosen(Scanner scanner) {
        System.out.print("Masukkan nama Dosen: ");
        String nama = scanner.nextLine();
        
        // Pilihan prodi dari daftar pelajaran yang ada
        System.out.println("Pilih prodi dari daftar pelajaran:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }
        
        int prodiChoice;
        while (true) {
            System.out.print("Masukkan pilihan: ");
            prodiChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (prodiChoice >= 1 && prodiChoice <= subjects.length) {
                break;
            }
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
        
        String prodi = subjects[prodiChoice - 1];
        dosenList.add(new Dosen(nama, prodi));
        System.out.println("Dosen berhasil ditambahkan.");
    }

    private static void hapusDosen(Scanner scanner) {
        System.out.println("Pilih Dosen yang ingin dihapus:");
        for (int i = 0; i < dosenList.size(); i++) {
            System.out.println((i + 1) + ". " + dosenList.get(i).getName());
        }
        System.out.print("Masukkan nomor Dosen yang ingin dihapus: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > dosenList.size()) {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        dosenList.remove(choice - 1);
        System.out.println("Dosen berhasil dihapus.");
    }

    private static void tambahMahasiswa(Scanner scanner) {
        System.out.print("Masukkan nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        mahasiswaList.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void hapusMahasiswa(Scanner scanner) {
        System.out.println("Pilih Mahasiswa yang ingin dihapus:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i).getName());
        }
        System.out.print("Masukkan nomor Mahasiswa yang ingin dihapus: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > mahasiswaList.size()) {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        mahasiswaList.remove(choice - 1);
        System.out.println("Mahasiswa berhasil dihapus.");
    }

    private static void menuDosen(Scanner scanner) {
        while (true) {
            System.out.println("\n=== PANEL FUNGSI DOSEN ===");
            if (dosenList.isEmpty()) {
                System.out.println("Tidak ada Dosen yang tersedia.");
                System.out.println("Tekan enter untuk kembali...");
                scanner.nextLine();
                return;
            }
            
            System.out.println("Pilih Dosen:");
            for (int i = 0; i < dosenList.size(); i++) {
                System.out.println((i + 1) + ". " + dosenList.get(i).getName());
            }
            System.out.println((dosenList.size() + 1) + ". Kembali");
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            if (choice == dosenList.size() + 1) {
                return;
            } else if (choice < 1 || choice > dosenList.size()) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }
    
            Dosen dosenTerpilih = dosenList.get(choice - 1);
            menuFungsiDosen(scanner, dosenTerpilih);
        }
    }
    

    private static void menuFungsiDosen(Scanner scanner, Dosen dosen) {
        while (true) {
            System.out.println("\n=== PANEL FUNGSI DOSEN ===");
            System.out.println("1. Tambah Nilai Mahasiswa");
            System.out.println("2. Edit Nilai Mahasiswa");
            System.out.println("3. Kembali");
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tambahNilaiMahasiswa(scanner, dosen);
                    break;
                case 2:
                    editNilaiMahasiswa(scanner, dosen);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahNilaiMahasiswa(Scanner scanner, Dosen dosen) {
        System.out.println("Pilih Mahasiswa:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i).getName());
        }
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > mahasiswaList.size()) {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        Mahasiswa mahasiswa = mahasiswaList.get(choice - 1);
        System.out.println("Pilih Pelajaran:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }
        System.out.print("Masukkan pilihan: ");
        int subjectChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (subjectChoice < 1 || subjectChoice > subjects.length) {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        String subject = subjects[subjectChoice - 1];
        System.out.print("Masukkan nilai untuk " + subject + ": ");
        double nilai = scanner.nextDouble();
        
        if (nilai < 0) {
            System.out.println("Nilai tidak boleh negatif.");
            return;
        }

        mahasiswa.addNilai(subject, nilai);
        System.out.println("Nilai berhasil ditambahkan.");
    }

    private static void editNilaiMahasiswa(Scanner scanner, Dosen dosen) {
        System.out.println("Pilih Mahasiswa:");
        for (int i = 0; i < mahasiswaList.size(); i++) {
            System.out.println((i + 1) + ". " + mahasiswaList.get(i).getName());
        }
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > mahasiswaList.size()) {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        Mahasiswa mahasiswa = mahasiswaList.get(choice - 1);
        System.out.println("Pilih Pelajaran:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }
        System.out.print("Masukkan pilihan: ");
        int subjectChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (subjectChoice < 1 || subjectChoice > subjects.length) {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        String subject = subjects[subjectChoice - 1];
        System.out.print("Masukkan nilai baru untuk " + subject + ": ");
        double nilai = scanner.nextDouble();
        
        if (nilai < 0) {
            System.out.println("Nilai tidak boleh negatif.");
            return;
        }

        mahasiswa.editNilai(subject, nilai);
        System.out.println("Nilai berhasil diedit.");
    }

    private static void menuMahasiswa(Scanner scanner) {
        while (true) {
            System.out.println("\n=== PANEL FUNGSI MAHASISWA ===");
            if (mahasiswaList.isEmpty()) {
                System.out.println("Tidak ada Mahasiswa yang tersedia.");
                System.out.println("Tekan enter untuk kembali...");
                scanner.nextLine();
                return;
            }
            
            System.out.println("Pilih Mahasiswa:");
            for (int i = 0; i < mahasiswaList.size(); i++) {
                System.out.println((i + 1) + ". " + mahasiswaList.get(i).getName());
            }
            System.out.println((mahasiswaList.size() + 1) + ". Kembali");
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            if (choice == mahasiswaList.size() + 1) {
                return;
            } else if (choice < 1 || choice > mahasiswaList.size()) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }
    
            Mahasiswa mahasiswaTerpilih = mahasiswaList.get(choice - 1);
            lihatNilaiMahasiswa(mahasiswaTerpilih, scanner);
        }
    }
    
    private static void lihatNilaiMahasiswa(Mahasiswa mahasiswa, Scanner scanner) {
        System.out.println("\n=== NILAI MAHASISWA ===");
        for (String subject : subjects) {
            System.out.println(subject + ": " + mahasiswa.getNilai(subject));
        }
        double total = 0;
        for (String subject : subjects) {
            double nilai = mahasiswa.getNilai(subject);
            total += nilai;
        }
        double average = total / subjects.length;
        System.out.println("Total Nilai: " + total);
        System.out.println("Rata-rata Nilai: " + average);
        System.out.print("Tekan enter untuk kembali...");
        scanner.nextLine();
    }

    private static void loadData() {
        File dataFile = new File(FILE_NAME);
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile(); // Membuat file jika tidak ada
            } catch (IOException e) {
                System.out.println("Error creating data file: " + e.getMessage());
                return; // Keluar dari metode jika gagal membuat file
            }
        }
    
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) { // Format: "Dosen,NamaProdi"
                    dosenList.add(new Dosen(parts[0], parts[1]));
                } else if (parts.length >= 2) { // Format: "Mahasiswa,NIM,Nilai1,Nilai2,..."
                    Mahasiswa mahasiswa = new Mahasiswa(parts[0], parts[1]);
                    for (int i = 2; i < parts.length; i++) {
                        mahasiswa.addNilai(subjects[i - 2], Double.parseDouble(parts[i]));
                    }
                    mahasiswaList.add(mahasiswa);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Dosen dosen : dosenList) {
                bw.write(dosen.getName() + "," + dosen.getProdi());
                bw.newLine();
            }
            for (Mahasiswa mahasiswa : mahasiswaList) {
                bw.write(mahasiswa.getName() + "," + mahasiswa.getNim());
                for (String subject : AplikasiUniversitas.subjects) {
                    bw.write("," + mahasiswa.getNilai(subject));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}

// Kelas dasar untuk Dosen dan Mahasiswa
abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getInfo();
}

// Subclass untuk Dosen
class Dosen extends Person {
    private String prodi;

    public Dosen(String name, String prodi) {
        super(name);
        this.prodi = prodi;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    @Override
    public String getInfo() {
        return "Dosen: " + name + ", Prodi: " + prodi;
    }
}

// Subclass untuk Mahasiswa
class Mahasiswa extends Person {
    private String nim;
    private Map<String, Double> nilaiMap = new HashMap<>();

    public Mahasiswa(String name, String nim) {
        super(name);
        this.nim = nim;
        for (String subject : AplikasiUniversitas.subjects) {
            nilaiMap.put(subject, 60.0); // Nilai default
        }
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void addNilai(String subject, double nilai) {
        nilaiMap.put(subject, nilai);
    }

    public void editNilai(String subject, double nilai) {
        nilaiMap.put(subject, nilai);
    }

    public double getNilai(String subject) {
        return nilaiMap.getOrDefault(subject, 0.0); // Mengembalikan 0.0 jika tidak ada nilai
    }

    @Override
    public String getInfo() {
        return "Mahasiswa: " + name + ", NIM: " + nim;
    }
}