package com.willysancyh.trackwave.service.headers.impl;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import com.willysancyh.trackwave.properties.StorageProperties;
import com.willysancyh.trackwave.service.headers.HeadersService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class HeadersServiceImpl implements HeadersService {

    //TODO move out to properties
    private final Integer partialFileSize = 4096000;

    private final StorageProperties storageProperties;

    public HeadersServiceImpl(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    @Override
    public RangeHeaderModel getRangeHeaderModel(String rangeHeader, FileEntity fileEntity) {
        long rangeFrom = getRangeFrom(rangeHeader);
        long rangeTo = getRangeTo(rangeHeader);

        File file = new File(storageProperties.getLocation() + "/" + fileEntity.getPath());
        Path path = file.toPath();
        long fileSize = 0;
        try {
            fileSize = Files.size(path);
        } catch (IOException e) {
            //TODO handle exception
            throw new RuntimeException(e);
        }

        if (fileSize > 0L) {
            if (rangeTo == 0) {
                rangeTo += rangeFrom + partialFileSize;
            }
            if (rangeFrom > fileSize) {
                rangeFrom = fileSize - 1L;
            }
            if (rangeTo > fileSize) {
                rangeTo = fileSize;
            }
        } else {
            rangeFrom = 0L;
            rangeTo = 0L;
        }

        return new RangeHeaderModel(rangeFrom, rangeTo);
    }

    @Override
    public HttpHeaders getHeadersForFile(RangeHeaderModel rangeHeaderModel, FileEntity fileEntity) {
        File file = new File(storageProperties.getLocation() + "/" + fileEntity.getPath());
        Path path = file.toPath();

        String contentType = null;
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            //TODO handle exception
            throw new RuntimeException(e);
        }

        String contentLength = String.valueOf((rangeHeaderModel.getRangeTo() - rangeHeaderModel.getRangeFrom()));
        long fileSize = file.length();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        headers.add(HttpHeaders.CONTENT_LENGTH, contentLength);
        headers.add(HttpHeaders.ACCEPT_RANGES, "bytes");
        headers.add(HttpHeaders.CONTENT_RANGE, String.format("bytes %d-%d/%d", rangeHeaderModel.getRangeFrom(), rangeHeaderModel.getRangeTo(), fileSize));

        return headers;
    }

    private long getRangeFrom(String rangeHeader) {
        long rangeFrom = 0;
        if (rangeHeader != null) {
            int index = rangeHeader.indexOf('-');
            String rangeFromPart = rangeHeader.substring(0, index);
            String rangeFromString = numericStringValue(rangeFromPart);

            if (StringUtils.hasText(rangeFromString)) {
                rangeFrom = Long.parseLong(rangeFromString);
            }
        }
        return rangeFrom;
    }

    public static long getRangeTo(String rangeHeader) {
        long rangeTo = 0;
        if (rangeHeader != null) {
            int index = rangeHeader.indexOf('-');
            String rangeToPart = rangeHeader.substring(index + 1);
            String rangeToString = numericStringValue(rangeToPart);

            if (StringUtils.hasText(rangeToString)) {
                rangeTo = Long.parseLong(rangeToString);
            }
        }
        return rangeTo;
    }

    private static String numericStringValue(String origVal) {
        String result = "";
        if (StringUtils.hasText(origVal)) {
            result = origVal.replaceAll("[^0-9]", "");
        }

        return result;
    }
}
