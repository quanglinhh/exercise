package jdbcapp.mvc.model;

import jdbcapp.SQLSeverConnection;
import jdbcapp.mvc.dao.SQLServerConnection;
import jdbcapp.mvc.entity.Users;

import java.sql.*;
import java.util.Collection;

public class LoginDAOImpl implements loginDAO{

    @Override
    public String checkLoginStatement(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();
        String query = "SELECT username FROM users WHERE username = '"+users.getUserName()+"'"
                +"AND password='"+users.getPassword()+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            System.out.println("Login thanh cong: "+resultSet.getString("username"));
            return users.getPassword();
        }
        return "fail";
    }
    @Override
    public String checkLoginPreparedStatement(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();
        String query = "SELECT username FROM users WHERE username =? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, users.getUserName());
        preparedStatement.setString(2,users.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("Login thanh cong: "+resultSet.getString("username"));
            return users.getPassword();
        }
        return "fail";
    }
}
