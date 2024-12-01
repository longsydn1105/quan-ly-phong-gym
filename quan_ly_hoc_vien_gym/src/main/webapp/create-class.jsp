<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LH GYM</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
	<form action="CreateClassServlet" method="post">
    <label for="roomID">Phòng:</label>
    <select name="roomID" id="roomID" required>
        <!-- Các RoomID sẽ được lấy từ Servlet hoặc cơ sở dữ liệu -->
        <option value="1">Phòng 1</option>
        <option value="2">Phòng 2</option>
        <!-- ... -->
    </select>
    <br>

    <label for="ptID">Huấn luyện viên:</label>
    <select name="ptID" id="ptID" required>
        <!-- PTID được lấy từ Servlet -->
        <option value="1">PT 1</option>
        <option value="2">PT 2</option>
        <!-- ... -->
    </select>
    <br>

    <label for="className">Lớp:</label>
    <select name="className" id="className" required>
        <option value="Gym">Gym</option>
        <option value="Yoga">Yoga</option>
        <option value="Cadio">Cadio</option>
    </select>
    <br>

    <label for="startTime">Thời gian bắt đầu:</label>
    <select name="startTime" id="startTime" required>
        <option value="08:00">08:00</option>
        <option value="10:00">10:00</option>
        <option value="14:00">14:00</option>
        <option value="16:00">16:00</option>
        <option value="18:00">18:00</option>
        <option value="20:00">20:00</option>
    </select>
    <br>

    <label for="endTime">Thời gian kết thúc:</label>
    <select name="endTime" id="endTime" required>
        <option value="10:00">10:00</option>
        <option value="12:00">12:00</option>
        <option value="16:00">16:00</option>
        <option value="18:00">18:00</option>
        <option value="20:00">20:00</option>
        <option value="22:00">22:00</option>
    </select>
    <br>

    <label for="dateCreate">Ngày tạo:</label>
    <input type="datetime-local" name="dateCreate" id="dateCreate" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(new java.util.Date()) %>" readonly>
    <br>

    <button type="submit">Tạo Lớp</button>
</form>

</body>
</html>