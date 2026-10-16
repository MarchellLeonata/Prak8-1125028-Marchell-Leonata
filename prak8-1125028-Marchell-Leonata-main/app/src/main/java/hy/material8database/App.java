package hy.material8database;

import hy.material8database.models.Mahasiswa;
import hy.material8database.repository.MahasiswaRepository;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner scanner = new Scanner(System.in);

    public App() {
        menuUtama();
    }

    private void menuUtama() {
        int pilih;

        do {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Jurusan");
            System.out.println("3. Mata Kuliah");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    menuMahasiswa();
                    break;
                case 2:
                    menuJurusan();
                    break;
                case 3:
                    menuMataKuliah();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    private int bacaAngka() {
        try {
            int angka = Integer.parseInt(scanner.nextLine());
            return angka;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ================= MAHASISWA =================

    private void menuMahasiswa() {
        int pilih;

        do {
            System.out.println("\n===== MENU MAHASISWA =====");
            System.out.println("1. View All");
            System.out.println("2. Create");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. Ambil Matkul");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    printAllMahasiswa();
                    break;
                case 2:
                    addNewMahasiswa();
                    break;
                case 3:
                    System.out.println("Fitur Edit belum dihubungkan.");
                    break;
                case 4:
                    System.out.println("Fitur Delete belum dihubungkan.");
                    break;
                case 5:
                    System.out.println("Fitur Ambil Matkul belum dihubungkan.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    private void printAllMahasiswa() {
        List<Mahasiswa> allMahasiswa =
                MahasiswaRepository.getAllMahasiswa();

        System.out.println("\n===== DAFTAR MAHASISWA =====");

        if (allMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nim + " - " + m.nama);
        }
    }

    private void addNewMahasiswa() {
        System.out.println("\n===== TAMBAH MAHASISWA =====");

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama, kodeJurusan);
        MahasiswaRepository.addMahasiswa(mhs);

        System.out.println("Proses tambah mahasiswa selesai.");
    }

    // ================= JURUSAN =================

    private void menuJurusan() {
        int pilih;

        do {
            System.out.println("\n===== MENU JURUSAN =====");
            System.out.println("1. View All");
            System.out.println("2. Create");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    System.out.println("Fitur View All Jurusan belum dihubungkan.");
                    break;
                case 2:
                    System.out.println("Fitur Create Jurusan belum dihubungkan.");
                    break;
                case 3:
                    System.out.println("Fitur Edit Jurusan belum dihubungkan.");
                    break;
                case 4:
                    System.out.println("Fitur Delete Jurusan belum dihubungkan.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    // ================= MATA KULIAH =================

    private void menuMataKuliah() {
        int pilih;

        do {
            System.out.println("\n===== MENU MATA KULIAH =====");
            System.out.println("1. View All");
            System.out.println("2. Create");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    System.out.println("Fitur View All Mata Kuliah belum dihubungkan.");
                    break;
                case 2:
                    System.out.println("Fitur Create Mata Kuliah belum dihubungkan.");
                    break;
                case 3:
                    System.out.println("Fitur Edit Mata Kuliah belum dihubungkan.");
                    break;
                case 4:
                    System.out.println("Fitur Delete Mata Kuliah belum dihubungkan.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    public static void main(String[] args) {
        new App();
    }
}