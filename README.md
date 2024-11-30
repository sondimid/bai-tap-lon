Tìm kiếm phòng trọ
Dự án này là một website hỗ trợ tìm kiếm phòng trọ, nơi người thuê có thể tìm kiếm và lọc các phòng trọ theo địa điểm, giá cả, và các tiêu chí khác. Chủ nhà có thể quản lý phòng và hợp đồng thuê. Admin kiểm duyệt bài đăng.

Yêu cầu trước khi chạy dự án
1. Chuẩn bị cơ sở dữ liệu
Cài đặt MySQL.
Chạy file timtro.sql trong MySQL để khởi tạo database và các bảng.
2. Cài đặt giao diện (Frontend)
Chuyển đến thư mục vue-fe:
bash
Copy code
cd vue-fe
Cài đặt các module cần thiết:
bash
Copy code
npm install
Cách chạy dự án
Chạy Backend (Spring Boot):

Chạy ứng dụng Spring Boot từ IDE (như IntelliJ IDEA hoặc Eclipse).
Mặc định server sẽ chạy tại: http://localhost:8081.
Chạy Frontend (Vue):

Từ thư mục vue-fe, chạy lệnh:
bash
Copy code
npm run serve
Mặc định frontend sẽ chạy tại: http://localhost:5174.
Truy cập website:

Mở trình duyệt và truy cập frontend tại http://localhost:5174.
