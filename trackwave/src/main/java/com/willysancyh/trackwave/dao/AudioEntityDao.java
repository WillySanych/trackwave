package com.willysancyh.trackwave.dao;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.mapper.AudioEntityMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
public class AudioEntityDao {
    private final String CONDITION_NAME = "AND a.NAME ILIKE '%%%s%%'";
    private final String CONDITION_AUTHOR = "AND a.AUTHOR ILIKE '%%%s%%'";

    private final AudioEntityMapper audioEntityMapper;

    public AudioEntityDao(AudioEntityMapper audioEntityMapper) {
        this.audioEntityMapper = audioEntityMapper;
    }

    public Optional<AudioEntity> findById(Long id) {
        return Optional.ofNullable(audioEntityMapper.findById(id));
    }

    public List<AudioEntity> findAll(String name, String author) {
        StringBuilder searchCondition = new StringBuilder();
        if (StringUtils.hasText(name)) {
            searchCondition.append(String.format(CONDITION_NAME, name));
        }
        if (StringUtils.hasText(author)) {
            searchCondition.append(String.format(CONDITION_AUTHOR, author));
        }

        return audioEntityMapper.findAllBySearchCondition(searchCondition.toString());
    }

    public AudioEntity saveAudioEntity(AudioEntity audioEntity) {
        audioEntityMapper.insertAudioEntity(audioEntity);
        return audioEntity;
    }
}
