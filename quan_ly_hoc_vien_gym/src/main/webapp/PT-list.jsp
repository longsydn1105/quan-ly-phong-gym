<%@page import="model.bean.PT"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/PT-list.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
	<div class="background"></div>
    <div class="container mt-5">
        <h2 class="text-center mb-4">THÔNG TIN PT</h2>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>STT</th>
                    <th>Họ và tên</th>
                    <th>SĐT</th>
                    <th>Email</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <%
            	if(request.getAttribute("listPT") != null) {
            		ArrayList<PT> listPT = (ArrayList<PT>)request.getAttribute("listPT");
            		int count = 0;
            		for(PT objPT : listPT) {
            			count++;
            		
            	%>
                <tr>
                    <td><%=count %></td>
                    <td><%=objPT.getFullName() %></td>
                    <td><%=objPT.getPhone() %></td>
                    <td><%=objPT.getEmail() %></td>
                    <td>
                        <button onclick="window.location.href='<%=request.getContextPath()%>/PT-update.jsp?ptID=<%=objPT.getPtId()%>'" class="btn btn-primary btn-sm">SỬA</button>
                        <button onclick="confirmDelete(<%=objPT.getPtId()%>)" class="btn btn-danger btn-sm">XÓA</button>
                    </td>
                </tr>
         	<%}} %>
            </tbody>
        </table>
        <div class="text-center mt-4">
            <button  onclick="window.location.href='<%=request.getContextPath()%>/PT-add.jsp'" class="btn btn-success">Thêm PT</button>
        </div>
    </div>
    <script type="text/javascript">
	    function confirmDelete(idPT) {
	        // Hiển thị hộp thoại xác nhận
	        if (confirm("Bạn có chắc chắn muốn xóa PT này?")) {
	            window.location.href = "<%=request.getContextPath()%>/xoa-pt?idPT=" + idPT;
	        }
	    }
	</script>
</body>
</html>