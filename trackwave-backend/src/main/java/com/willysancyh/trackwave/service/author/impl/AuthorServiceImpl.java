package com.willysancyh.trackwave.service.author.impl;

import com.willysancyh.trackwave.dao.AuthorEntityDao;
import com.willysancyh.trackwave.dto.AudioUploadDto;
import com.willysancyh.trackwave.entity.AuthorEntity;
import com.willysancyh.trackwave.service.author.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorEntityDao authorEntityDao;

    public AuthorServiceImpl(AuthorEntityDao authorEntityDao) {
        this.authorEntityDao = authorEntityDao;
    }

    @Override
    public AuthorEntity saveAuthorEntity(AudioUploadDto audioUploadDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(audioUploadDto.getAuthor());

        return authorEntityDao.saveAuthorEntity(authorEntity);
    }
}
