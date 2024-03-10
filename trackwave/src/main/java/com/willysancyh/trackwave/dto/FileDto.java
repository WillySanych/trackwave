package com.willysancyh.trackwave.dto;

import com.willysancyh.trackwave.entity.FileEntity;

public class FileDto {
    private Long id;
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static FileDto createFromEntity(FileEntity fileEntity) {
        FileDto dto = new FileDto();
        dto.setId(fileEntity.getId());
        dto.setPath(fileEntity.getPath());
        return dto;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
