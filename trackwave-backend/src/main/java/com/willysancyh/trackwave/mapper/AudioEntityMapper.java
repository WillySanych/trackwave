package com.willysancyh.trackwave.mapper;

import com.willysancyh.trackwave.entity.AudioEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AudioEntityMapper {
    public AudioEntity findById(@Param("id") Long id);
    public List<AudioEntity> findAllBySearchCondition(@Param("searchCondition") String searchCondition);
    public void insertAudioEntity(AudioEntity audioEntity);
}
