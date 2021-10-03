package student.management.dao;

import student.management.dto.MathDTO;
import student.management.model.Score;
import student.management.model.Student;
import student.management.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MathDAO implements IMathDAO {
    Connection connection = MySQLUtils.getConnection();

    @Override
    public List<MathDTO> selectAllScore() {
        List<MathDTO> mathDTOList = new ArrayList<>();
        String query = "SELECT sc.id, s.name, sc.kt_baicu, sc.kt_15p, sc.kt_45p, sc.kt_hocki\n" +
                "FROM score sc\n" +
                "JOIN students s\n" +
                "ON sc.stu_id = s.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String dob = rs.getString("dob");
//                String address = rs.getString("address");
//                double gpa = rs.getDouble("gpa");
                int id = rs.getInt("sc.id");
                String name = rs.getString("s.name");
                double ktbc = rs.getDouble("sc.kt_baicu");
                double kt15 = rs.getDouble("sc.kt_15p");
                double kt45 = rs.getDouble("sc.kt_45p");
                double kthk = rs.getDouble("sc.kt_hocki");
                mathDTOList.add(new MathDTO(id, name, ktbc, kt15, kt45, kthk));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return mathDTOList;
    }

    @Override
    public void insertMath(Score score) throws SQLException {
        String query = "INSERT INTO score (id, sub_id, stu_id, kt_baicu, kt_15p, kt_45p, kt_hocki) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1 , score.getId());
            ps.setDouble(2, score.getSubId());
            ps.setDouble(3, score.getStuId());
            ps.setDouble(4, score.getKtBaiCu());
            ps.setDouble(5, score.getKt15p());
            ps.setDouble(6, score.getKt45p());
            ps.setDouble(7, score.getKtHocKi());
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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
