package com.mvp.api_computacaografica.client;

import com.mvp.api_computacaografica.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "computacao-grafica",
        url = "${computacao.grafica-url}", configuration = FeignConfig.class)
public interface ApiComputacaoGraficaClient {

    @PostMapping("webhook/token")
    TokenResponseDto getToken(@RequestBody TokenRequestDto request);

    @PostMapping("webhook/cadastra_telefone")
    TelefoneResponseDto getTelefone(
            @RequestHeader("Authorization") String auth,
            @RequestBody TelefoneRequestDto requestTelefone
    );

    @PostMapping("webhook/processar")
    ProcessarResponseDto processarTexto(
            @RequestHeader("Authorization") String auth,
            @RequestBody ProcessarRequestDto request
    );

    @PostMapping("webhook/foto")
    FotoResponseDto getFoto(
            @RequestHeader("Authorization") String auth,
            @RequestBody FotoRequestDto request
    );

    @PostMapping("webhook/translacao")
    TranslacaoRequestDto translatarFoto(
            @RequestHeader("Authorization") String auth,
            @RequestBody TranslacaoRequestDto request
    );

    @PostMapping("webhook/escala")
    EscalarRequestDto escalarFoto(
            @RequestHeader("Authorization") String auth,
            @RequestBody EscalarRequestDto request
    );
}
