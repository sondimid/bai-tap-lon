package com.example.btnjava.Model.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class MotelDTO {
    private Integer id;

    @NotNull(message = "Tiêu Đề Không Được Bỏ Trống")
    private String title;

    @NotNull(message = "Số Nhà Không Được Bỏ Trống")
    private Integer houseNumber;

    private String street;

    @NotNull(message = "Phường Không Được Bỏ Trống")
    private String ward;

    @NotNull(message = "Quận/Huyện Không Được Bỏ Trống")
    private String district;

    @NotNull(message = "Tỉnh/Thành Phố Không Được Bỏ Trống")
    private String province;

    @NotNull(message = "Diện Tích Không Được Bỏ Trống")
    private Integer area;

    @NotNull(message = "Giá Tiền Không Được Bỏ Trống")
    private Integer price;

    private String interior;

    private String type;

    @NotNull(message = "Chi Tiết Phòng Trọ Không Được Bỏ Trống")
    private String detail;

    private Integer userId;

    @NotNull(message = "Số Lượng Người Ở Không Được Bỏ Trống")
    private Integer maxPeople;

    private List<MultipartFile> files;
}
