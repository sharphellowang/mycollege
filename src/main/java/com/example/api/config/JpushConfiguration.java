package com.example.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix="jpush")
public class JpushConfiguration {

    private String appId;
    private String secretKey;
    private Map<String, Map<String, String>> key;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Map<String, Map<String, String>> getKey() {
        return key;
    }

    public void setKey(Map<String, Map<String, String>> key) {
        this.key = key;
    }
}
