package com.mvp.api_computacaografica.service;

import com.mvp.api_computacaografica.client.ApiComputacaoGraficaClient;
import com.mvp.api_computacaografica.dto.EscalarRequestDto;
import com.mvp.api_computacaografica.dto.TranslacaoRequestDto;
import org.springframework.stereotype.Service;

@Service
public class EscalarService {
    private final ApiComputacaoGraficaClient cliente;
    private final ReceberImagemURLService imageService;

    public EscalarService(ApiComputacaoGraficaClient cliente, ReceberImagemURLService imageService) {
        this.cliente = cliente;
        this.imageService = imageService;
    }

    public void processar(String urlFoto, int porcentagem) throws Exception {
        urlFoto = "https://i.imgur.com/8N4N8N8.png";

        String texto_base64 = imageService.obterBase64DeUrl(urlFoto);
        EscalarRequestDto requestDto = new EscalarRequestDto(texto_base64, 40);
        cliente.escalarFoto("b982015b7d32306d48c0", requestDto);
        System.out.println("Escala Enviada");
    }
}
