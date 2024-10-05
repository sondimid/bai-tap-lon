package com.example.btnjava.Utils;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetFiles {
    public List<MultipartFile> fromUrlFiles(String[] urls) throws IOException {
        List<MultipartFile> files = new ArrayList<MultipartFile>();
        for (String urlStr : urls) {
            // Tạo đối tượng URL
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();

            // Mở InputStream để đọc dữ liệu từ URL
            InputStream inputStream = connection.getInputStream();

            // Lấy tên file từ URL
            String fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1);

            // Tạo đối tượng MultipartFile từ dữ liệu đã tải
            MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, connection.getContentType(), inputStream);

            // Thêm vào danh sách files
            files.add(multipartFile);

            // Đóng InputStream sau khi xử lý
            inputStream.close();
        }
        return files;
    }
}
