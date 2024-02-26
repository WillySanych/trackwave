package com.willysancyh.trackwave.repository;

import com.willysancyh.trackwave.entity.AudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<AudioEntity, Long> {
}
