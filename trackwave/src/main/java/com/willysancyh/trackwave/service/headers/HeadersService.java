package com.willysancyh.trackwave.service.headers;

import com.willysancyh.trackwave.entity.FileEntity;
import org.springframework.http.HttpHeaders;

public interface HeadersService {
    public HttpHeaders getHeadersForFile(FileEntity fileEntity);
}
