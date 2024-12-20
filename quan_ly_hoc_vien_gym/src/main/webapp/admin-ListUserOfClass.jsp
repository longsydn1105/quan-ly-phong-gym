<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/user-list.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
	<div class="background"></div>
    <div class="container mt-5">
        <h2 class="text-center mb-4">DANH SÁCH NGƯỜI DÙNG</h2>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>STT</th>
                    <th>HỌ VÀ TÊN</th>
                    <th>SĐT</th>
                    <th>EMAIL</th>
                </tr>
            </thead>
            <tbody>
            <%
            	if(request.getAttribute("listUser") != null) {
            		ArrayList<User> listUser = (ArrayList<User>)request.getAttribute("listUser");
            		int count = 0;
            		for(User objUser : listUser) {
            			count++;
            		
            %>
                <tr>
                    <td><%=count %></td>
                    <td><%=objUser.getFullName() %></td>
                    <td><%=objUser.getPhone() %></td>
                    <td><%=objUser.getEmail() %></td>
                </tr>
         	<%}} %>
         	
            </tbody>
        </table>
    </div>
</body>

</html>