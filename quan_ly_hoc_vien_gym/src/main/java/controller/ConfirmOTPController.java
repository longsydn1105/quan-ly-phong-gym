package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.dao.UserDAO;

import java.io.IOException;

import javax.mail.Session;

/**
 * Servlet implementation class ConfirmOTPController
 */
public class ConfirmOTPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOTPController() {
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
	    
	    HttpSession session = request.getSession(false);
	    String userOTP = (String)request.getParameter("userOTP");
	    String OTP = (String)session.getAttribute("otp");
	    UserDAO userDAO = new UserDAO();
	    String url= "";
	    
	    System.out.println("mã xác thực đúng: " + OTP + " Và UserOTP: " + userOTP);
	    
	    //Xác thực OTP
	    if(OTP.equals(userOTP)) {
	    	System.out.println("Xác nhận OTP thành công");
	    	User objUser = (User)session.getAttribute("objUser");
	    	boolean check = userDAO.addUser(objUser);
	    	
	    	if(check) {
	    		System.out.println("Thêm User Thành Công");
	    		url = "/login.jsp";
	    	}else {
	    		System.out.println("Thêm User Thất bại");
	    		url = "/register.jsp";
	    		request.setAttribute("message", "Đăng ký thất bại, Có thể email đã được dùng");
	    	}
	    }else {
    		System.out.println("Nhập OTP thất bại");
    		url = "/register.jsp";
    		request.setAttribute("message", "Nhập OTP sai");
	    }
	    
	    if(session.getAttribute("adminID") != null) {
	    	url = "/Admin-Index";
	    	session.setAttribute("message", "Thêm người dùng thành công");
	    }
	    session.removeAttribute("otp");
	    session.removeAttribute("objUser");
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
