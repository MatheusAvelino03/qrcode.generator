package com.example.qrcode.generator.infrastructure;

import com.example.qrcode.generator.port.Storageport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


/*
* Infraestrutura para armazenar os arquivos no S3 da AWS, implementando a interface Storageport.
* */
@Component
public class S3StoregeAdapter implements Storageport {

    private final S3Client s3Client;
    private final String bucketName; /// Nome da bucket
    private String region = "";


    public S3StoregeAdapter(@Value("${aws.s3.bucket-name}") String bucketName,
                           @Value("${aws.s3.region}") String region) {


        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .region(Region.of(this.region))
                .build();


    }




    /// Upload
    @Override
    public String uploadFile(byte[] fileData, String fileName, String contentType) {

        /// Put de uploader dos arquivos como um objeto.
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));



        /// Usando como ponteiros no method Http "%s", para indicar nas posições da Url
        /// os nomes do bucket, região e nome do arquivo.
        return String.format("https://%s.s3.%s.amazonaws.com/%s",
                                bucketName, region, fileName);
    }
}
