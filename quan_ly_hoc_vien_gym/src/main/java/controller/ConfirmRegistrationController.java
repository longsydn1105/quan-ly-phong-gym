package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Registration;
import model.dao.RegistrationDAO;

import java.io.IOException;

/**
 * Servlet implementation class ConfirmRegistrationController
 */
public class ConfirmRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmRegistrationController() {
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
	    
	    int userID = 1;
	    int classID = 4;
	    
	    Registration objRegis = new Registration(userID, classID);
	    RegistrationDAO regisDAO = new RegistrationDAO();
	    
	    
	    boolean check = regisDAO.addItem(objRegis);
	    
	    if(check ) {
	    	System.out.println("Đăng Ký lịch tập thành công");
	    }else {
	    	System.out.println("Đăng ký lịch tập thất bại");
	    }
	    
	}

}
