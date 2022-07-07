package Ex2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {


    public static boolean valEmail(String input){
        String EMAIL_REGEX ="^[B]+[1-9]{1,9}$";
        Pattern emailPat = Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);
        return matcher.find();
    }


    public static void main(String[] args) {
        System.out.println("Nhập vào mã số sinh viên: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        valEmail(email);
        if(valEmail(email)){
            System.out.println("mã sinh viên hợp lệ");
        }else {
            System.out.println("Mã sinh viên không hợp lệ");
        }
    }
}
