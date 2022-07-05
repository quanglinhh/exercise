package entity;

public class SinhVien {
    private int masv;
    private String madt;
    private int magv;
    private double ketqua;

    public SinhVien(int masv, String madt, int magv, double ketqua) {
        this.masv = masv;
        this.madt = madt;
        this.magv = magv;
        this.ketqua = ketqua;
    }
    public SinhVien(){}

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getMadt() {
        return madt;
    }

    public void setMadt(String madt) {
        this.madt = madt;
    }

    public int getMagv() {
        return magv;
    }

    public void setMagv(int magv) {
        this.magv = magv;
    }

    public double getKetqua() {
        return ketqua;
    }

    public void setKetqua(double ketqua) {
        this.ketqua = ketqua;
    }
}
