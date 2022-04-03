import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    String number, phone;
    List<String> phoneList = new ArrayList<>();

    public PhoneBook() {

    }

    public PhoneBook(String number, String phone) {
        this.number = number;
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void insert(String name , String number){
        boolean contain = false;
        for (String s : phoneList){
            if(s.contains(name)){
                contain = true;
                if (!s.contains(number)){
                    s+= " : " + number;
                }else{
                    System.out.println("Danh bạ này đã tồn tại");
                }
            }
        }
        if (!contain){
            phoneList.add(name+","+number);
        }
    }
    public void lookUp(String name){
        boolean searched = false;
        for (String s : phoneList){
            if(s.contains(name)){
                searched = true;
                System.out.println(s.toString());
                break;
            }
        }
        if(!searched){
            System.out.println("Not found Person");
        }
    }
    public void delete(String name ){
        boolean searched = false;
        for (String s :  phoneList){
            if(name.equals(s.substring(0, s.indexOf(",")))){
                searched = true;
                phoneList.remove(s);
                System.out.println("Removed");
                break;
            }
        }
        if (!searched){
            System.out.println("Not found person with name: "+name);
        }
    }
}

