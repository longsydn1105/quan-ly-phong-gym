<%@page import="model.dao.PTDAO"%>
<%@page import="model.dao.RoomDAO"%>
<%@page import="model.bean.Classes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ADMIN LH GYM</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/admin-calendar-detail.css">
</head>
<body class="bg-dark text-light">
	<div class="background"></div>
    <div class="container mt-5">
        <div class="card shadow-lg bg-secondary">
            <div class="card-header text-center bg-primary text-light">
                <h3>Thông Tin Lớp Tập</h3>
            </div>
            <%
            	RoomDAO roomDAO = new RoomDAO();
            	PTDAO ptDAO = new PTDAO();
            	Classes objClass = (Classes)request.getAttribute("objClass");
            %>
            <div class="card-body">
                <div class="row mb-3">
                    <div class="col-4"><strong>Phòng:</strong></div>
                    <div class="col-8"><%= objClass != null ? roomDAO.getItemByID(objClass.getRoomId()).getRoomName() : "Không có thông tin" %></div>
                </div>
                <div class="row mb-3">
                    <div class="col-4"><strong>PT:</strong></div>
                    <div class="col-8"><%= objClass != null ? ptDAO.getItemByID(objClass.getPtId()).getFullName() : "Không có thông tin" %></div>
                </div>
                <div class="row mb-3">
                    <div class="col-4"><strong>Giờ Bắt Đầu:</strong></div>
                    <div class="col-8"><%= objClass != null ? objClass.getStartTime() : "" %></div>
                </div>
                <div class="row mb-3">
                    <div class="col-4"><strong>Giờ Kết Thúc:</strong></div>
                    <div class="col-8"><%= objClass != null ? objClass.getEndTime() : "" %></div>
                </div>
                <div class="row mb-3">
                    <div class="col-4"><strong>Ngày:</strong></div>
                    <div class="col-8"><%= objClass != null ? objClass.getDateCreate() : "" %></div>
                </div>
                <div class="row mb-3">
                    <div class="col-4"><strong>Số Lượng Đăng Ký:</strong></div>
                    <div class="col-8">15</div>
                </div>
                <div class="card-footer d-flex justify-content-between">
	                <button id="deleteBtn" class="btn btn-danger">Xoá Lịch</button>
	                <script>
					    document.getElementById("deleteBtn").addEventListener("click", function (event) {
			
					        const userConfirmed = confirm("Bạn có chắc chắn muốn xóa lịch này không?");
					        
					        if (userConfirmed) {
					            window.location.href="./xoa-lich?idcal=<%=objClass.getClassId()%>"; 
					        } else {
					            event.preventDefault();
					        }
					    });
					</script>
	                <button onclick="window.location.href='<%=request.getContextPath()%>/admin-lich-tap-cua-nguoi-dung?idClass=<%=objClass.getClassId() %>'" class="btn btn-success">Xem Hội Viên Đăng Ký</button>
           		</div>
            </div>
            
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>