package com.willysancyh.trackwave.dao;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.mapper.AudioEntityMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
public class AudioEntityDao {
    private final String CONDITION_SEARCH_TEXT = "AND (a.NAME ILIKE '%%%1$s%%' OR auth.NAME ILIKE '%%%1$s%%')";
    private final String CONDITION_LIMIT = " LIMIT 10";

    private final AudioEntityMapper audioEntityMapper;

    public AudioEntityDao(AudioEntityMapper audioEntityMapper) {
        this.audioEntityMapper = audioEntityMapper;
    }

    public Optional<AudioEntity> findById(Long id) {
        return Optional.ofNullable(audioEntityMapper.findById(id));
    }

    public List<AudioEntity> findBySearchText(String searchText) {
        StringBuilder searchCondition = new StringBuilder();
        if (StringUtils.hasText(searchText)) {
            searchCondition.append(String.format(CONDITION_SEARCH_TEXT, searchText));
        }

        return audioEntityMapper.findAllBySearchCondition(searchCondition.toString(), CONDITION_LIMIT);
    }

    public AudioEntity saveAudioEntity(AudioEntity audioEntity) {
        audioEntityMapper.insertAudioEntity(audioEntity);
        return audioEntity;
    }
}
