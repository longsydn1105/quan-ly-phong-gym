package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Classes;
import model.dao.ClassesDAO;

import java.io.IOException;

/**
 * Servlet implementation class AdminCalendarDetailController
 */

public class AdminCalendarDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCalendarDetailController() {
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
		int idClass = Integer.parseInt(request.getParameter("classId"));
		
		ClassesDAO classDAO = new ClassesDAO();
		Classes objClass = classDAO.getClassByID(idClass);
		
		request.setAttribute("objClass", objClass);
		
		request.getRequestDispatcher("/admin-calendar-detail.jsp").forward(request, response);
	}

}
