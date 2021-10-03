package student.management.dao;

import student.management.model.Account;

public interface IAccountDAO {
    public Account selectAccount(String usename, String password);
}
