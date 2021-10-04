package student.management.controller;

import student.management.dao.AccountDAO;
import student.management.dao.MathDAO;
import student.management.dao.StudentDAO;
import student.management.model.Account;
import student.management.model.Score;
import student.management.model.Student;
import student.management.utils.CheckRegex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    private AccountDAO accountDAO;
    private MathDAO mathDAO;
    public void init() {
        studentDAO = new StudentDAO();
        accountDAO = new AccountDAO();
        mathDAO = new MathDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Account account = accountDAO.selectAccount(username, password);
        if (account == null) {
            response.sendRedirect("/login");
        } else {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        showDeleteStudent(request, response);
                        break;
                    default:
                        listStudent(request, response);
                        break;
                }

            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createStudent(request, response);
                    break;
                case "edit":
                    updateStudent(request, response);
                    break;
                case "search":
                    searchStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        try{
            RequestDispatcher dispatcher = null;
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = studentDAO.selectStudent(id);
            if(student == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
                dispatcher.forward(request,response);
            }else{
                request.setAttribute("student", student);
                request.setAttribute("message_delete", "User has been deleted");
                dispatcher = request.getRequestDispatcher("student/delete.jsp");
                dispatcher.forward(request, response);
            }

        }catch (Exception e){
            e.getMessage();
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-404.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        RequestDispatcher dis;
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = studentDAO.selectStudent(id);
            if(student == null){
                dis = request.getRequestDispatcher("error-404.jsp");
            }else{
                boolean check = true;
                if(check){
                    studentDAO.deleteStudent(id);
//                    List<Student> studentList = studentDAO.selectAllStudent();
//                    request.setAttribute("students",studentList);
//                    response.sendRedirect("student");
                    request.setAttribute("error",null);
                    request.setAttribute("success","Student was deleted");
                    request.setAttribute("warning",null);
                    showDeleteStudent(request, response);
                }else{
                    response.sendRedirect("student");
                    request.setAttribute("error","Traded Student cannot be deleted");
                    request.setAttribute("success",null);
                    request.setAttribute("warning",null);
                }
            }
        }catch (NumberFormatException | ServletException ex){
            ex.getMessage();
            dis = request.getRequestDispatcher("error-404.jsp");
        }


    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        Student editStudent = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher;
        if (name == "" || email == "" || dob == "" || address == "") {
            request.setAttribute("success", null);
            request.setAttribute("error", "All field is required");
            showEditForm(request, response);
        } else {
            if (!CheckRegex.validateMail(email)) {
                request.setAttribute("success", null);
                request.setAttribute("error", "Invalid Value");
                listStudent(request, response);
            } else if (!CheckRegex.validateName(name)) {
                request.setAttribute("success", null);
                request.setAttribute("error", null);
                request.setAttribute("warning", "Invalid name value");
                showNewForm(request, response);
            } else if (!CheckRegex.validateMail(email)) {
                request.setAttribute("success", null);
                request.setAttribute("error", null);
                request.setAttribute("warning", "Invalid email value");
                showNewForm(request, response);
            } else if (!CheckRegex.validateDob(dob)) {
                request.setAttribute("success", null);
                request.setAttribute("error", null);
                request.setAttribute("warning", "Invalid date of birth value");
                showNewForm(request, response);
            } else {
                    editStudent.setId(id);
                    editStudent.setName(name);
                    editStudent.setEmail(email);
                    editStudent.setDob(dob);
                    editStudent.setAddress(address);
                    studentDAO.updateStudent(editStudent);
                    request.setAttribute("success", "Student was edit success!");
                    request.setAttribute("error", null);
                    showEditForm(request, response);
                }
            }
        }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        double ktbc = 0f;
        double kt15p = 0f;
        double kt45p = 0f;
        double kthk = 0f;
        boolean isDelete = false;

        if (name == "" || email == "" || dob == "" || address == "") {
            request.setAttribute("success", null);
            request.setAttribute("error", "All field is required");
            showNewForm(request, response);
        } else if (!CheckRegex.validateName(name)) {
            request.setAttribute("success", null);
            request.setAttribute("error", null);
            request.setAttribute("warning", "Invalid name value");
            showNewForm(request, response);
        } else if (!CheckRegex.validateMail(email)) {
            request.setAttribute("success", null);
            request.setAttribute("error", null);
            request.setAttribute("warning", "Invalid email value");
            showNewForm(request, response);
        } else if (!CheckRegex.validateDob(dob)) {
            request.setAttribute("success", null);
            request.setAttribute("error", null);
            request.setAttribute("warning", "Invalid date of birth value");
            showNewForm(request, response);
        } else {
            Student newStudent = new Student(name, email, dob, address, isDelete);
            studentDAO.insertStudent(newStudent);

            int id = studentDAO.selectIdStudent();
            mathDAO.insertMath(new Score(1, id, ktbc, kt15p, kt45p, kthk));

            request.setAttribute("success", "New student was created");
            request.setAttribute("error", null);
            request.setAttribute("warning", null);
            showNewForm(request, response);
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudents = studentDAO.selectAllStudent();
        request.setAttribute("listStudents", listStudents);
        RequestDispatcher dis = request.getRequestDispatcher("student/list.jsp");
        dis.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.selectStudent(id);
        request.setAttribute("student", existingStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }
}
