package com.mvp.api_computacaografica.service;

import com.mvp.api_computacaografica.client.ApiComputacaoGraficaClient;
import com.mvp.api_computacaografica.dto.TokenRequestDto;
import com.mvp.api_computacaografica.dto.TokenResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private ApiComputacaoGraficaClient client;

    public String buscarToken(){
        try{
            TokenRequestDto request = new TokenRequestDto("VICTOR HUGO MARCELINO FRAGA");
            TokenResponseDto response = client.getToken(request);

            if (response != null && response.token() != null) {
                return response.token(); // Retorna o valor para quem chamou
            } else {
                throw new RuntimeException("Token não encontrado na resposta da API.");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("Erro ao realizar requisição");
        }
    }
}
