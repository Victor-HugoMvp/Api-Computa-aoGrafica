package com.mvp.api_computacaografica.service;

import com.mvp.api_computacaografica.client.ApiComputacaoGraficaClient;
import com.mvp.api_computacaografica.dto.TelefoneRequestDto;
import com.mvp.api_computacaografica.dto.TelefoneResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    @Autowired
    ApiComputacaoGraficaClient client;

    public void buscarTelefone(){
        try{
            TelefoneRequestDto request = new TelefoneRequestDto("(34) 996863374");
            TelefoneResponseDto response = client.getTelefone("b982015b7d32306d48c0", request);

            if (response != null && response.msg() != null){
                System.out.println("Telefone cadastrado " + response);
            }
            else{
                System.out.println("Telefone não cadastrado");
            }
        }catch(Exception e){
            throw new RuntimeException("Erro ao realizar requisição");
        }
    }

}