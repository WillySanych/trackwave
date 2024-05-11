package com.willysancyh.trackwave.dao;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.mapper.FileEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FileEntityDao {
    private final FileEntityMapper fileEntityMapper;

    public FileEntityDao(FileEntityMapper fileEntityMapper) {
        this.fileEntityMapper = fileEntityMapper;
    }

    public FileEntity saveFileEntity(FileEntity fileEntity) {
        fileEntityMapper.insertFileEntity(fileEntity);
        return fileEntity;
    }
}
