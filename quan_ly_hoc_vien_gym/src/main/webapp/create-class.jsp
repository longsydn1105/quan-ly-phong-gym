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
	<form action="<%=request.getContextPath()%>/tao-lich" method="post">
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
    <select name="endTime" id="endTime" disabled>
        <option value="10:00">10:00</option>
        <option value="12:00">12:00</option>
        <option value="16:00">16:00</option>
        <option value="18:00">18:00</option>
        <option value="20:00">20:00</option>
        <option value="22:00">22:00</option>
    </select>
    <br>
	
	<script>
    const startTimeSelect = document.getElementById("startTime");
    const endTimeSelect = document.getElementById("endTime");

    // Hàm tính toán thời gian kết thúc dựa trên thời gian bắt đầu
    function updateEndTime() {
        const startTime = startTimeSelect.value;
        const [hours, minutes] = startTime.split(":").map(Number);

        // Cộng thêm 2 giờ
        const endHours = hours + 2;

        // Chuyển đổi lại thành chuỗi thời gian định dạng HH:mm
        const endTime = (endHours < 10 ? "0" : "") + endHours + ":" + (minutes < 10 ? "0" : "") + minutes;

        // Cập nhật giá trị cho endTimeSelect
        Array.from(endTimeSelect.options).forEach(option => {
            if (option.value === endTime) {
                endTimeSelect.value = endTime;
            }
        });
    }

    // Lắng nghe sự kiện thay đổi trên ô startTime
    startTimeSelect.addEventListener("change", updateEndTime);

    // Khởi tạo giá trị ban đầu
    updateEndTime();
	</script>

    <label for="dateCreate">Ngày tạo:</label>
	<input type="date" id="dateCreate" name="dateCreate" required>
	<script>
    // Lấy ngày hiện tại
    const today = new Date();
    
    // Định dạng ngày thành yyyy-MM-dd
    const formattedDate = today.toISOString().split("T")[0];
    
    // Đặt giá trị mặc định và ngày tối thiểu cho input
    const dateInput = document.getElementById("dateCreate");
    dateInput.value = formattedDate;  // Giá trị mặc định là ngày hiện tại
    dateInput.min = formattedDate;   // Không cho phép chọn ngày trước ngày hiện tại
	</script> 
	<br>

    <button type="submit" class="btn btn-primary">Tạo Lớp</button>
    <div class="error">
    	<%
			if(request.getAttribute("error") != null) {
				String error = (String)request.getAttribute("error");
				%>
					<p style="color:red;"><%=error%> </p>
				<%
			}
		%>
    </div>
    
    <div class="success">
    	<%
			if(request.getAttribute("success") != null) {
				String success = (String)request.getAttribute("success");
				%>
					<p style="color:green;"><%=success%> </p>
				<%
			}
		%>
    </div>
</form>

</body>
</html>