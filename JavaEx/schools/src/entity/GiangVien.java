package entity;

public class GiangVien {
    private int magv;
    private String hotengv;
    private String makhoa;
    private int namsinh;
    private String quequan;

    public GiangVien(int magv, String hotengv, String makhoa, int namsinh, String quequan) {
        this.magv = magv;
        this.hotengv = hotengv;
        this.makhoa = makhoa;
        this.namsinh = namsinh;
        this.quequan = quequan;
    }
    public GiangVien(){}

    public int getMagv() {
        return magv;
    }

    public void setMagv(int magv) {
        this.magv = magv;
    }

    public String getHotengv() {
        return hotengv;
    }

    public void setHotengv(String hotengv) {
        this.hotengv = hotengv;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}
