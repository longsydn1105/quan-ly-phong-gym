package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.User;
import model.dao.UserDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class AdminListUserOfClassController
 */
public class AdminListUserOfClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListUserOfClassController() {
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
		int idClass = Integer.parseInt(request.getParameter("idClass"));
		UserDAO userDAO = new UserDAO();
		ArrayList<User> listUser = userDAO.getUserByIDClass(idClass);
		for(User objUser : listUser) {
			System.out.println("Người dùng: "+objUser.getFullName());
		}
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/admin-ListUserOfClass.jsp").forward(request, response);
	}

}
