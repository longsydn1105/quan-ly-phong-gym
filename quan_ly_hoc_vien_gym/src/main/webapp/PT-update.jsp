<%@page import="model.bean.PT"%>
<%@page import="model.dao.PTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/PT-update.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
	<%
		PTDAO ptDAO = new PTDAO();
		int ptID = Integer.parseInt(request.getParameter("ptID"));
		PT objPT = ptDAO.getItemByID(ptID);
	%>
	<div class="background " id="bgr"></div>
    <div class="container mt-5">
        <h2 class="text-center">Sửa thông tin PT</h2>
        <form action="<%=request.getContextPath()%>/chinh-sua-pt?ptID=<%=objPT.getPtId() %>" method="POST"class="form-edit mt-4">
            <div class="mb-3">
                <label for="fullname" class="form-label">Họ tên</label>
                <input name="fullname" type="text" class="form-control" id="fullname" value="<%= (objPT != null) ? objPT.getFullName() : "" %>">
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">SĐT</label>
                <input  name="phone" type="text" class="form-control" id="phone" value="<%= (objPT != null) ? objPT.getPhone() : "" %>">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email"  type="email" class="form-control" id="email" value="<%= (objPT != null) ? objPT.getEmail() : "" %>" readonly>
            </div>
            <div class="d-flex justify-content-between mt-4">
                <button onclick="confirmDelete(<%=objPT.getPtId()%>)" type="button" class="btn btn-danger">Xóa</button>
                <button type="submit" class="btn btn-primary">Lưu</button>
            </div>
        </form>
    </div>
    <script type="text/javascript">
	    function confirmDelete(idPT) {
	        // Hiển thị hộp thoại xác nhận
	        if (confirm("Bạn có chắc chắn muốn xóa PT này?")) {
	            window.location.href = "<%=request.getContextPath()%>/xoa-pt?idPT=" + idPT;
	        }
	    }
	</script>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>