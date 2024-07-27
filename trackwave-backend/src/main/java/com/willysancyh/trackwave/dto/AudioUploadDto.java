package com.willysancyh.trackwave.dto;

public class AudioUploadDto {
    private String author;
    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AudioUploadDto{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
