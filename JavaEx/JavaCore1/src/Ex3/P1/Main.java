package Ex3.P1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangHoa hangHoa = new HangHoa();
        boolean kiemTraTen = true;
        boolean kiemTraHan = true;
        System.out.print("Nhập mã hàng: ");
        int ma = scanner.nextInt();
        hangHoa.setMa(ma);
        scanner.nextLine();
        do{
            System.out.print("Nhập tên hàng: ");
            String name = scanner.nextLine();
            hangHoa.setTen(name);
        }while (hangHoa.kiemTraTenHang(kiemTraTen));
        do{
            System.out.print("Nhập ngày sản xuất: ");
            hangHoa.setNgaySanXuat(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.print("Nhập ngày hết hạn: ");
            hangHoa.setNgayHetHan(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }while (hangHoa.kiemTraNgay(kiemTraHan));
        System.out.println(hangHoa);
        hangHoa.kiemTraHSD();
    }
}
