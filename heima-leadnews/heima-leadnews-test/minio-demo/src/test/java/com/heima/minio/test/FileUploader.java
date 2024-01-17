package com.heima.minio.test;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient = MinioClient.builder().credentials("admin", "admin123456").endpoint("http://192.168.192.128:9000").build();

            // Make 'asiatrip' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("heimaleadnews").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("heimaleadnews").build());
            } else {
                System.out.println("Bucket 'asiatrip' already exists.");
            }

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            // 'asiatrip'.
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("heimaleadnews")
                            .object("list.html")
                            .filename("F:\\黑马程序员资料\\list.html")
                            .build());
//            System.out.println(
//                    "'F:\\黑马程序员资料\\list.html' is successfully uploaded as "
//                            + "object 'asiaphotos-2015.zip' to bucket 'heimaleadnews'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}