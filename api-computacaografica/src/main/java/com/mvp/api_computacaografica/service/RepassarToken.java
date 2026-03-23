package com.mvp.api_computacaografica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepassarToken {

    @Autowired
    private TokenService tokenService;

    public String executarFluxo() {
        String meuToken = tokenService.buscarToken();
        return meuToken;
    }
}
