package com.willysancyh.trackwave.entity;

public class AudioEntity {

    private Long id;
    private FileEntity fileEntity;
    private String name;
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AudioEntity{" +
                "id=" + id +
                ", file=" + fileEntity +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
