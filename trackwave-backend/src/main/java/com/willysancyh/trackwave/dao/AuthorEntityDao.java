package com.willysancyh.trackwave.dao;

import com.willysancyh.trackwave.dto.AudioUploadDto;
import com.willysancyh.trackwave.entity.AuthorEntity;
import com.willysancyh.trackwave.mapper.AuthorEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorEntityDao {

    private final AuthorEntityMapper authorEntityMapper;

    public AuthorEntityDao(AuthorEntityMapper authorEntityMapper) {
        this.authorEntityMapper = authorEntityMapper;
    }

    public AuthorEntity saveAuthorEntity(AuthorEntity authorEntity) {
        authorEntityMapper.insertAuthorEntity(authorEntity);
        return authorEntity;
    }
}
