package com.willysancyh.trackwave.dto;

import com.willysancyh.trackwave.entity.AudioEntity;

public class AudioDto {
    private Long id;
    private FileDto fileDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileDto getFileDto() {
        return fileDto;
    }

    public void setFileDto(FileDto fileDto) {
        this.fileDto = fileDto;
    }

    public static AudioDto createFromEntity(AudioEntity audioEntity) {
        AudioDto dto = new AudioDto();
        dto.setId(audioEntity.getId());
        dto.setFileDto(FileDto.createFromEntity(audioEntity.getFile()));
        return dto;
    }

    @Override
    public String toString() {
        return "AudioDto{" +
                "id=" + id +
                ", fileDto=" + fileDto +
                '}';
    }
}
