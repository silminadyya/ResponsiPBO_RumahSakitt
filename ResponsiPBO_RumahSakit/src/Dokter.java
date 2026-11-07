public class Dokter extends TenagaMedis implements PemeriksaanPasien, DapatOperasi {
    private String spesialisasi;
    private int jumlahOperasi;

    public Dokter(String idPegawai, String nama, String spesialisasi) {
        this(idPegawai, nama, GAJI_DEFAULT * 2, spesialisasi);
    }

    public Dokter(String idPegawai, String nama, double gajiPokok, String spesialisasi) {
        super(idPegawai, nama, gajiPokok);
        this.spesialisasi = spesialisasi;
        this.jumlahOperasi = 0;
    }

    @Override
    public String tangani(Pasien pasien) {
        String hasil;
        if (!siapBertugas()) {
            hasil = "dr. " + getNama() + " kelelahan (stamina " + getStamina() + "), butuh istirahat.";
        } else if (pasien.isKritis()) {
            pasien.setStatus(Pasien.STATUS_RAWAT_INTENSIF);
            pasien.kurangiKeparahan(20);
            setStamina(getStamina() - 30);
            setTotalPasienDitangani(getTotalPasienDitangani() + 1);
            hasil = "dr. " + getNama() + " memasukkan " + pasien.getNama() + " ke rawat intensif.";
        } else if (pasien.getTingkatKeparahan() >= 30) {
            pasien.setStatus(Pasien.STATUS_RAWAT_JALAN);
            pasien.kurangiKeparahan(30);
            setStamina(getStamina() - 15);
            setTotalPasienDitangani(getTotalPasienDitangani() + 1);
            hasil = "dr. " + getNama() + " memberi resep rawat jalan kepada " + pasien.getNama() + ".";
        } else {
            pasien.setStatus(Pasien.STATUS_SEMBUH);
            pasien.setTingkatKeparahan(0);
            setStamina(getStamina() - 10);
            setTotalPasienDitangani(getTotalPasienDitangani() + 1);
            hasil = "dr. " + getNama() + " menyatakan " + pasien.getNama() + " sembuh.";
        }
        return hasil;
    }

    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("     Dokter spesialis " + spesialisasi + " | operasi: " + jumlahOperasi);
    }

    @Override
    public double hitungGajiTotal() {
        return super.hitungGajiTotal() + (jumlahOperasi * 500_000);
    }

    @Override
    public void periksaPasien(Pasien pasien) {
        System.out.println("  dr. " + getNama() + " mendiagnosis " + pasien.getNama()
                + " (keparahan " + pasien.getTingkatKeparahan() + ")");
    }

    @Override
    public boolean lakukanOperasi(Pasien pasien) {
        if (getStamina() >= 50 && pasien.getTingkatKeparahan() >= 50) {
            pasien.kurangiKeparahan(50);
            pasien.setStatus(Pasien.STATUS_RAWAT_INTENSIF);
            setStamina(getStamina() - 40);
            jumlahOperasi++;
            System.out.println("  Operasi pada " + pasien.getNama() + " BERHASIL oleh dr. " + getNama());
            return true;
        }
        System.out.println("  Operasi pada " + pasien.getNama() + " TIDAK dilakukan (stamina/kondisi tidak memenuhi).");
        return false;
    }

    public String getSpesialisasi() { return spesialisasi; }
    public void setSpesialisasi(String spesialisasi) { this.spesialisasi = spesialisasi; }

    public int getJumlahOperasi() { return jumlahOperasi; }
    public void setJumlahOperasi(int jumlahOperasi) { this.jumlahOperasi = jumlahOperasi; }
}
