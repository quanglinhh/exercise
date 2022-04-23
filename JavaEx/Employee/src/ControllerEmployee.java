import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerEmployee {
    public static void addEmployee(int empId, String empNo, String empName) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        //Create statement
        String query = "insert into employee values (?,?,?)";
        //Prepared
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,empId);
        preparedStatement.setString(2,empNo);
        preparedStatement.setString(3,empName);
        //Thuc thi cau lenh insert
        preparedStatement.executeUpdate();
        System.out.println("Đã thêm thành công employee: "+empName);
    }
    public static void getEmployeeByName(String name) throws SQLException, ClassNotFoundException {

        Connection connection = SQLServerConnection.getSQLServerConnection();
        containName(name);
        if(containName(name)){
            String query = "SELECT * FROM employee WHERE name =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("-------------------------------");
            System.out.println("EmpId  |  EmpNo  |  name  ");
            while (resultSet.next()){
                int empId = resultSet.getInt(1);
                String empNo = resultSet.getString(2);
                String empName= resultSet.getString(3);
                System.out.println("-------------------------------");
                System.out.println("  "+empId+"    |  "+empNo+"  |  "+name);
            }
            System.out.println("-------------------------------");
        }

    }
    public static void getAllEmployee() throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        System.out.println("-------------------------------");
        System.out.println("EmpId  |  EmpNo  |  name  ");
        while (resultSet.next()){
            int empId = resultSet.getInt(1);
            String empNo = resultSet.getString(2);
            String name = resultSet.getString(3);
            System.out.println("-------------------------------");
            System.out.println("  "+empId+"    |  "+empNo+"  |  "+name);
        }
        System.out.println("-------------------------------");
    }
    public static void editEmployee(String nameEdit) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String editEmpName ="UPDATE employee SET empno = ? WHERE name = ?";
        String editName ="UPDATE employee SET name = ? WHERE name = ?";
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        containName(nameEdit);
        if(containName(nameEdit)){
            while (ch != 3){
                System.out.println("----Chọn thay đổi-----");
                System.out.println("1. Thay đổi EmpNo");
                System.out.println("2. Thay đổi name");
                System.out.println("3. Hoàn thành thay đổi");
                System.out.println("-------------------------");
                ch = sc.nextInt();
                switch (ch){
                    case 1:
                        sc.nextLine();
                        System.out.print("Nhập EmpNo mới: ");
                        String empNo = sc.nextLine();
                        PreparedStatement newEmpNo =connection.prepareStatement(editEmpName);
                        newEmpNo.setString(1,empNo);
                        newEmpNo.setString(2,nameEdit);
                        newEmpNo.executeUpdate();
                        System.out.println("Đã thay đổi Empno của Employee: "+nameEdit+" thành: "+ empNo);
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.print("Nhập tên mới: ");
                        String name = sc.nextLine();
                        PreparedStatement newName =connection.prepareStatement(editName);
                        newName.setString(1,name);
                        newName.setString(2,nameEdit);
                        newName.executeUpdate();
                        System.out.println("Đã thay đổi name của Employee: "+nameEdit+" thành: "+ name);
                        break;
                    case 3:
                        break;
                }
            }
        }else {
            System.out.println("Không tồn tại Employee !");
        }
    }
    public static void deleteEmployee(String nameRemove) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        containName(nameRemove);
        if(containName(nameRemove)){
            String query = "DELETE FROM employee WHERE name =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,nameRemove);
            preparedStatement.executeUpdate();
            System.out.println("Đã xóa Employee: "+nameRemove);
        }else{
            System.out.println("Không tồn tại Employee !");
        }

    }
    public static boolean containName(String name) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        String containName = "SELECT * FROM employee WHERE name =?";
        PreparedStatement prepareStatement = connection.prepareStatement(containName);
        prepareStatement.setString(1,name);
        ResultSet resultname = prepareStatement.executeQuery();
        var count = new ArrayList<Integer>();
        while (resultname.next()){
            int empId = resultname.getInt(1);
            count.add(empId);
        }
        if(count.size() == 0){
            return false;
        }else {
            return true;
        }


    }
}