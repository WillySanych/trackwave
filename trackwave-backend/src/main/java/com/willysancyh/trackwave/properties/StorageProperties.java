package com.willysancyh.trackwave.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    private final String location;

    public StorageProperties(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
