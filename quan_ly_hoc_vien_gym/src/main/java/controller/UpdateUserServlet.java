package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userId = Integer.parseInt(request.getParameter("id").toString());
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        System.out.println("Tên người dùng: " + fullName);
        // Cập nhật thông tin người dùng
        UserDAO userDAO = new UserDAO();
        User updatedUser = new User(userId, fullName, email, phone);
        
        boolean isUpdated = userDAO.UpdateItem(updatedUser);
        HttpSession session = request.getSession();
        if (isUpdated) {
        	System.out.println("Cập nhập thông tin người dùng thành công");
        	session.setAttribute("message", "Cập nhật thông tin thành công!");
            request.getRequestDispatcher("/user-index.jsp").forward(request, response);

        } else {
        	System.out.println("Cập nhập thông tin người dùng thất bại");
            session.setAttribute("message", "Cập nhật thông tin thất bại!");
            request.getRequestDispatcher("/user-index.jsp").forward(request, response);
        }
//        // Điều hướng trở lại trang thông tin người dùng
//        request.setAttribute("objUser", updatedUser);
//        request.getRequestDispatcher("/user-profile.jsp").forward(request, response);
	}

}
