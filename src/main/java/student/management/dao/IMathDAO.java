package student.management.dao;

import student.management.dto.MathDTO;
import student.management.model.Score;

import java.sql.SQLException;
import java.util.List;

public interface IMathDAO {
    public List<MathDTO> selectAllScore();

    public void insertMath(Score score) throws SQLException;

    public boolean updateMath(Score score) throws SQLException;

    public MathDTO selectMath(int id) throws SQLException;

    public Score selectScore(int id) throws SQLException;
}
