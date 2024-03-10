package com.willysancyh.trackwave.service.file;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface FileService {
    public StreamingResponseBody getFileStream(FileEntity fileEntity, RangeHeaderModel rangeHeaderModel);
    public FileEntity saveFileToStorage(MultipartFile multipartFile);
}
