CREATE DATABASE PRJ301_SE1511_Group01
GO

USE PRJ301_SE1511_Group01
GO

CREATE TABLE Laptop (
	LaptopID int IDENTITY(1,1) primary key NOT NULL,
	Price float NOT NULL,
	Name nvarchar(50) NOT NULL,
	CPU nvarchar(50) NULL,
	Ram nvarchar(50) NULL,
	Screen nvarchar(50) NULL,
	Graphic nvarchar(50) NULL,
	Disk nvarchar(50) NULL,
	OS nvarchar(50) NULL,
	Weight float NULL,
	Region nvarchar(50) NULL,
	Year int NULL
)

GO

CREATE TABLE Users(
	UserID int IDENTITY(1,1) NOT NULL primary key,
	Username nvarchar(150) NOT NULL,
	Password nvarchar(1000) NOT NULL,
	Role int NOT NULL,
	Name nvarchar(50) NOT NULL,
	Phone nvarchar(50) NOT NULL,
	Address nvarchar(150) NOT NULL
)

GO

CREATE TABLE Orders(
	OrderID int IDENTITY(1,1) NOT NULL primary key,
	UserID int NOT NULL foreign key references Users(userID),
	Address nvarchar(150) NOT NULL,
	TotalPrice float NOT NULL
)

GO

CREATE TABLE OrderDetail(
	OrderDetailID int IDENTITY(1,1) primary key NOT NULL,
	OrderID int NOT NULL foreign key references Orders(OrderID),
	Quantity int NOT NULL,
	LaptopID int NOT NULL foreign key references Laptop(laptopID),
)

GO

INSERT INTO Users (Username, Password, Role, Name, Phone, Address) values ('admin', 'admin123', 1, 'Administrator', '0999222333', 'quan 1, hcm.city, vietnam');
INSERT INTO Users (Username, Password, Role, Name, Phone, Address) values ('employee', 'employee123', 3, 'Employee Unname', '0123456789', 'quan 2, hcm.city, vietnam');
INSERT INTO Users (Username, Password, Role, Name, Phone, Address) values ('user', 'user123', 2, 'User Nguyen Van A', '0234123234', 'thu duc, hcm.city, vietnam');

INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (20000000, 'Laptop Lenovo IdeaPad Gaming 3', 'AMD Ryzen 5-4600H', '8 GB, DDR4, 3200 MHz', '15.6", 1920 x 1080 Pixel, IPS, 120 Hz', 'NVIDIA GeForce GTX 1650 4 GB & AMD Radeon Graphics', 'SSD 512 GB', 'Windows 10', 2.2, 'Trung Quốc', 2021)
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (20000000, 'Laptop Lenovo IdeaPad Gaming 3 15ARH05', 'R5 4600H', '8GB', '15.6"', 'NVIDIA GeForce GTX 1650 4 GB', 'SSD 512 GB', 'Windows 10', 2.2, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)	
	values (13490000, 'Laptop Acer Aspire 3 A315 56 502X i5', 'Intel Core i5-1035G1', '4 GB', '15.6', 'Intel UHD Graphics', 'SSD 256 GB', 'Windows 10', 1.7, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)	
	values (21490000, 'Laptop Acer Aspire Gaming A715 41G R150', 'R7 3750H', '8GB', '15.6"', 'NVIDIA GeForce GTX 1650Ti 4 GB', 'SSD 512 GB', 'Windows 10', 2.1, 'Trung Quốc', 2020);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (18490000, 'Laptop Acer Aspire Gaming A715 42G R4ST', 'R5 5500U', '8GB', '15.6"', 'Nvidia GTX1650 4GB', 'SSD 256 GB', 'Windows 10', 2.1, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (20290000, 'Laptop Lenovo IdeaPad Gaming 3 15ARH05', 'R7 4800H', '8GB', '15.6"', 'NVIDIA GeForce GTX 1650 4 GB', 'SSD 512 GB', 'Windows 10', 2.2, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (14190000, 'Laptop MSI Modern 14 B11MOL 420VN', 'i3-1115G4', '8GB', '14.0"', 'Intel UHD Graphics', 'SSD 256 GB', 'Windows 10', 1.3, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (22490000, 'Laptop Acer Nitro Gaming AN515 44 R9JM', 'R5 4600H', '8GB', '15.6"', 'Nvidia GTX1650 4GB', 'SSD 512 GB', 'Windows 10', 2.17, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (16990000, 'Laptop Acer Aspire 3 A315-57G-524Z', 'i5 1035G1', '8GB', '15.6"', 'NVIDIA GeForce MX330 2 GB', 'SSD 512 GB', 'Windows 10', 1.9, 'Trung Quốc', 2020);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (22990000, 'Laptop HP Envy 13 ba1028TU', 'i5 1135G7', '8GB', '13.3"', 'Intel UHD Graphics', 'SSD 512 GB', 'Windows 10', 1.31, 'Trung Quốc', 2020);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (29990000, 'Laptop ASUS Gaming TUF FX516PE HN005T', 'i7 11370H', '8GB', '15.6"', 'NVIDIA GeForce RTX 3050Ti 4 GB', 'SSD 512 GB', 'Windows 10', 2.072, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (20490000, 'Laptop Asus TUF Gaming FX506LH HN002T', 'i5-10300H', '8GB', '15.6"', 'NVIDIA GeForce GTX 1650 4 GB', 'SSD 512 GB', 'Windows 10', 2.3, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (13690000, 'Laptop HP 240 G8', 'i3-1005G1', '8GB', '14.0"', 'Intel UHD Graphics 600', 'SSD 512 GB', 'Windows 10', 1.47, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (17090000, 'Laptop Dell Inspiron N5505A', 'R5 4500U', '8GB', '14.0"', 'AMD Radeon RX Graphics Vega 10', 'SSD 256 GB', 'Windows 10', 1.83, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (24490000, 'Laptop Lenovo Yoga Slim 7', 'i5-1135G7', '16GB', '14.0"', 'Intel Iris Xe Graphics', 'SSD 512 GB', 'Windows 10', 1.36, 'Trung Quốc', 2021);
INSERT INTO Laptop (Price, Name, CPU, Ram, Screen, Graphic, Disk, OS, Weight, Region, Year)
	values (18990000, 'Laptop HP Pavilion 15 eg0506TU', 'i5 1135G7', '8GB', '15.6"', 'Intel UHD Graphics', 'SSD 512 GB', 'Windows 10', 1.3, 'Trung Quốc', 2021);
