package entity;

public class Khoa {
    private String makhoa;
    private String  tenkhoa;
    private String dienthoai;

    public Khoa(String makhoa, String tenkhoa, String dienthoai) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
        this.dienthoai = dienthoai;
    }
    public Khoa(){}

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
}
