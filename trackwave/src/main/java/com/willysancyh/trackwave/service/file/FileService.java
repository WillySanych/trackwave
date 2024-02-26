package com.willysancyh.trackwave.service.file;

import com.willysancyh.trackwave.entity.FileEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface FileService {
    public StreamingResponseBody getStreamingResponseBodyForFile(FileEntity fileEntity);
}
