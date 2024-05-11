package com.willysancyh.trackwave.entity;

public class FileEntity {

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

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
