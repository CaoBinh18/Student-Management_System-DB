package student.management.controller;


import student.management.dao.MathDAO;
import student.management.dto.MathDTO;
import student.management.model.Score;
import student.management.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ScoreServlet", urlPatterns = "/score")
public class ScoreServlet extends HttpServlet {
        private MathDAO mathDAO = new MathDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MathDTO> mathDTOList = mathDAO.selectAllScore();
        req.setAttribute("mathList", mathDTOList);
        RequestDispatcher dis = req.getRequestDispatcher("score/list.jsp");
        dis.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
