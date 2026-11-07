public class Pasien {

    public static final int KEPARAHAN_MAKS = 100;
    public static final int BATAS_KRITIS = 70;
    public static final String STATUS_BARU = "BARU";
    public static final String STATUS_RAWAT_JALAN = "RAWAT JALAN";
    public static final String STATUS_RAWAT_INTENSIF = "RAWAT INTENSIF";
    public static final String STATUS_MENUNGGU_DOKTER = "MENUNGGU DOKTER";
    public static final String STATUS_SEMBUH = "SEMBUH";

    private final String idPasien;

    private String nama;
    private int umur;
    private int tingkatKeparahan;
    private String status;

    public Pasien(String idPasien, String nama) {
        this(idPasien, nama, 0, 50);
    }

    public Pasien(String idPasien, String nama, int umur, int tingkatKeparahan) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.umur = umur;
        setTingkatKeparahan(tingkatKeparahan);
        this.status = STATUS_BARU;
    }

    public void kurangiKeparahan(int nilai) {
        setTingkatKeparahan(this.tingkatKeparahan - nilai);
    }

    public void tampilkanData() {
        System.out.println("  [Pasien] " + idPasien + " | " + nama
                + " | umur: " + umur
                + " | keparahan: " + tingkatKeparahan
                + " | status: " + status);
    }

    public boolean isKritis() {
        return tingkatKeparahan >= BATAS_KRITIS;
    }

    public String getIdPasien() { return idPasien; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getUmur() { return umur; }
    public void setUmur(int umur) { this.umur = umur; }

    public int getTingkatKeparahan() { return tingkatKeparahan; }
    public void setTingkatKeparahan(int tingkatKeparahan) {
        if (tingkatKeparahan < 0) {
            this.tingkatKeparahan = 0;
        } else if (tingkatKeparahan > KEPARAHAN_MAKS) {
            this.tingkatKeparahan = KEPARAHAN_MAKS;
        } else {
            this.tingkatKeparahan = tingkatKeparahan;
        }
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
