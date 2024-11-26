<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
<!-- Thanh Logo -->
    <header class="d-flex justify-content-between align-items-center p-2 ">
	  <!-- Logo -->
	  <div class="logo">
	    <img src="img/Logo_Gym.png" alt="Logo" style="height:100px;width:150%;">
	  </div>

	  <!-- Navigation -->
	  <nav>
	    <ul class="nav">
	      <li class="nav-item"><a href="#" class="nav-link">Trang chủ</a></li>
	      <li class="nav-item dropdown">
		      <a href="#" class="nav-link dropdown-toggle" id="servicesMenu" data-bs-toggle="dropdown">Dịch vụ</a>
		      <ul class="dropdown-menu" aria-labelledby="servicesMenu">
		        <li><a class="dropdown-item" href="#">Dịch vụ 1</a></li>
		        <li><a class="dropdown-item" href="#">Dịch vụ 2</a></li>
		        <li><a class="dropdown-item" href="#">Dịch vụ 3</a></li>
		      </ul>
	      </li>
		  <li class="nav-item"><a href="#" class="nav-link">Gói tập</a></li>
	      <li class="nav-item"><a href="#" class="nav-link">Liên hệ</a></li>
	    </ul>
	  </nav>
	
	  <!-- Nút Đăng ký -->
	  <button class="btn btn-register" onclick="window.location.href='<%=request.getContextPath()%>/register.jsp'">Đăng ký</button>
	</header>

    <!-- Bảng lướt Slide ngang -->
    <div id="carouselExampleIndicators" class="carousel slide mt-3" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="img/slide1.jpg" class="d-block w-100" alt="Slide 1">
            </div>
            <div class="carousel-item">
                <img src="img/slide2.jpg" class="d-block w-100" alt="Slide 2">
            </div>
            <div class="carousel-item">
                <img src="img/slide3.jpg" class="d-block w-100" alt="Slide 3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- Các mục thông tin -->
    <div class="container text-center content">
    	<div class="row justify-content-md-center">
    		<div class="col col-md-5">
    			<h1>Các Dịch Vụ Tại LH GYM</h1>
    		</div>
    		<div class="col col-md-7 row d-flex ">
    			<div class="col col-md-6 col-content-left">
    				<div class="content-detail">
    					<img src="img/boxing.jpg" alt="boxing" >
    					<h5>Boxing - Thể hiện sự mạnh mẽ</h5>
    					<p>Boxing là bộ môn giúp rèn luyện sức khỏe, tăng sức bền và giảm căng thẳng hiệu quả.
    					 Tại phòng gym của chúng tôi, bạn sẽ được hướng dẫn bài bản bởi các huấn luyện viên chuyên nghiệp.
    					  Hãy khám phá sức mạnh và sự tự tin qua từng buổi tập boxing! </p>
    				</div>
    				<div class="content-detail">
    					<img src="img/yoga_content.jpg" alt="yoga" >
    					<h5>TINH HOA YOGA ẤN ĐỘ</h5>
    					<p>Thực hành chuẩn xác Yoga với sự hướng dẫn của các bậc thầy Yoga Ấn Độ. Đạt đến trạng thái cân 
    					bằng hoàn hảo bằng cách xây dựng sức mạnh, độ linh hoạt và sự uyển chuyển cơ thể trong khi thư giãn
    					 hoàn toàn mọi giác quan và</p>
    				</div>
    			</div>
    			
    			<div class="col col-md-6 col-content-right">
    				<div class="content-detail">
    					<img src="img/PT_content.jpg" alt="PT" >
    					<h5>HLV CÁ NHÂN LUÔN ĐỒNG HÀNH CÙNG BẠN</h5>
    					<p>Các huấn luyện viên đạt chuẩn NASM của chúng tôi sẽ cùng bạn thiết lập chương trình tập luyện & chế
    					 độ dinh dưỡng phù hợp với thể trạng của bạn. Đồng thời, các HLV cá nhân sẽ hướng dẫn bạn từng bước để 
    					 chinh phục mục</p>
    				</div>
    				<div class="content-detail">
    					<img src="img/lop_content.jpg" alt="" >
    					<h5>LỚP TẬP NHÓM KHÔNG GIỚI HẠN</h5>
    					<p>Tận hưởng niềm vui bất tận với hơn 50 lớp tập nhóm bản quyền từ Lesmills như Body Combat, Body Jam, 
    					RPM, SH’Bam và các chương trình độc quyền do California thiết kế. Các phiên bản mới được cập nhật liên 
    					tục mỗi tháng.</p>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>

	<!-- Mục địa chỉ của phòng gym -->
	<div class="container  ">
		<div class="row justify-content-md-center address">
			<div class="col col-md-5">
				<h2>THÔNG TIN CLB</h2>
				<p>Tọa lạc tại tòa nhà Bưu Điện của thành phố, LH GYM Đà Nẵng chính là lựa chọn 
				lý tưởng dành cho những người yêu thích lối sống khoẻ mạnh và năng động. Với diện tích rộng 5000m2 trải dài
				4 tầng nhà, riêng khu vực tầng 3 là khu vực tập gym chuyên dụng với hơn 29+ máy chạy bộ cùng với máy tập phục
				vụ đủ các nhóm cơ nhập khẩu hoàn toàn từ Technogym, chắc chắn sẽ đem lại cho bạn trải nghiệm đầy đủ nhất về không gian tập luyện đẳng cấp quốc tế đích thực.</p>
			</div>
			
			<div class="col col-md-7 row time-service">
				<div class="col col-md-6 time">
					<h5>THỜI GIAN HOẠT ĐỘNG</h5>
					<p>Thời gian hoạt động 5:00-22:00</p>
				</div>
				<div class="col col-md-6 service">
					<h5>TIỆN NGHI</h5>
					<ul class=" feature-list">
						<li><i class="fas fa-check-circle"></i>Khu vực Gym </li>
						<li><i class="fas fa-check-circle"></i>Yoga Studio</li>
						<li><i class="fas fa-check-circle"></i>Hồ Bơi </li>
						<li><i class="fas fa-check-circle"></i>Phòng thay đồ</li>
						<li><i class="fas fa-check-circle"></i>Phòng thư giãn</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

<!-- Mục thông tin liên hệ -->
	<div class="container contract">
		<div class="row d-lex justify-content-md-center align-items-center " >
			<div class=" col col-md-6 email-contract">
				<h4>EMAIL</h4>
				<p>longsydn1105@gmail.com</p>
			</div>
			<div class="col col-md-6">
				<h4>Số điện thoại</h4>
				<p>0705995857</p>
			</div>
		</div>	
	</div>


<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
