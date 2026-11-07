public class MainRS   {
    private static void judul(String teks) {
        System.out.println("\n=== " + teks + " ===");
    }

    public static void main(String[] args) {

        judul("[1] State dan Behavior");
        Pasien budi = new Pasien("P-001", "Budi", 30, 80);
        budi.tampilkanData();
        System.out.println("  Budi kritis? " + budi.isKritis());

        judul("[2] Immutability");
        System.out.println("  Konstanta : " + TenagaMedis.NAMA_RUMAH_SAKIT
                + " | stamina maks = " + TenagaMedis.STAMINA_MAKS);
        System.out.println("  ID final  : " + budi.getIdPasien() + " (tidak punya setter)");

        judul("[3] Enkapsulasi dan Overloading");
        Pasien siti = new Pasien("P-002", "Siti");
        Pasien andi = new Pasien("P-003", "Andi", 22, 40);
        siti.setNama("Siti Aminah");
        siti.setUmur(27);
        System.out.println("  Getter nama: " + siti.getNama() + ", umur: " + siti.getUmur());
        siti.tampilkanData();
        andi.tampilkanData();

        judul("[4] Inheritance (superclass + 2 subclass)");
        Dokter dokter = new Dokter("D-01", "Rina", "Bedah");
        Dokter dokter2 = new Dokter("D-02", "Hasan", 12_000_000, "Penyakit Dalam");
        Perawat perawat = new Perawat("N-01", "Dewi", "Malam");
        TenagaMedis[] semua = { dokter, dokter2, perawat };
        for (TenagaMedis t : semua) {
            System.out.println("  " + t.getNama() + " adalah turunan TenagaMedis: "
                    + (t instanceof TenagaMedis));
        }

        judul("[5] Super Chaining & [6] Method Overriding");
        System.out.println("  tampilkanProfil() di-override, memanggil super.tampilkanProfil():");
        dokter.tampilkanProfil();
        perawat.tampilkanProfil();

        judul("[7] Abstract Class & [8] Logika State (if/else)");
        System.out.println("  Pasien kritis (Budi) ditangani:");
        System.out.println("  -> " + dokter.tangani(budi));
        budi.tampilkanData();
        dokter.tampilkanProfil();

        System.out.println("  Pasien sedang (Siti) ditangani perawat:");
        System.out.println("  -> " + perawat.tangani(siti));
        siti.tampilkanData();

        System.out.println("  Pasien ringan (Andi) ditangani dokter:");
        andi.setTingkatKeparahan(10);
        System.out.println("  -> " + dokter2.tangani(andi));
        andi.tampilkanData();

        System.out.println("  Uji cabang 'kelelahan':");
        perawat.setStamina(10);
        System.out.println("  -> " + perawat.tangani(siti));
        perawat.istirahat();

        judul("[9] Polimorfisme Interface");
        PemeriksaanPasien pemeriksa1 = new Dokter("D-03", "Agus", "Anak");
        PemeriksaanPasien pemeriksa2 = new Perawat("N-02", "Lina");
        Pasien rudi = new Pasien("P-004", "Rudi", 45, 65);
        pemeriksa1.periksaPasien(rudi);
        pemeriksa2.periksaPasien(rudi);

        judul("[10] Multiple Interface (Dokter implements PemeriksaanPasien, DapatOperasi)");
        Pasien dewa = new Pasien("P-005", "Dewa", 50, 90);
        dokter2.periksaPasien(dewa);
        DapatOperasi operator = dokter2;
        operator.lakukanOperasi(dewa);
        dewa.tampilkanData();
        System.out.println("  Dokter instanceof PemeriksaanPasien: " + (dokter2 instanceof PemeriksaanPasien));
        System.out.println("  Dokter instanceof DapatOperasi     : " + (dokter2 instanceof DapatOperasi));
        System.out.println("  Gaji total dr. " + dokter2.getNama() + ": Rp "
                + String.format("%.0f", dokter2.hitungGajiTotal()));

        System.out.println("\nSemua persyaratan telah didemonstrasikan.");
    }
}