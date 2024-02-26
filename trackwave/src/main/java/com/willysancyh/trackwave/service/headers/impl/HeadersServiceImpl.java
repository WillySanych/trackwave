package com.willysancyh.trackwave.service.headers.impl;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.service.headers.HeadersService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HeadersServiceImpl implements HeadersService {
    @Override
    public HttpHeaders getHeadersForFile(FileEntity fileEntity) {
        return null;
    }
}
