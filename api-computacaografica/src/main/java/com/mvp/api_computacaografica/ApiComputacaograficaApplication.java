package com.mvp.api_computacaografica;

import com.mvp.api_computacaografica.service.*; // Importa todos os services
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
	CommandLineRunner executarTudo(
			TokenService tokenService,
			ProcessamentoService processamentoService,
			TelefoneService telefoneService,
			FotoService fotoService,
			TranslacaoService translacaoService,
			EscalarService escalarService
	) {
		return args -> {
			System.out.println(">>> Iniciando fluxo completo de computação gráfica...");


			tokenService.buscarToken();
			telefoneService.buscarTelefone();
			fotoService.buscarImagem();
			processamentoService.enviarTextoParaProcessar("Olá Mundo!");


			String url = "https://m.media-amazon.com/images/M/MV5BMTMwNzIyMDcxNF5BMl5BanBnXkFtZTcwMDM4ODcyMw@@._V1_.jpg";
			String token = "b982015b7d32306d48c0";


			System.out.println(">>> Executando Translação...");
			translacaoService.processar(url, 60, 50, token);


			System.out.println(">>> Executando Escala...");
			escalarService.processar(url, 40);
		};
	}
}