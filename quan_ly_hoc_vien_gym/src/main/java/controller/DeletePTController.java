package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.PTDAO;
import model.dao.UserDAO;

import java.io.IOException;

/**
 * Servlet implementation class DeletePTController
 */
public class DeletePTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePTController() {
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
		response.setContentType("text/html; charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    PTDAO ptDAO = new PTDAO();
	    
	    int idPT = Integer.parseInt(request.getParameter("idPT"));
	    System.out.print(idPT);
	    boolean check = ptDAO.DeleteItem(idPT);
	    HttpSession session = request.getSession();
	    if(check) {
	    	System.out.println("Xóa thành công");
	    	session.setAttribute("message", "Xoá PT thành công");
	    }else {
	    	System.out.println("Xóa thất bại");
	    	session.setAttribute("message", "Xoá PT thất bại");
	    }
	    
	    request.getRequestDispatcher("/Admin-Index").forward(request, response);
	}

}
