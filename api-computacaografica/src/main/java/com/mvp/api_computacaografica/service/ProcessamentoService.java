package com.mvp.api_computacaografica.service;

import com.mvp.api_computacaografica.client.ApiComputacaoGraficaClient;
import com.mvp.api_computacaografica.dto.ProcessarRequestDto;
import com.mvp.api_computacaografica.dto.ProcessarResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ProcessamentoService {

    @Autowired
    ApiComputacaoGraficaClient client;

    public void enviarTextoParaProcessar(String textoPuro){
        try{
            String textoBase64 = Base64.getEncoder().encodeToString(textoPuro.getBytes());

            ProcessarRequestDto request = new ProcessarRequestDto(textoBase64);
            ProcessarResponseDto response = client.processarTexto("b982015b7d32306d48c0", request);

            if(response != null && response.resposta() != null){
                String respostaDoServidor = response.resposta();

                String base64Correto = new StringBuilder(respostaDoServidor).reverse().toString();

                byte[] decodedBytes = Base64.getDecoder().decode(base64Correto);
                String textoInvertido = new String(decodedBytes);

                System.out.println("Texto invertido recebido " + textoInvertido);
            }
        }catch (Exception e){
            System.err.println("Erro no processamento " + e.getMessage());
        }
    }
}
