package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
	    
	    String url = "";
	    UserDAO userDAO = new UserDAO();
	    Hash hash = new Hash();
	    StringBuilder sb = new StringBuilder();
	    String email = (String)request.getParameter("email");
	    String pass = (String)request.getParameter("password");
	    HttpSession session = request.getSession();
	    ArrayList<User> listUser = userDAO.getItems();
	    
	    sb.append(hash.hashPassword(pass));
	    int idLogin = 0;
	    boolean checkLogin = false;
	    String hashPass = sb.toString();
	    for(User objUser : listUser) {
	    	if(email.equals(objUser.getEmail()) && hashPass.equals(objUser.getPassword())) {
	    		System.out.println("Đăng nhập thành công");
	    		checkLogin = true;
	    		idLogin = objUser.getUserID();
	    		
	    	}
	    }
	    
	    // Phân quyền khi đăng nhập nhập tài khoản là Admin
	    if(!checkLogin) {
	    	System.out.println("Đăng nhập thât bại");
	    	session.setAttribute("message", "Sai mật khẩu hoặc tài khoản");
	    	url = "/login.jsp";
	    }else {
	    	if(userDAO.getItemByID(idLogin).getRole().equals("Admin")) {
	    		url = "/Admin-Index";
	    		session.setAttribute("message", "Chào mừng admin");
	    	}else {
	    		session.setAttribute("message", "Chào mừng " + userDAO.getItemByID(idLogin).getFullName());
	    		url = "/user-index.jsp";
	    	}
	    }
	    session.setAttribute("idLogin",idLogin);
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
