package com.willysancyh.trackwave.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(generator = "file_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "file_seq", allocationSize = 1, initialValue = 1)
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
