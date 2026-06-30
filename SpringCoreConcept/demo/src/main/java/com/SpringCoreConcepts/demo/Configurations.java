package com.SpringCoreConcepts.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
public class Configurations {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;
}
