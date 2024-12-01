<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/login.css" >
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
<!-- Thanh Logo -->
    <header class="d-flex justify-content-between align-items-center p-2 ">
	  <!-- Logo -->
	  <div class="logo">
	    <img src="img/Logo_Gym.png" alt="Logo" style="height:100px;width:150%;">
	  </div>

	</header>
	
	<!-- Form đăng nhập -->
	<div class="container mt-5  loginForm">
        <h2 class="text-center" >Form Đăng Nhập</h2>
        <form action="<%=request.getContextPath()%>/xac-nhan-dang-nhap" method="POST" id="loginForm">
            <!-- Tên đăng nhập -->
            <div class="mb-3">
                <label for="username" class="form-label">Tên đăng nhập</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>

            <!-- Mật khẩu -->
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <!-- Nút đăng nhập -->
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
            
        </form>
     </div>
</body>
</html>