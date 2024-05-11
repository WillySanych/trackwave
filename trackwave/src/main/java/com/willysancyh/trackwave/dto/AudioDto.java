package com.willysancyh.trackwave.dto;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.entity.AuthorEntity;
import com.willysancyh.trackwave.entity.FileEntity;

public class AudioDto {
    private Long id;
    private FileDto file;
    private String name;
    private AuthorDto author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileDto getFile() {
        return file;
    }

    public void setFile(FileDto file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public static AudioDto createFromEntity(AudioEntity audioEntity) {
        AudioDto dto = new AudioDto();
        dto.setId(audioEntity.getId());
        dto.setName(audioEntity.getName());

        AuthorEntity authorEntity = audioEntity.getAuthorEntity();
        if (authorEntity != null) {
            dto.setAuthor(AuthorDto.createFromEntity(authorEntity));
        }

        FileEntity fileEntity = audioEntity.getFileEntity();
        if (fileEntity != null) {
            dto.setFile(FileDto.createFromEntity(fileEntity));
        }

        return dto;
    }

    @Override
    public String toString() {
        return "AudioDto{" +
                "id=" + id +
                ", file=" + file +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
