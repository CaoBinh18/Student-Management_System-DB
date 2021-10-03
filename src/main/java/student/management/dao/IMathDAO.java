package student.management.dao;

import student.management.dto.MathDTO;
import student.management.model.Score;
import student.management.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IMathDAO {
    public List<MathDTO> selectAllScore();

    public void insertMath(Score score) throws SQLException;
}
