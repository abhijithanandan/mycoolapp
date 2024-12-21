package com.abhijithanandan.mycoolapp.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class DocumentsConfig {

    @Bean
    public S3Client remoteClient() {

        // Create an S3 client to connect to AWS s3

        ProfileCredentialsProvider profileCredentialsProvider = ProfileCredentialsProvider.create();
        Region region = Region.US_EAST_1;

        return S3Client.builder()
                .credentialsProvider(profileCredentialsProvider)
                .region(region)
                .build();
    }
}
