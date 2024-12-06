create database ql_phong_gym;
use ql_phong_gym;

CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    FullName NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) UNIQUE NOT NULL,
    Password NVARCHAR(255) NOT NULL,
    Phone NVARCHAR(15) UNIQUE,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Bổ sung unique(duy nhất) cho thuộc tính Phone
ALTER TABLE Users
ADD CONSTRAINT Unique_Phone UNIQUE (Phone);

CREATE TABLE Rooms (
    RoomID INT PRIMARY KEY AUTO_INCREMENT,
    RoomName NVARCHAR(255) NOT NULL,
    Capacity INT NOT NULL, -- Sức chứa phòng
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE PT (
    PTID INT PRIMARY KEY AUTO_INCREMENT,
    FullName NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) UNIQUE NOT NULL,
    Phone NVARCHAR(15),
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Classes (
    ClassID INT PRIMARY KEY AUTO_INCREMENT,
    RoomID INT NOT NULL,
    PTID INT NOT NULL, -- PT phụ trách (liên kết với Users)
    ClassName NVARCHAR(255) NOT NULL,
    StartTime TIME NOT NULL,  -- Chỉ lưu giờ phút
    EndTime TIME NOT NULL,    -- Chỉ lưu giờ phút
    DateCreate DATE NOT NULL, -- Lưu chỉ ngày, không cần thời gian
    FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID),
    FOREIGN KEY (PTID) REFERENCES pt(PTID),
    
    -- Đảm bảo 1 phòng chỉ có 1 lớp trong 1 khung giờ và 1 ngày
    CONSTRAINT UniqueRoomTime UNIQUE (RoomID, DateCreate, StartTime, EndTime), 
    
    -- Đảm bảo 1 PT chỉ nhận 1 lớp trong 1 khung giờ và 1 ngày
    CONSTRAINT UniquePTTime UNIQUE (PTID, DateCreate, StartTime, EndTime)
);

CREATE TABLE Registrations (
    RegistrationID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL, -- Người dùng đăng ký (liên kết với Users)
    ClassID INT NOT NULL, -- Lớp đăng ký (liên kết với Classes)
    RegisteredAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (ClassID) REFERENCES Classes(ClassID),
    CONSTRAINT UniqueUserClass UNIQUE (UserID, ClassID) -- Đảm bảo 1 người chỉ đăng ký 1 lần vào 1 lớp
);

-- --------------------- THÊM DỮ LIỆU ---------------------------------
INSERT INTO Rooms (RoomName, Capacity) VALUES
('101', 15),
('102', 10),
('103', 20),
('104', 8),
('105', 18),
('201', 12),
('202', 9),
('203', 16),
('204', 14),
('205', 19);

INSERT INTO PT (FullName, Email, Phone) VALUES
('Nguyen Van A', 'nguyenvana@example.com', '0912345678'),
('Tran Thi B', 'tranthib@example.com', '0987654321'),
('Le Van C', 'levanc@example.com', '0909123456'),
('Pham Minh D', 'phamminhd@example.com', '0934567890'),
('Hoang Thi E', 'hoangthie@example.com', '0978123456');













