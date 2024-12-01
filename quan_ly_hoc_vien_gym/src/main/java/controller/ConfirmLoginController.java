package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Hash;
import model.bean.User;
import model.dao.UserDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ConfirmLoginController
 */
public class ConfirmLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmLoginController() {
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
	    
	    UserDAO userDAO = new UserDAO();
	    Hash hash = new Hash();
	    StringBuilder sb = new StringBuilder();
	    
	    ArrayList<User> listUser = userDAO.getItems();
	    String phone = "0705995857";
	    String passWord = "123123";
	    
	    sb.append(hash.hashPassword(passWord));
	    
	    String hashPass = sb.toString();
	    for(User objUser : listUser) {
	    	if(phone.equals(objUser.getPhone()) && hashPass.equals(objUser.getPassword())) {
	    		System.out.print("Đăng nhập thành công");
	    	}else {
	    		System.out.print("Đăng nhập thất bại");
	    	}
	    }
	    
	}

}
