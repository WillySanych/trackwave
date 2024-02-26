package com.willysancyh.trackwave.repository;

import com.willysancyh.trackwave.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
