package Ex3.P1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public HangHoa(){}
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


    public void setNgaySanXuat(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.ngaySanXuat = calendar.getTime();
    }
    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.ngayHetHan = calendar.getTime();
    }
    //kiểm tra tên hàng không được để trống
    public boolean kiemTraTenHang(boolean k) {
        if (this.ten == "" || this.ten.isEmpty()) {
            System.out.println("Tên hàng không được để trống : ");
        } else {
            k = false;
        }
        return k;
    }
    //khởi tạo hàm kiểm tra ngày hết hạn không được nhỏ hơn ngày sản xuất
    public boolean kiemTraNgay(boolean t) {
        if (this.getNgaySanXuat().compareTo(this.getNgayHetHan()) < 0) {
            t = false;
        } else {
            System.out.println("Ngày hết hạn không được nhỏ hơn ngày sản xuất : ");
        }
        return t;
    }
    //khởi tạo phương thức kiểm tra hạn sử dụng của sản phẩm đã hết hạn hay còn hạn
    public void kiemTraHSD() {
        Date today = new Date();
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String st = simpleDateFormat.format(today);
        if (this.getNgayHetHan().compareTo(today) < 0) {
            System.out.println("Hôm nay là ngày " + st + ", hàng hóa đã hết hạn ");
        } else {
            System.out.println("Hôm nay là ngày " + st + ", hàng hóa vẫn còn hạn ");
        }
    }
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    @Override
    public String toString() {
        return "Mã sản phẩm: "+ma+", Tên sản phẩm: "+ten+", Ngày sản xuất: "+df.format(ngaySanXuat)+", Ngày hết hạn: "+df.format(ngayHetHan);
    }
}
