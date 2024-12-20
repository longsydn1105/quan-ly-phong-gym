<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    <th>THAO TÁC</th>
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
                    <td>
                        <button onclick="window.location.href='<%=request.getContextPath()%>/user-update.jsp?idUser=<%=objUser.getUserID()%>'" class="btn btn-primary btn-sm">SỬA</button>
                        <button onclick="confirmDelete(<%=objUser.getUserID()%>)" class="btn btn-danger btn-sm">XÓA</button>
                    </td>
                </tr>
         	<%}} %>
         	
            </tbody>
        </table>
        <div class="text-center mt-4">
            <button onclick="window.location.href='<%=request.getContextPath()%>/register.jsp'" class="btn btn-success">Thêm Người Dùng</button>
        </div>
    </div>
    
    <script type="text/javascript">
	    function confirmDelete(idUser) {
	        // Hiển thị hộp thoại xác nhận
	        if (confirm("Bạn có chắc chắn muốn xóa người dùng này?")) {
	            // Nếu người dùng xác nhận, chuyển hướng tới trang xóa với idUser
	            window.location.href = "<%=request.getContextPath()%>/xoa-nguoi-dung?idUser=" + idUser;
	        }
	    }
	</script>
</body>

</html>