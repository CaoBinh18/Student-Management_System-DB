package student.management.dao;

import student.management.model.Student;
import student.management.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    public StudentDAO() {
    }

    Connection connection = MySQLUtils.getConnection();

    @Override
    public void insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, email, dob, address) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1 , student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDob());
            ps.setString(4, student.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Student selectStudent(int id) throws SQLException {
        Student student = null;
        String query = "SELECT name, email, dob, address, gpa FROM students WHERE id = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                double gpa = rs.getDouble("gpa");
                student = new Student(id, name, email, dob, address, gpa);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            connection.rollback();
            printSQLException(e);
        }
        return student;
    }

    public int selectIdStudent(){
        int idc = 0;
        String query = "SELECT * FROM students ORDER BY id DESC LIMIT 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                idc = rs.getInt("id");
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return idc;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT id, name, email, dob, address, gpa FROM students WHERE is_deleted = '0';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                double gpa = rs.getDouble("gpa");
                studentList.add(new Student(id, name, email, dob, address, gpa));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return studentList;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean check = false;
        String query = "UPDATE students SET is_deleted = '1' WHERE (id = ?);";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            connection.rollback();
            printSQLException(e);
        }
        return check;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean check = false;
        String query = "UPDATE students SET name = ?, email = ?, dob = ?, address = ? WHERE id = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getDob());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setInt(5, student.getId());
            connection.commit();
            connection.setAutoCommit(true);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            connection.rollback();
            printSQLException(e);
        }
        return check;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
