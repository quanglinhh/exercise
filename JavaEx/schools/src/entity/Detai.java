package entity;

public class Detai {
    private int madt;
    private String tendt;
    private int kinhphi;
    private String NoiThucTap;

    public Detai(int madt, String tendt, int kinhphi, String noiThucTap) {
        this.madt = madt;
        this.tendt = tendt;
        this.kinhphi = kinhphi;
        NoiThucTap = noiThucTap;
    }
    public Detai(){}

    public int getMadt() {
        return madt;
    }

    public void setMadt(int madt) {
        this.madt = madt;
    }

    public String getTendt() {
        return tendt;
    }

    public void setTendt(String tendt) {
        this.tendt = tendt;
    }

    public int getKinhphi() {
        return kinhphi;
    }

    public void setKinhphi(int kinhphi) {
        this.kinhphi = kinhphi;
    }

    public String getNoiThucTap() {
        return NoiThucTap;
    }

    public void setNoiThucTap(String noiThucTap) {
        NoiThucTap = noiThucTap;
    }
}
