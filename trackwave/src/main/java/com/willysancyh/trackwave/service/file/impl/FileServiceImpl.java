package com.willysancyh.trackwave.service.file.impl;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.service.file.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public StreamingResponseBody getStreamingResponseBodyForFile(FileEntity fileEntity) {
        return null;
    }
}
