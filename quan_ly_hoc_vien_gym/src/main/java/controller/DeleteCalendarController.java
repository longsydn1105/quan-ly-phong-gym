package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.ClassesDAO;

import java.io.IOException;

/**
 * Servlet implementation class DeleteCalendarController
 */
public class DeleteCalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCalendarController() {
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
		int idCal = Integer.parseInt(request.getParameter("idcal"));
		
		ClassesDAO classDAO = new ClassesDAO();
		
		boolean check = classDAO.DeleteClassByID(idCal);
		HttpSession session = request.getSession();
		if(check) {
			System.out.println("xoá lịch thành công");
			session.setAttribute("message", "Xoá lịch thành công");
		}else {
			System.out.println("xoá lịch thất bại");
			session.setAttribute("message", "Xoá lịch thất bại");
		}
		request.getRequestDispatcher("/Admin-Index").forward(request, response);
	}

}
