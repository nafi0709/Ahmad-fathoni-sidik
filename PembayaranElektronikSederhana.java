import java.util.Scanner;

public class PembayaranElektronikSederhana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 100000.0; // saldo awal

        System.out.println("=== Sistem Pembayaran Elektronik Sederhana ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan saldo");
            System.out.println("2. Lakukan pembayaran");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    System.out.printf("Saldo Anda saat ini: %.2f%n", saldo);
                    break;

                case "2":
                    System.out.print("Masukkan nama merchant: ");
                    String merchant = scanner.nextLine().trim();

                    if (merchant.isEmpty()) {
                        System.out.println("Nama merchant tidak boleh kosong.");
                        break;
                    }

                    System.out.print("Masukkan jumlah pembayaran: ");
                    String jumlahStr = scanner.nextLine().trim();

                    double jumlah;
                    try {
                        jumlah = Double.parseDouble(jumlahStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Format jumlah tidak valid.");
                        break;
                    }

                    if (jumlah <= 0) {
                        System.out.println("Jumlah harus lebih dari nol.");
                        break;
                    }

                    if (jumlah > saldo) {
                        System.out.println("Saldo tidak mencukupi untuk melakukan pembayaran.");
                    } else {
                        saldo -= jumlah;
                        System.out.printf("Pembayaran sebesar %.2f ke %s berhasil.%n", jumlah, merchant);
                        System.out.printf("Sisa saldo: %.2f%n", saldo);
                    }
                    break;

                case "3":
                    System.out.println("Terima kasih telah menggunakan sistem pembayaran elektronik. Sampai jumpa!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }
}
