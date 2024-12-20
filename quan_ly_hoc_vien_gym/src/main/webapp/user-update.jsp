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
<link rel="stylesheet" href="css/user-update.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
	<div class="background " id="bgr"></div>
    <div class="container mt-5">
    	<%
    		UserDAO userDAO = new UserDAO();
    		int idUser = Integer.parseInt(request.getParameter("idUser"));
    		User objUser = userDAO.getItemByID(idUser);
    	%>
        <h2 class="text-center">Sửa thông tin người dùng</h2>
        <form action="<%=request.getContextPath()%>/chinh-sua-nguoi-dung?idUser=<%=objUser.getUserID()%>" method="POST" class="form-edit mt-4">
            <div class="mb-3">
                <label for="fullname" class="form-label">Họ tên</label>
                <input type="text" class="form-control" id="fullname" name="fullname" value="<%= (objUser != null) ? objUser.getFullName() : "" %>">
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">SĐT</label>
                <input type="text" class="form-control" id="phone" name="phone"  value="<%= (objUser != null) ? objUser.getPhone() : "" %>">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= (objUser != null) ? objUser.getEmail() : "" %>" readonly>
            </div>
            <div class="d-flex justify-content-between mt-4">
                <button onclick="confirmDelete(<%=objUser.getUserID()%>)" type="button" class="btn btn-danger">Xóa</button>
                <button type="submit" class="btn btn-primary">Lưu</button>
            </div>
        </form>
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
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>