public abstract class Phone {
    abstract void insert(String name, String phone) throws PhoneBook.CustomException;
    abstract void lookUp(String name) throws PhoneBook.CustomException;
    abstract void delete(String name) throws PhoneBook.CustomException;
}
