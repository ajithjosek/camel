package com.ajlabs.integration.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileTransferRoutes extends RouteBuilder {
    @Override
    public void configure() {
        from("aws-s3://my-s3-bucket?accessKey=YOUR_ACCESS_KEY&secretKey=YOUR_SECRET_KEY")
                .to("ftp://user@host/directory?password=secret");

        from("ftp://user@host/directory?password=secret")
                .to("aws-s3://my-s3-bucket?accessKey=YOUR_ACCESS_KEY&secretKey=YOUR_SECRET_KEY");
    }
}

