package com.willysancyh.trackwave.service.author;

import com.willysancyh.trackwave.dto.AudioUploadDto;
import com.willysancyh.trackwave.entity.AuthorEntity;

public interface AuthorService {
    public AuthorEntity saveAuthorEntity(AudioUploadDto audioUploadDto);
}
