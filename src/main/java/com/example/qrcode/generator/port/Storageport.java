package com.example.qrcode.generator.port;


/*
* Interface de Upload de arquivos
* */
public interface Storageport {

    /// Tipo do meu arquivo
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
