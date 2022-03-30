public abstract class Phone {
    abstract void insert(String name, String phone) throws CustomException;
    abstract void lookUp(String name) throws CustomException;
    abstract void delete(String name) throws CustomException;
}
