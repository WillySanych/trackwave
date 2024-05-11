package com.willysancyh.trackwave.mapper;

import com.willysancyh.trackwave.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileEntityMapper {
    public void insertFileEntity(FileEntity fileEntity);
}
