package com.example.btnjava.Model.PageResponse;

import com.example.btnjava.Model.Response.MotelResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageResponse {
    List<MotelResponse> content;

    private Integer pageSize;
    private Integer currentPage;
    private Integer totalItems;
    private Integer totalPages;
}
