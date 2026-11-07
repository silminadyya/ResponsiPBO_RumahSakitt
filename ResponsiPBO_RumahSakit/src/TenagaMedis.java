public abstract class TenagaMedis {
    public static final String NAMA_RUMAH_SAKIT = "RSU Soedirman Sehat";
    public static final int STAMINA_MAKS = 100;
    public static final int STAMINA_MIN = 20;
    public static final double GAJI_DEFAULT = 5_000_000;
    public static final double BONUS_PER_PASIEN = 50_000;

    private final String idPegawai;

    private String nama;
    private double gajiPokok;
    private int stamina;
    private int totalPasienDitangani;
    public TenagaMedis(String idPegawai, String nama) {
        this(idPegawai, nama, GAJI_DEFAULT);
    }

    public TenagaMedis(String idPegawai, String nama, double gajiPokok) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.gajiPokok = gajiPokok;
        this.stamina = STAMINA_MAKS;
        this.totalPasienDitangani = 0;
    }

    public abstract String tangani(Pasien pasien);
    public void istirahat() {
        setStamina(STAMINA_MAKS);
        System.out.println("  " + nama + " beristirahat. Stamina pulih ke " + stamina);
    }

    public void tampilkanProfil() {
        System.out.println("  [" + NAMA_RUMAH_SAKIT + "] " + idPegawai + " | " + nama
                + " | stamina: " + stamina
                + " | pasien ditangani: " + totalPasienDitangani);
    }

    public double hitungGajiTotal() {
        return gajiPokok + (totalPasienDitangani * BONUS_PER_PASIEN);
    }

    public boolean siapBertugas() {
        return stamina >= STAMINA_MIN;
    }

    public String getIdPegawai() { return idPegawai; } // final -> tanpa setter

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getGajiPokok() { return gajiPokok; }
    public void setGajiPokok(double gajiPokok) { this.gajiPokok = gajiPokok; }

    public int getStamina() { return stamina; }
    public void setStamina(int stamina) {
        if (stamina < 0) {
            this.stamina = 0;
        } else if (stamina > STAMINA_MAKS) {
            this.stamina = STAMINA_MAKS;
        } else {
            this.stamina = stamina;
        }
    }

    public int getTotalPasienDitangani() { return totalPasienDitangani; }
    public void setTotalPasienDitangani(int totalPasienDitangani) {
        this.totalPasienDitangani = totalPasienDitangani;
    }
}
