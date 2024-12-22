<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa Tài Khoản</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4 text-danger">Xác Nhận Xóa Tài Khoản</h2>
        <p class="text-center">Bạn có chắc chắn muốn xóa tài khoản này không?</p>
        <div class="text-center mt-4">
            <form action="DeleteUserServlet" method="post">
                <input type="hidden" name="userID" value="<%=request.getParameter("id")%>">
                <button type="submit" class="btn btn-danger">Xóa</button>
                <a href="user-index.jsp" class="btn btn-secondary">Hủy</a>
            </form>
        </div>
    </div>
</body>
</html>
