package com.mvp.api_computacaografica.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

@Service
public class ReceberImagemURLService {

    public String obterBase64DeUrl(String urlDaImagem) throws Exception{
            String base64DeUrl;
            URL url = new URL(urlDaImagem);

            try(InputStream is = url.openStream()){
                byte[] bytes = is.readAllBytes();
               return Base64.getEncoder().encodeToString(bytes);
            }
    }
}
