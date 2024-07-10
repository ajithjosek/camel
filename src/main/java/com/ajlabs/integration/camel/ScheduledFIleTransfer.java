package com.ajlabs.integration.camel;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledFileTransfer {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private FileTransferConfig fileTransferConfig;

    @Scheduled(fixedRateString = "${file-transfer.schedule-rate}")
    public void transferFiles() {
        fileTransferConfig.getFtpToS3().forEach((ftpPath, s3Path) -> {
            producerTemplate.sendBodyAndHeader("direct:ftpToS3", null, "ftpPath", ftpPath);
            producerTemplate.sendBodyAndHeader("direct:s3ToFtp", null, "s3Path", s3Path);
        });
    }
}

