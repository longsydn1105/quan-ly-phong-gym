package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Registration;
import model.dao.RegistrationDAO;

import java.io.IOException;

/**
 * Servlet implementation class UserDeleteCalendarController
 */
public class UserDeleteCalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteCalendarController() {
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
		HttpSession session = request.getSession(false);
		int userID = Integer.parseInt(session.getAttribute("idLogin").toString());
		int classID = Integer.parseInt(request.getParameter("classId"));
		
		RegistrationDAO regisDAO = new RegistrationDAO();
		Registration objRegis = new Registration(userID, classID);
		boolean check = regisDAO.deleteRegistrationByClassID(objRegis);
		
		if(check ) {
	    	System.out.println("Xoá lịch tập thành công");
	    	session.setAttribute("message", "Xoá lịch tập thành công");
	    }else {
	    	System.out.println("Xoá lịch tập thất bại");
	    	session.setAttribute("message", "Xoá lịch tập thất bại");
	    }
	    request.getRequestDispatcher("/user-index.jsp").forward(request, response);
	}

}
