package com.willysancyh.trackwave.dto;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.entity.FileEntity;

public class AudioDto {
    private Long id;
    private FileDto fileDto;
    private String name;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileDto getFileDto() {
        return fileDto;
    }

    public void setFileDto(FileDto fileDto) {
        this.fileDto = fileDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static AudioDto createFromEntity(AudioEntity audioEntity) {
        AudioDto dto = new AudioDto();
        dto.setId(audioEntity.getId());
        dto.setAuthor(audioEntity.getAuthor());
        dto.setName(audioEntity.getName());
        FileEntity fileEntity = audioEntity.getFileEntity();
        if (fileEntity != null) {
            dto.setFileDto(FileDto.createFromEntity(fileEntity));
        }
        return dto;
    }

    @Override
    public String toString() {
        return "AudioDto{" +
                "id=" + id +
                ", fileDto=" + fileDto +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
