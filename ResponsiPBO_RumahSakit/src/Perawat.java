public class Perawat extends TenagaMedis implements PemeriksaanPasien {
    private String shift;
    public Perawat(String idPegawai, String nama) {
        this(idPegawai, nama, "Pagi");
    }

    public Perawat(String idPegawai, String nama, String shift) {
        super(idPegawai, nama);
        this.shift = shift;
    }

    @Override
    public String tangani(Pasien pasien) {
        String hasil;
        if (!siapBertugas()) {
            hasil = "Ns. " + getNama() + " kelelahan (stamina " + getStamina() + "), butuh istirahat.";
        } else if (pasien.isKritis()) {
            pasien.setStatus(Pasien.STATUS_MENUNGGU_DOKTER);
            setStamina(getStamina() - 5);
            hasil = "Ns. " + getNama() + " merujuk " + pasien.getNama() + " ke dokter (kondisi kritis).";
        } else {
            pasien.kurangiKeparahan(20);
            pasien.setStatus(Pasien.STATUS_RAWAT_JALAN);
            setStamina(getStamina() - 10);
            setTotalPasienDitangani(getTotalPasienDitangani() + 1);
            hasil = "Ns. " + getNama() + " memberi perawatan dasar kepada " + pasien.getNama() + ".";
        }
        return hasil;
    }

    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("     Perawat shift " + shift);
    }

    @Override
    public void periksaPasien(Pasien pasien) {
        System.out.println("  Ns. " + getNama() + " mengukur tanda vital " + pasien.getNama()
                + " (status: " + pasien.getStatus() + ")");
    }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}
