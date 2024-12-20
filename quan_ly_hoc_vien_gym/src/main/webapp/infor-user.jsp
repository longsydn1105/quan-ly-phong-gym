<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/user-index.css">
<link rel="stylesheet" href="css/infor-user.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM</title>
</head>
<body>
	<%
		User objUser = (User)request.getAttribute("objUser");
	%>
	<div class="background"></div>
    <div class="container mt-5 form-group">
        <h2 class="text-center mb-4">THÔNG TIN NGƯỜI DÙNG</h2>
        <form>
            <div class="mb-3">
                <label for="fullname" class="form-label">Họ và Tên</label>
                <input type="text" id="fullname" name="fullname" class="form-input" value="<%=objUser != null ? objUser.getFullName() : " " %>"  readonly>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Số Điện Thoại</label>
                <input type="tel" id="phone" name="phone" class="form-input" value="<%=objUser != null ? objUser.getPhone() : " " %>"  readonly>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email" class="form-input" value="<%=objUser != null ? objUser.getEmail() : " " %>"  readonly>
            </div>
            <div class="mb-3">
                <label for="registerDate" class="form-label">Ngày Đăng Ký</label>
                <input type="text" id="registerDate" name="registerDate" class="form-input" value="<%=objUser != null ? objUser.getCreateAt() : " " %>"  readonly>
            </div>
        </form>
    </div>
    <!-- Link Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>