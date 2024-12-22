<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Thông Tin Người Dùng</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/edit-user.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/user-index.css">
<link rel="stylesheet" href="css/infor-user.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
	<div class="background"></div>
    <div class="container mt-5 form-group">
        <h2 class="text-center mb-4">Sửa Thông Tin Người Dùng</h2>
        <form action="UpdateUserServlet" method="post">
            <input type="hidden" name="userID" value="<%= request.getParameter("id") %>">
            <div class="mb-3">
                <label for="fullname" class="form-label">Họ và Tên</label>
                <input type="text" id="fullname" name="fullname" class="form-input" value="" required>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Số Điện Thoại</label>
                <input type="tel" id="phone" name="phone" class="form-input" value="" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email" class="form-input" value="" required>
            </div>
            <div class="text-center mt-4">
                <button type="submit" class="btn btn-success">Cập Nhật</button>
                <a href="user-index.jsp" class="btn btn-secondary">Quay Lại</a>
            </div>
        </form>
    </div>
</body>
</html>
