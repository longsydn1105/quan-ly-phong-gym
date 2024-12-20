<%@page import="model.dao.ClassesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Classes"%>
<%@page import="model.dao.PTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng ký lịch tập</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/calendar.css">
</head>
<body>
	<div class="background"></div>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Lịch Đăng Ký</h2>
        <div class="schedule-container">
            <!-- Gym -->
            <div class="activity">
                <h4>Gym</h4>
                <div class="classes">
                	<%
                		PTDAO ptDAO = new PTDAO();
                		ClassesDAO classDAO = new ClassesDAO();
                		ArrayList<Classes> listClass = classDAO.getItemsUpComing();
                		if(listClass != null){
                	%>
                	<%
                		for(Classes objClass : listClass) {
                			if(objClass.getClassName().equals("Gym")) {
                	%>
                    <div class="class-card" onclick="confirmRegistration('<%=objClass.getClassId() %>')">
                        <h5 class="class-title"><%=objClass.getClassName()%></h5>
                        <p class="class-detail">PT: <%=ptDAO.getItemByID(objClass.getPtId()).getFullName() %></p>
                        <p class="class-detail"><%=objClass.getStartTime()%> - <%=objClass.getEndTime() %></p>
                        <p class="class-detail"><%=objClass.getDateCreate()%></p>
                    </div>
                    <%}}%>
                </div>
            </div>
            <!-- Yoga -->
            <div class="activity">
                <h4>Yoga</h4>
                <div class="classes">
                	<%
                		if(listClass != null){
                	%>
                	<%
                		for(Classes objClass : listClass) {
                			if(objClass.getClassName().equals("Yoga")) {
                	%>
                    <div class="class-card" onclick="confirmRegistration('<%=objClass.getClassId() %>')">
                        <h5 class="class-title"><%=objClass.getClassName()%></h5>
                        <p class="class-detail">PT: <%=ptDAO.getItemByID(objClass.getPtId()).getFullName() %></p>
                        <p class="class-detail"><%=objClass.getStartTime()%> - <%=objClass.getEndTime() %></p>
                        <p class="class-detail"><%=objClass.getDateCreate()%></p>
                    </div>
                    <%}}%>
                </div>
            </div>
            <!-- Cardio -->
            <div class="activity">
                <h4>Cadio</h4>
                <div class="classes">
                	<%
                		if(listClass != null){
                	%>
                	<%
                		for(Classes objClass : listClass) {
                			if(objClass.getClassName().equals("Cadio")) {
                	%>
                    <div class="class-card" onclick="confirmRegistration('<%=objClass.getClassId() %>')">
                        <h5 class="class-title"><%=objClass.getClassName()%></h5>
                        <p class="class-detail">PT: <%=ptDAO.getItemByID(objClass.getPtId()).getFullName() %></p>
                        <p class="class-detail"><%=objClass.getStartTime()%> - <%=objClass.getEndTime() %></p>
                        <p class="class-detail"><%=objClass.getDateCreate()%></p>
                    </div>
                    <%}}%>
                </div>
            </div>
            <%}}}%>
        </div>
    </div>
    <script>
    function confirmRegistration(classId) {
    	console.log("Class ID:", classId); // Kiểm tra giá trị classId
        const userConfirmed = confirm("Bạn có muốn đăng ký lớp này không?");
        if (userConfirmed) {
            // Chuyển hướng tới trang xác nhận đăng ky
            window.location.href = './xac-nhan-dang-ky-lich?classId='+ classId;
        }
    }
	</script>
    
</body>
</html>
