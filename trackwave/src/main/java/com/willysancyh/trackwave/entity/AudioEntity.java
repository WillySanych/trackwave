package com.willysancyh.trackwave.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.File;

@Entity
@Table(name = "audio")
public class AudioEntity {

    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "file_id")
    private FileEntity file;
}
