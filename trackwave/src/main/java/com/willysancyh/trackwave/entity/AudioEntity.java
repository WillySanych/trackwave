package com.willysancyh.trackwave.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.File;

@Entity
@Table(name = "audio")
public class AudioEntity {

    @Id
    @GeneratedValue(generator = "audio_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "audio_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "file_id")
    private FileEntity file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileEntity getFile() {
        return file;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "AudioEntity{" +
                "id=" + id +
                ", file=" + file +
                '}';
    }
}
