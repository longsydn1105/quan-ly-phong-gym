package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDAO;

import java.io.IOException;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		 int userID = Integer.parseInt(request.getParameter("userID"));
	        UserDAO userDAO = new UserDAO();

	        boolean success = userDAO.DeleteItem(userID);

	        if (success) {
	            request.getSession().setAttribute("message", "Xóa tài khoản thành công!");
	            response.sendRedirect("index.jsp"); // Điều hướng đến danh sách người dùng
	        } else {
	            request.getSession().setAttribute("message", "Xóa tài khoản thất bại!");
	            response.sendRedirect("infor-user.jsp");
	        }
		doGet(request, response);
	}

}
