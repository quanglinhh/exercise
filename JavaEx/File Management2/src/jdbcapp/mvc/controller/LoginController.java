package jdbcapp.mvc.controller;

import jdbcapp.mvc.entity.Users;
import jdbcapp.mvc.model.LoginDAOImpl;

import java.sql.SQLException;

public class LoginController {
    //Step2
    LoginDAOImpl loginDAO = new LoginDAOImpl();

    public String loginStatementController(Users users) throws SQLException, ClassNotFoundException {
        return loginDAO.checkLoginStatement(users);
    }
    public String loginPrepareStatementController(Users users) throws SQLException, ClassNotFoundException {
        return  loginDAO.checkLoginPreparedStatement(users);
    }
}
