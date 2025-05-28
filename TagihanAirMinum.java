import java.util.Scanner;

public class TagihanAirMinum {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Sistem Pembayaran Air Minum");
        System.out.println("-------------------------------");

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = Scanner.nextLine();

        System.out.print("Masukkan jumlah pemakaian air (m3): ");
        double pemakaianAir = Scanner.nextDouble();

        double tarifAir = 0;
        if (pemakaianAir <= 10) {
            tarifAir = 1000;
        } else if (pemakaianAir <= 20) {
            tarifAir = 1500;
        } else {
            tarifAir = 2000;
        }

        double totalBiaya = pemakaianAir * tarifAir;
        double pajak = totalBiaya * 0.1;
        double totalPembayaran = totalBiaya + pajak;

        System.out.println("\nRincian Pembayaran:");
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Pemakaian Air: " + pemakaianAir + " m3");
        System.out.println("Tarif Air: Rp " + tarifAir + "/m3");
        System.out.println("Total Biaya: Rp " + totalBiaya);
        System.out.println("Pajak (10%): Rp " + pajak);
        System.out.println("Total Pembayaran: Rp " + totalPembayaran);
    }
}