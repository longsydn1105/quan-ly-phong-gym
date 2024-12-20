package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Classes;
import model.dao.ClassesDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ListCalendarController
 */
public class ListCalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCalendarController() {
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
		ClassesDAO classDAO = new ClassesDAO();
		
		ArrayList<Classes> listClass = classDAO.getItemsUpComing();
		
		request.setAttribute("listClass", listClass);
		request.getRequestDispatcher("/admin-calendar-category.jsp").forward(request, response);
	}

}
