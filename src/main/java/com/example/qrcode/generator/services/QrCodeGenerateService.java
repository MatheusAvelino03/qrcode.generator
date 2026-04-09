package com.example.qrcode.generator.services;

import com.example.qrcode.generator.dtoqrcode.QrCodeGenerateResponse;
import com.example.qrcode.generator.port.Storageport;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGenerateService {

    /// Atributo
    private Storageport storageport;

    /// Constructor
    public QrCodeGenerateService(Storageport storage) {

        this.storageport = storage;
    }

    public QrCodeGenerateResponse generateAndUploadQrCode(String data) throws WriterException, IOException {
        // Lógica para generar o código QR a partir dos dados porporcionados
        // Aquí pode usar uma biblioteca de geração de códigos QR, como ZXing
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        /// O tipo de código de barras é QR_CODE, e as dimensões são 200x200 pixels
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        // Aqui você pode converter o BitMatrix em um formato de imagem (por exemplo, PNG)
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        /// Array de bytes contendo a imagem do código QR gerada
        byte[] pngQrCodeData = pngOutputStream.toByteArray();


        /// Usando UUID para nomear arquivos únicos e evitar conflitos de nomes
        String url = storageport.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "/image.png");


        return new QrCodeGenerateResponse(url);
    }

}