package com.example.qrcode.generator.controller;


import com.example.qrcode.generator.dtoqrcode.QrCodeGenerateResponse;
import com.example.qrcode.generator.dtoqrcode.QrCodeGenerateResquest;
import com.example.qrcode.generator.services.QrCodeGenerateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode") /// Mapeando o endpoint que será passado
public class QrCodeController {

    private final QrCodeGenerateService qrCodeService;

    public QrCodeController(QrCodeGenerateService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }


    /// Método que será usadado para faer a geração.
    @PostMapping /// Vai ouvir o método Post do Protocolo HTTP
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateResquest resquest){


        try {

            /// Salva o valor dentro de uma variável
            QrCodeGenerateResponse response = this.qrCodeService.generateAndUploadQrCode(resquest.text());

                    /// Retorna o valor da variável dentro do corpo da resposta, com o status HTTP 200 (OK)
                    return ResponseEntity.ok(response);

        } catch (Exception e) {

            /// Retorna o erro caso não consiga acessa a primeira tentativa
            return ResponseEntity.internalServerError().build();
        }
    }

}
