package com.willysancyh.trackwave.service.audio;

import com.willysancyh.trackwave.dto.AudioUploadDto;
import com.willysancyh.trackwave.entity.AudioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

public interface AudioService {
    public ResponseEntity<StreamingResponseBody> getAudioStreamingResponse(Long audioId, String rangeHeader);

    public AudioEntity saveAudioEntity(MultipartFile audioFile, AudioUploadDto audioUploadDto);

    public List<AudioEntity> getAudioEntityList(String searchText);
}
