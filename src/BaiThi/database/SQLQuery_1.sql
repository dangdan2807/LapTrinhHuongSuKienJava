create database QLMonHoc
go
use QLMonHoc
go
 CREATE TABLE BoMonChuQuan(
   maBoMonCQ  NVARCHAR (30) primary key,
   tenBoMon NVARCHAR (50) NOT NULL,     
);
CREATE TABLE MonHoc(
   maMon  NVARCHAR (30) primary key,
   tenMon NVARCHAR (50)  NULL,
   maBoMonCQ  NVARCHAR (30) ,  
   soTiet int, 
   Constraint F_BM_HN Foreign key(maBoMonCQ) references BoMonChuQuan(maBoMonCQ),
);
INSERT BoMonChuQuan([maBoMonCQ], [tenBoMon]) VALUES ('KTPM', N'KỸ THUẬT PHẦN MỀM')
INSERT BoMonChuQuan([maBoMonCQ], [tenBoMon]) VALUES ('KHMT', N'KHOA HỌC MÁY TÍNH')
INSERT BoMonChuQuan([maBoMonCQ], [tenBoMon]) VALUES ('HTTT', N'HỆ THỐNG THÔNG TIN')

INSERT MonHoc([maMon], [tenMon],[maBoMonCQ],[soTiet]) VALUES ('2101623', N'Lập Trình Hướng Đối Tượng','KTPM',90)

INSERT MonHoc([maMon], [tenMon],[maBoMonCQ],[soTiet]) VALUES ('2101436', N'Hệ cơ sở dữ liệu','HTTT',45)

INSERT MonHoc([maMon], [tenMon],[maBoMonCQ],[soTiet]) VALUES ('2101657', N'Phát triển ứng dụng ','KTPM',60)

INSERT MonHoc([maMon], [tenMon],[maBoMonCQ],[soTiet]) VALUES ('2101409', N'Cấu trúc dữ liệu và giải thuật','KHMT',90)
 