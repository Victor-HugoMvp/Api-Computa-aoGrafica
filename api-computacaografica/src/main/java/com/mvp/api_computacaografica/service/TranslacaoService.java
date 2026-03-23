package com.mvp.api_computacaografica.service;

import com.mvp.api_computacaografica.client.ApiComputacaoGraficaClient;
import com.mvp.api_computacaografica.dto.TokenRequestDto;
import com.mvp.api_computacaografica.dto.TokenResponseDto;
import com.mvp.api_computacaografica.dto.TranslacaoRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslacaoService {
    private final ApiComputacaoGraficaClient cliente;
    private final ReceberImagemURLService imageService;
    private final RepassarToken repassarToken;

    public TranslacaoService(ApiComputacaoGraficaClient cliente, ReceberImagemURLService imageService, RepassarToken repassarToken) {
        this.cliente = cliente;
        this.imageService = imageService;
        this.repassarToken = repassarToken;
    }

    public void processar(String urlFoto, int x, int y, String meuToken) throws Exception {
        urlFoto = "https://i.imgur.com/8N4N8N8.png";

        String texto_base64 = imageService.obterBase64DeUrl(urlFoto);
        TranslacaoRequestDto requestDto = new TranslacaoRequestDto(texto_base64, 60, 50);
        cliente.translatarFoto(repassarToken.executarFluxo(), requestDto);
        System.out.println("Translacao Enviada");
    }
}


