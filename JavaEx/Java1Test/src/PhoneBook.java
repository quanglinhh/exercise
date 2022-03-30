import java.util.ArrayList;

class CustomException extends Exception{
    private static final long serialVersionUID = 1L;
    public CustomException(String str){
        super();
        System.out.println(str);


    }
}
public class PhoneBook extends Phone{
ArrayList<String> phoneList = new ArrayList<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    void insert(String name, String phone){
        boolean contain = false;
        for (String s : phoneList){
            if(s.contains(name)){
                contain = true;
                if (!s.contains(phone)){
                    s+= " : " + phone;
                }else{
                    System.out.println("Danh bạ này đã tồn tại");
                }
            }
        }
        if (!contain){
            phoneList.add(name+","+phone);
        }
    }

    @Override
    void lookUp(String name){
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

    @Override
    void delete(String name){
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
