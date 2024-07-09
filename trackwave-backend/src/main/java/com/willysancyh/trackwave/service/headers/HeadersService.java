package com.willysancyh.trackwave.service.headers;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import org.springframework.http.HttpHeaders;

public interface HeadersService {
    public RangeHeaderModel getRangeHeaderModel(String rangeHeader, FileEntity fileEntity);

    public HttpHeaders getHeadersForFile(RangeHeaderModel rangeHeaderModel, FileEntity fileEntity);
}
