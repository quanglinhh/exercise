package Ex3.P1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HangHoa {
    private int ma;
    private String ten;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    public HangHoa(int ma, String ten, Date ngaySanXuat, Date ngayHetHan) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public String toString() {
        return "Mã sản phẩm: "+ma+", Tên sản phẩm: "+ten+", Ngày sản xuất: "+df.format(ngaySanXuat)+", Ngày hết hạn: "+df.format(ngayHetHan);
    }
}
