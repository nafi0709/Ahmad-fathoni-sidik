import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PembayaranRokokSederhana {
    static class Rokok {
        String nama;
        double hargaPerBatang;

        Rokok(String nama, double hargaPerBatang) {
            this.nama = nama;
            this.hargaPerBatang = hargaPerBatang;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Rokok> daftarRokok = Arrays.asList(
                new Rokok("Sampoerna", 1200),
                new Rokok("Djarum Black", 1500),
                new Rokok("Gudang Garam", 1300),
                new Rokok("LA Lights", 1400),
                new Rokok("Marlboro", 1800)
        );

        System.out.println("=== Sistem Pembayaran Rokok Sederhana ===");

        while (true) {
            System.out.println("\nDaftar Rokok:");
            for (int i = 0; i < daftarRokok.size(); i++) {
                Rokok r = daftarRokok.get(i);
                System.out.printf("%d. %s - Rp %.0f/batang%n", i + 1, r.nama, r.hargaPerBatang);
            }
            System.out.println((daftarRokok.size() + 1) + ". Keluar");
            System.out.print("Pilih nomor rokok yang ingin dibeli: ");
            String pilihanStr = scanner.nextLine().trim();

            int pilihan;
            try {
                pilihan = Integer.parseInt(pilihanStr);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan nomor yang benar.");
                continue;
            }

            if (pilihan == daftarRokok.size() + 1) {
                System.out.println("Terima kasih telah berbelanja. Sampai jumpa!");
                break;
            }

            if (pilihan < 1 || pilihan > daftarRokok.size()) {
                System.out.println("Pilihan tidak tersedia. Silakan coba lagi.");
                continue;
            }

            Rokok rokokTerpilih = daftarRokok.get(pilihan - 1);

            System.out.printf("Masukkan jumlah batang %s yang ingin dibeli: ", rokokTerpilih.nama);
            String jumlahStr = scanner.nextLine().trim();
            int jumlah;
            try {
                jumlah = Integer.parseInt(jumlahStr);
            } catch (NumberFormatException e) {
                System.out.println("Jumlah harus berupa angka bulat.");
                continue;
            }

            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari nol.");
                continue;
            }

            double totalHarga = rokokTerpilih.hargaPerBatang * jumlah;
            System.out.printf("Total harga: Rp %.0f%n", totalHarga);

            System.out.print("Masukkan jumlah uang bayar: Rp ");
            String bayarStr = scanner.nextLine().trim();
            double bayar;
            try {
                bayar = Double.parseDouble(bayarStr);
            } catch (NumberFormatException e) {
                System.out.println("Input pembayaran tidak valid.");
                continue;
            }

            if (bayar < totalHarga) {
                System.out.println("Uang bayar kurang dari total harga. Pembayaran gagal.");
                continue;
            }

            double kembalian = bayar - totalHarga;
            System.out.printf("Pembayaran berhasil. Kembalian: Rp %.0f%n", kembalian);
        }

        scanner.close();
    }
}
