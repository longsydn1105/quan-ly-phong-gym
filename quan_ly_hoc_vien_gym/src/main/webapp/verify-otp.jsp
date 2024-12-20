<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/register.css" >
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

	  <!-- Navigation -->
	  <nav>
	    <ul class="nav">
	      <li class="nav-item"><a href="#" class="nav-link">Trang chủ</a></li>
	      <li class="nav-item dropdown">
		      <a href="#" class="nav-link dropdown-toggle" id="servicesMenu" data-bs-toggle="dropdown">Dịch vụ</a>
		      <ul class="dropdown-menu" aria-labelledby="servicesMenu">
		        <li><a class="dropdown-item" href="#">Dịch vụ 1</a></li>
		        <li><a class="dropdown-item" href="#">Dịch vụ 2</a></li>
		        <li><a class="dropdown-item" href="#">Dịch vụ 3</a></li>
		      </ul>
	      </li>
	
	      <li class="nav-item"><a href="#" class="nav-link">Liên hệ</a></li>
	    </ul>
	  </nav>
	
	  <!-- Nút Đăng nhập-->
	  <button class="btn btn-login" onclick="window.location.href='<%=request.getContextPath()%>/login.jsp'">Đăng nhập</button>
	</header>

	<!-- Form đăng ký -->
	<div class="container mt-5  registerForm">
        <h2 class="text-center" >XÁC THỰC BƯỚC 2</h2>
        <form action="<%=request.getContextPath()%>/confirm-OTP" method="POST" id="registerForm">
            <!-- NHẬP OTP -->
            <div class="mb-3">
                <label for="OTP" class="form-label">MÃ XÁC THỰC OTP</label>
                <input type="text" class="form-control" id="userOTP" name="userOTP" required>
            </div>
            <button type="submit" class="btn btn-primary">Xác nhận</button>
        </form>
    </div>
</body>
</html>