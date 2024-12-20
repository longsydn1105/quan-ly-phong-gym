<%@page import="model.bean.Classes"%>
<%@page import="model.bean.User"%>
<%@page import="model.bean.PT"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ClassesDAO"%>
<%@page import="model.dao.PTDAO"%>
<%@page import="model.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/admin-index.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<title>ADMIN LH GYM</title>
</head>
<body>
	<%
		UserDAO userDAO = new UserDAO();
		PTDAO ptDAO = new PTDAO();
		ClassesDAO classesDAO =  new ClassesDAO();
		
		ArrayList<User> listUser = userDAO.getItems();
		ArrayList<PT> listPT = ptDAO.getItems();
		ArrayList<Classes> listClass= classesDAO.getItems();
		
	    String message = (String) session.getAttribute("message");

	    
	    if (message != null) {
	        session.removeAttribute("message");
	    
	%>
		<script type="text/javascript">
        	alert("<%= message %>");
   		</script>
	<%} %>
	<div class="background " id="bgr"></div>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <nav class="col-md-2 d-none d-md-block sidebar">
                <div class="sidebar-sticky">
                    <h5 class="text-center mt-3">ADMIN</h5>
                    <ul class="nav flex-column mt-4">
                        <li class="nav-item">
                            <a class="nav-link active" href="<%=request.getContextPath()%>/ListUser">Danh Sách Học Viên</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/danh-sach-pt">Danh Sách PT</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/danh-sach-lich-tap">Danh Sách Lịch Tập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/create-class.jsp">Tạo Lịch Tập Mới</a>
                        </li>
                    </ul>
                </div>
            </nav>
            			
            <!-- Main content -->
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 main-content">
            	<div>
            		<button class="logout-btn" onclick="window.location.href='<%=request.getContextPath()%>/admin-dang-xuat'">Đăng xuất</button>
            	</div>
                <div class="pt-3 pb-2 mb-3 border-bottom">
                    <h2>Quản Lý Phòng Gym</h2>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title">Số lượng học viên hiện tại</h5>
                                <p class="card-text display-6 text-primary"><%=listUser.size()%></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title">Số PT hiện tại</h5>
                                <p class="card-text display-6 text-success"><%=listPT.size() %></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title">Số Lớp học trong tuần</h5>
                                <p class="card-text display-6 text-warning"><%=listClass.size() %></p>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>