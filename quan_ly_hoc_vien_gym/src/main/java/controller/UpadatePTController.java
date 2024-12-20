package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.PT;
import model.dao.PTDAO;

import java.io.IOException;

/**
 * Servlet implementation class UpadatePTController
 */
public class UpadatePTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpadatePTController() {
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
		PTDAO ptDAO = new PTDAO();
		
		int ptID = Integer.parseInt(request.getParameter("ptID"));
		String fullName = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		PT objPT = new PT(ptID, fullName, email, phone);
		
		boolean check = ptDAO.UpdateItem(objPT);
		
		HttpSession session = request.getSession();
	    
	    if(check) {
	    	System.out.println("Update thành công");
	    	session.setAttribute("message", "Cập nhật PT thành công!");
	    }else {
	    	System.out.println("Update thất bại");
	    	session.setAttribute("message", "Cập nhật PT thất bại!");
	    }
	    request.getRequestDispatcher("/Admin-Index").forward(request, response);
	}

}
