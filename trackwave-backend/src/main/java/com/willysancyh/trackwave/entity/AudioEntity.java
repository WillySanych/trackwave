package com.willysancyh.trackwave.entity;

public class AudioEntity {

    private Long id;
    private FileEntity fileEntity;
    private String name;
    private AuthorEntity authorEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    @Override
    public String toString() {
        return "AudioEntity{" +
                "id=" + id +
                ", fileEntity=" + fileEntity +
                ", name='" + name + '\'' +
                ", authorEntity=" + authorEntity +
                '}';
    }
}
