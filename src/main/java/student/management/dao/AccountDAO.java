package student.management.dao;

import student.management.model.Account;
import student.management.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO implements IAccountDAO{
    public AccountDAO() {
    }

    Connection connection = MySQLUtils.getConnection();

    @Override
    public Account selectAccount(String usename, String password) {
        String query = "SELECT * FROM accounts WHERE username = ? AND password = ?;";
        Account account = null;

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usename);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                String pass = rs.getString(3);

                account = new Account(id, user, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }
}

