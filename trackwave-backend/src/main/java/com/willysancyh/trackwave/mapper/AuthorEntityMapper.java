package com.willysancyh.trackwave.mapper;

import com.willysancyh.trackwave.entity.AuthorEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorEntityMapper {
    public void insertAuthorEntity(AuthorEntity authorEntity);
}
