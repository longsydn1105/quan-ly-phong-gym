package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.dao.UserDAO;

import java.io.IOException;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getSession().getAttribute("idLogin").toString());
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // Cập nhật thông tin người dùng
        UserDAO userDAO = new UserDAO();
        User updatedUser = new User(userId, fullName, email, phone);
        
        boolean isUpdated = userDAO.UpdateItem(updatedUser);

        if (isUpdated) {
            response.sendRedirect("infor-user.jsp");
        } else {
            request.setAttribute("message", "Cập nhật thông tin thất bại!");
            request.getRequestDispatcher("edit-user.jsp").forward(request, response);
        }
//        // Điều hướng trở lại trang thông tin người dùng
//        request.setAttribute("objUser", updatedUser);
//        request.getRequestDispatcher("/user-profile.jsp").forward(request, response);
	}

}
