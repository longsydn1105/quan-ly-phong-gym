<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/user-index.css">
<link rel="stylesheet" href="css/infor-user.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM</title>
</head>
<body>
	
	<jsp:include page="include/header.jsp" />
	
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Thông Tin Người Dùng</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5 form-group">
        <h2 class="text-center mb-4">THÔNG TIN NGƯỜI DÙNG</h2>
        <form>
            <div class="mb-3">
                <label for="fullname" class="form-label">Họ và Tên</label>
                <input type="text" id="fullname" name="fullname" class="form-input" required>
            </div>
            <div class="mb-3">
                <label for="birthdate" class="form-label">Ngày Sinh</label>
                <input type="date" id="birthdate" name="birthdate" class="form-input" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Giới Tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="Nam" required>
                    <label class="form-check-label" for="genderMale">Nam</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderFemale" value="Nữ">
                    <label class="form-check-label" for="genderFemale">Nữ</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="genderOther" value="Khác">
                    <label class="form-check-label" for="genderOther">Khác</label>
                </div>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Số Điện Thoại</label>
                <input type="tel" id="phone" name="phone" class="form-input" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" id="email" name="email" class="form-input" required>
            </div>
            <div class="mb-3">
                <label for="registerDate" class="form-label">Ngày Đăng Ký</label>
                <input type="date" id="registerDate" name="registerDate" class="form-input" required>
            </div>
            <div class="mb-3">
                <label for="package" class="form-label">Gói Tập</label>
                <input type="text" id="package" name="package" class="form-input-no-repair" value="Gói tiêu chuẩn" readonly>
            </div>
            <button type="submit" class="btn btn-primary w-100">LƯU</button>
        </form>
    </div>
    <!-- Link Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>