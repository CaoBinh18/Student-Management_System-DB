package student.management.controller;


import student.management.dao.MathDAO;
import student.management.dto.MathDTO;
import student.management.model.Score;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ScoreServlet", urlPatterns = "/score")
public class ScoreServlet extends HttpServlet {
        private MathDAO mathDAO = new MathDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "edit":
                    showEditForm(req, resp);
                    break;
                default:
                    listScore(req, resp);
                    break;
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        MathDTO existingScore = mathDAO.selectMath(id);
        req.setAttribute("score", existingScore);
        RequestDispatcher dispatcher = req.getRequestDispatcher("score/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void listScore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MathDTO> mathDTOList = mathDAO.selectAllScore();
        req.setAttribute("mathList", mathDTOList);
        RequestDispatcher dis = req.getRequestDispatcher("score/list.jsp");
        dis.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
            switch (action) {
//                case "edit":
//                    updateScore(req, resp);
//                    break;
                default:
                    listScore(req, resp);
                    break;
            }

//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
    }

//    private void updateScore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String ktbc = req.getParameter("ktbc");
//        String kt15p = req.getParameter("kt15p");
//        String kt45p = req.getParameter("kt45p");
//        String kthk = req.getParameter("kthk");
//        Score editScore = mathDAO.selectScore(id);
//        RequestDispatcher dispatcher;
//        if (name == "") {
//            req.setAttribute("success", null);
//            req.setAttribute("error", "All field is required");
//            showEditForm(req, resp);
//        } else {
//                editScore.setId(id);
//                editScore.s(s);
//                editScore.setKtBaiCu(ktbc);
//                editScore.setKt15p(kt15p);
//                editScore.setKt45p(k);
//                editScore.setKtHocKi(kthk)
//                studentDAO.updateStudent(editStudent);
//                request.setAttribute("success", "Student was edit success!");
//                request.setAttribute("error", null);
//                showEditForm(request, response);
//            }
//        }
//    }
}
