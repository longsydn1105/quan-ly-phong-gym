<%@page import="model.bean.PT"%>
<%@page import="model.dao.PTDAO"%>
<%@page import="model.bean.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.RoomDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LH GYM</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/create-class.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
	<div class="background " id="bgr"></div>
	<%
		RoomDAO roomDAO = new RoomDAO();
		ArrayList<Room> listRoom = roomDAO.getItems();
		PTDAO ptDAO = new PTDAO();
		ArrayList<PT> listPT = ptDAO.getItems();
	%>
    <div class="container mt-5">
        <h1 class="text-center ">TẠO LỊCH TẬP</h1>
        <form action="<%=request.getContextPath()%>/tao-lich" method="post" class="mt-4">
            <div class="mb-3">
                <label for="roomID" class="form-label">Phòng:</label>
                <select name="roomID" id="roomID" class="form-select" required>
                    <%
                    	if(listRoom != null) {
                    		for(Room objRoom : listRoom) {
                    %>
                    			<option value="<%=objRoom.getRoomId()%>"><%=objRoom.getRoomName()%></option>
                    <%
                    		}
                    	}
                    %>
                </select>
            </div>

            <div class="mb-3">
                <label for="ptID" class="form-label">Huấn luyện viên:</label>
                <select name="ptID" id="ptID" class="form-select" required>
                    <%
                    	if(listPT != null) {
                    		for(PT objPT : listPT) {
                    %>
                    			<option value="<%=objPT.getPtId()%>"><%=objPT.getFullName()%></option>
                    <%
                    		}
                    	}
                    %>
                </select>
            </div>

            <div class="mb-3">
                <label for="className" class="form-label">Lớp:</label>
                <select name="className" id="className" class="form-select" required>
                    <option value="Gym">Gym</option>
                    <option value="Yoga">Yoga</option>
                    <option value="Cadio">Cadio</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="startTime" class="form-label">Thời gian bắt đầu:</label>
                <select name="startTime" id="startTime" class="form-select" required>
                    <option value="08:00">08:00</option>
                    <option value="10:00">10:00</option>
                    <option value="14:00">14:00</option>
                    <option value="16:00">16:00</option>
                    <option value="18:00">18:00</option>
                    <option value="20:00">20:00</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="endTime" class="form-label">Thời gian kết thúc:</label>
                <select name="endTime" id="endTime" class="form-select" required>
                    <option value="10:00">10:00</option>
                    <option value="12:00">12:00</option>
                    <option value="16:00">16:00</option>
                    <option value="18:00">18:00</option>
                    <option value="20:00">20:00</option>
                    <option value="22:00">22:00</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="dateCreate" class="form-label">Ngày tạo:</label>
                <input type="date" id="dateCreate" name="dateCreate" class="form-control" required>
            </div>

            <script>
                const startTimeSelect = document.getElementById("startTime");
                const endTimeSelect = document.getElementById("endTime");

                function updateEndTime() {
                    const startTime = startTimeSelect.value;
                    const [hours, minutes] = startTime.split(":").map(Number);
                    const endHours = hours + 2;
                    const endTime = (endHours < 10 ? "0" : "") + endHours + ":" + (minutes < 10 ? "0" : "") + minutes;

                    Array.from(endTimeSelect.options).forEach(option => {
                        if (option.value === endTime) {
                            endTimeSelect.value = endTime;
                        }
                    });
                }

                startTimeSelect.addEventListener("change", updateEndTime);
                updateEndTime();
                endTimeSelect.addEventListener("mousedown", (e) => e.preventDefault());

                const today = new Date();
                const formattedDate = today.toISOString().split("T")[0];
                const dateInput = document.getElementById("dateCreate");
                dateInput.value = formattedDate;
                dateInput.min = formattedDate;
            </script>

            <button type="submit" class="btn btn-primary w-100">Tạo Lớp</button>
            
            <div class="mt-3">
                <% if(request.getAttribute("error") != null) { %>
                    <p class="text-danger"><%=request.getAttribute("error")%></p>
                <% } %>
                <% if(request.getAttribute("success") != null) { %>
                    <p class="text-success"><%=request.getAttribute("success")%></p>
                <% } %>
            </div>
        </form>
    </div>
</body>
</html>