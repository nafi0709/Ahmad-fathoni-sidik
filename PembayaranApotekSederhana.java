import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PembayaranApotekSederhana {
    static class Obat {
        String nama;
        double harga;

        Obat(String nama, double harga) {
            this.nama = nama;
            this.harga = harga;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar obat di apotek
        List<Obat> daftarObat = Arrays.asList(
                new Obat("Paracetamol", 5000),
                new Obat("Amoxicillin", 12000),
                new Obat("Vitamin C", 8000),
                new Obat("Obat Batuk", 7000),
                new Obat("Antiseptik", 15000)
        );

        System.out.println("=== Sistem Pembayaran Apotek Sederhana ===");

        while (true) {
            System.out.println("\nDaftar Obat:");
            for (int i = 0; i < daftarObat.size(); i++) {
                Obat obat = daftarObat.get(i);
                System.out.printf("%d. %s - Rp %.0f%n", i + 1, obat.nama, obat.harga);
            }
            System.out.println((daftarObat.size() + 1) + ". Keluar");
            System.out.print("Pilih nomor obat yang ingin dibeli: ");
            String pilihanStr = scanner.nextLine().trim();

            int pilihan;
            try {
                pilihan = Integer.parseInt(pilihanStr);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan nomor yang benar.");
                continue;
            }

            if (pilihan == daftarObat.size() + 1) {
                System.out.println("Terima kasih telah berkunjung ke apotek kami. Sampai jumpa!");
                break;
            }

            if (pilihan < 1 || pilihan > daftarObat.size()) {
                System.out.println("Pilihan tidak tersedia. Silakan coba lagi.");
                continue;
            }

            Obat obatTerpilih = daftarObat.get(pilihan - 1);

            System.out.printf("Masukkan jumlah %s yang ingin dibeli: ", obatTerpilih.nama);
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

            double totalHarga = obatTerpilih.harga * jumlah;
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
