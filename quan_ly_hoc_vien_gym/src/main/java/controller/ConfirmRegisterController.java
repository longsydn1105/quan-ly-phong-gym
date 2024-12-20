package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.EmailService;
import model.bean.Hash;
import model.bean.OTPService;
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
	    

	    String userName = request.getParameter("username");
	    String passWord = request.getParameter("password");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
  
	    Hash hash = new Hash();
	    StringBuilder sb = new StringBuilder();
	    EmailService emailService = new EmailService();


	    // Thêm giá trị băm vào StringBuilder
	    sb.append(hash.hashPassword(passWord));

	    
	    // Chuyển đổi sang String
	    String hashPass = sb.toString();
	    
	    User objUser = new User(userName, email, hashPass, phone);
	    
        try {
            // Tạo mã OTP
            String otp = OTPService.generateOTP();

            // Gửi mã OTP qua email
            System.out.println("Đang ở bước send mail");
            emailService.sendEmail(email, otp);

            // Lưu mã OTP vào session để so sánh sau này
            HttpSession session = request.getSession();
            session.setAttribute("otp", otp);
            session.setAttribute("objUser", objUser);

            request.getRequestDispatcher("/verify-otp.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
