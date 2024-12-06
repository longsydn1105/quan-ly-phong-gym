package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.CheckTime;
import model.bean.Classes;
import model.dao.ClassesDAO;

import java.io.IOException;
import java.sql.Time;

/**
 * Servlet implementation class CreateClassController
 */
public class CreateClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClassController() {
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
	    
	    int roomID = Integer.parseInt(request.getParameter("roomID"));
	    int ptID = Integer.parseInt(request.getParameter("ptID"));
	    String className = request.getParameter("className");
	    String startTime = request.getParameter("startTime");
	    String endTime = request.getParameter("endTime");
	    String dateCreate = request.getParameter("dateCreate");
	    CheckTime checkTime = new CheckTime();
	    ClassesDAO classDAO = new ClassesDAO();
	    
	
        // Thêm ":00" vào cuối thời gian để chuyển thành định dạng hh:mm:ss
        String startTimeWithSeconds = startTime + ":00";
        String endTimeWithSeconds = endTime + ":00";
    
        //Check thòi gian bắt đầu có trước thời gian kết thúc không
	    if(checkTime.CheckEndTime(startTime, endTime, dateCreate)) {
	    	System.out.println("Thời gian hợp lệ");
	    }else {
	    	System.out.println("Thời gian không hợp lệ");
	    	request.setAttribute("error", "Thời gian bắt đầu phải trước thời gian kết thúc");
	    	request.getRequestDispatcher("/create-class.jsp").forward(request, response);
	    	return;
	    }
	    
	    
	    Classes objClass = new Classes(roomID, ptID, className, startTimeWithSeconds, endTimeWithSeconds, dateCreate);
	    
	    boolean confirmCreateClass = classDAO.addItem(objClass);
	    System.out.println("Giá trị của của confirm: " + confirmCreateClass);
	    if(confirmCreateClass) {
	    	System.out.println("Tạo lịch thành công");
	    	request.setAttribute("success", "Tạo lịch thành công");
	    	request.getRequestDispatcher("/create-class.jsp").forward(request, response);
	    } else {
	    	System.out.println("Tạo lịch thất bại");
	    	request.setAttribute("error", "Tạo lịch thất bại");
	    	request.getRequestDispatcher("/create-class.jsp").forward(request, response);
	    }
	    
	}

}
