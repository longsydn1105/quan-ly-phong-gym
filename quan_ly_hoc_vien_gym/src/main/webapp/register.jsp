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
        <h2 class="text-center" >Form Đăng Ký</h2>
        <form action="<%=request.getContextPath()%>/xac-nhan-dang-ky" method="POST" id="registerForm">
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

            <!-- Xác nhận mật khẩu -->
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Xác nhận mật khẩu</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                <div id="passwordError" class="text-danger" style="display: none;">Mật khẩu và xác nhận mật khẩu không khớp!</div>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <!-- Số điện thoại -->
            <div class="mb-3">
                <label for="phone" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="phone" name="phone" required>
            </div>
			
			 <!-- Thông báo đăng ký thành công -->
    		<div id="successMessage" class="mb-3" style="display: none; font-size: 20px; color: #48DE6F">
			  <!-- Thông báo đăng ký thành công sẽ được hiển thị ở đây -->
			</div>

            <!-- Nút đăng ký -->
            <button type="submit" class="btn btn-primary">Đăng ký</button>
        </form>
    </div>
    
    <script>
    // Kiểm tra mật khẩu và xác nhận mật khẩu có trùng khớp không
    const form = document.getElementById('registerForm');
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');
    const passwordError = document.getElementById('passwordError');
    const successMessage = document.getElementById('successMessage');

    form.addEventListener('submit', function(e) {
    	
        if (password.value !== confirmPassword.value) {
        	 e.preventDefault();	
            passwordError.style.display = 'block'; // Hiển thị lỗi
        } else {
            passwordError.style.display = 'none'; // Ẩn lỗi nếu mật khẩu trùng khớp
            // Hiển thị thông báo thành công và thay đổi màu sắc
            successMessage.style.display = 'block';
            successMessage.innerText = 'Đăng ký thành công!';  // Nội dung thông báo
        }
    });
	</script>

    
  	<!-- Mục thông tin liên hệ -->
	<div class="container contract">
		<div class="row d-lex justify-content-md-center align-items-center " >
			<div class=" col col-md-6 email-contract">
				<h4>EMAIL</h4>
				<p>longsydn1105@gmail.com</p>
			</div>
			<div class="col col-md-6">
				<h4>Số điện thoại</h4>
				<p>0705995857</p>
			</div>
		</div>	
	</div>


<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>