<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Liên kết đến file CSS của Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/user-list.css">
<!-- Tích hợp font chữ của gg font -->
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">
<!-- Tích hợp icon -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<title>LH GYM </title>
</head>
<body>
	<div class="background"></div>
    <div class="container mt-5">
        <h2 class="text-center mb-4">DANH SÁCH NGƯỜI DÙNG</h2>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>STT</th>
                    <th>HỌ VÀ TÊN</th>
                    <th>SĐT</th>
                    <th>EMAIL</th>
                    <th>THAO TÁC</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Nguyễn Văn A</td>
                    <td>0123456789</td>
                    <td>nguyenvana@gmail.com</td>
                    <td>
                        <button class="btn btn-primary btn-sm">SỬA</button>
                        <button class="btn btn-danger btn-sm">XÓA</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Trần Thị B</td>
                    <td>0987654321</td>
                    <td>tranthib@gmail.com</td>
                    <td>
                        <button class="btn btn-primary btn-sm">SỬA</button>
                        <button class="btn btn-danger btn-sm">XÓA</button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Phạm Văn C</td>
                    <td>0345678923</td>
                    <td>phamvanc@gmail.com</td>
                    <td>
                        <button class="btn btn-primary btn-sm">SỬA</button>
                        <button class="btn btn-danger btn-sm">XÓA</button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Phạm Văn C</td>
                    <td>0345678923</td>
                    <td>phamvanc@gmail.com</td>
                    <td>
                        <button class="btn btn-primary btn-sm">SỬA</button>
                        <button class="btn btn-danger btn-sm">XÓA</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="text-center mt-4">
            <button class="btn btn-success">Thêm</button>
        </div>
    </div>
</body>

</html>