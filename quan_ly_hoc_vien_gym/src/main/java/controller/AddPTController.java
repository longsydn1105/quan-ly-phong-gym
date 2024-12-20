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
 * Servlet implementation class AddPTController
 */
public class AddPTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPTController() {
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
		PTDAO ptDAO = new PTDAO();
		
		String fullName = (String)request.getParameter("fullname");
		String phone = (String)request.getParameter("phone");
		String email = (String)request.getParameter("email");
		
		PT objPT = new PT(fullName, email, phone);
		System.out.println(objPT.getFullName());
		HttpSession session = request.getSession();
		//Thêm hàm check mail 
		boolean check = ptDAO.addPT(objPT);
		
		if(check) {
			System.out.println("Thêm PT thành công");
			session.setAttribute("message", "Thêm PT thành công");
		}else {
			System.out.println("Thêm PT thất bại");
			session.setAttribute("message", "Thêm PT thất bại, có thể email đã được dùng");
		}
		
		request.getRequestDispatcher("/Admin-Index").forward(request, response);
	}

}
