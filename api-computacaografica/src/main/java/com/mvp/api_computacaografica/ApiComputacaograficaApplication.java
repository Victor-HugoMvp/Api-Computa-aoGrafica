package com.mvp.api_computacaografica;

import com.mvp.api_computacaografica.service.FotoService;
import com.mvp.api_computacaografica.service.ProcessamentoService;
import com.mvp.api_computacaografica.service.TelefoneService;
import com.mvp.api_computacaografica.service.TokenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class ApiComputacaograficaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiComputacaograficaApplication.class, args);
	}

	@Bean
	CommandLineRunner executarAoIniciar(TokenService tokenService) {
		return args -> {
			System.out.println(">>> Iniciando chamada automática do serviço...");
			tokenService.buscarToken();
		};
	}


	@Bean
	CommandLineRunner testeProcessamento(ProcessamentoService service) {
		return args -> {
			service.enviarTextoParaProcessar("Olá Mundo!");
		};
	}

	@Bean
	CommandLineRunner testeCadastrarTelefone(TelefoneService telefoneService){
		return args -> {
			telefoneService.buscarTelefone();
		};
	}

	@Bean
	CommandLineRunner testeenviarImagem(FotoService fotoService){
		return args -> {
			fotoService.buscarImagem();	
		};
	}

}
