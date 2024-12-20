<%@page import="model.bean.User"%>
<%@page import="model.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/user-index.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
<body>
	<% 
	String message = (String) session.getAttribute("message");
	int idLogin = Integer.parseInt(session.getAttribute("idLogin").toString());
	UserDAO userDAO = new UserDAO();
	User objUser = userDAO.getItemByID(idLogin);
	    if (message != null) {
	        session.removeAttribute("message");
	    
	%>
		<script type="text/javascript">
        	alert("<%= message %>");
   		</script>
	<%} %>
	
	<div class="background"></div>
	<header>
		<div>
			<button onclick="window.location.href='<%=request.getContextPath()%>/nguoi-dung-thoat'" class="logout-btn">Đăng xuất</button>
		</div>
	</header>
	<div class="userName">
		<h4><%= objUser != null ? objUser.getFullName() : " " %></h4>
	</div>
	<div class="center-container">
	   <button onclick="window.location.href='<%=request.getContextPath()%>/thong-tin-nguoi-dung'" class="btn btn-primary btn-rounded">Thông tin</button>
	   <button onclick="window.location.href='<%=request.getContextPath()%>/danh-sach-lich-tap-cua-nguoi-dung'"  class="btn btn-success btn-rounded">Xem lịch tập</button>
	   <button onclick="window.location.href='<%=request.getContextPath()%>/celendar.jsp'" class="btn btn-warning btn-rounded">Đăng ký lịch tập</button>
	</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>