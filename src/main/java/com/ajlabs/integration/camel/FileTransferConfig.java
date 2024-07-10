package com.ajlabs.integration.camel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "file-transfer")
public class FileTransferConfig {
    private Map<String, String> ftpToS3;
    private Map<String, String> s3ToFtp;

    // getters and setters
}
