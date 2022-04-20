//Functional interface: là các interface có duy nhất một method trừu tượng
//Để sử dụng nó ta thêm annotation @FunctionalInterface
@FunctionalInterface
public interface AddNumber{
    public int sum(int numb1, int numb2);
}
