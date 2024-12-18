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
import java.util.Scanner;

/**
 * Servlet implementation class ConfirmRegisterController
 */
public class ConfirmRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmRegisterController() {
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
	    
	    /**
	    String userName = request.getParameter("username");
	    String passWord = request.getParameter("password");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    */
	    
	    String fullName = "Trịnh Ngọc Hưng";
	    String passWord = "321321";
	    String email = "ngochung@gmail.com";
	    String phone = "0901234567";
	    
	    UserDAO userDAO = new UserDAO();
	    Hash hash = new Hash();
	    StringBuilder sb = new StringBuilder();


	    // Thêm giá trị băm vào StringBuilder
	    sb.append(hash.hashPassword(passWord));

	    
	    // Chuyển đổi sang String
	    String hashPass = sb.toString();
	    
	    User objUser = new User(fullName,email,hashPass,phone);
	    boolean confirmRegister = userDAO.addUser(objUser);
	    
	    if(confirmRegister) {
	    	request.getRequestDispatcher("/login.jsp").forward(request, response);
	    	System.out.println("Đăng ký thành công");
	    }

	}

}
