package com.portal.fitness.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.portal.fitness.api.security.entities.Usuario;
import com.portal.fitness.api.security.enums.PerfilEnum;
import com.portal.fitness.api.security.repositories.UsuarioRepository;
import com.portal.fitness.api.utils.SenhaUtils;

@SpringBootApplication
public class P27Application {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(P27Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setEmail("cliente.portal@fitness.com");
			usuario.setPerfil(PerfilEnum.ROLE_CLIENTE);
			usuario.setSenha(SenhaUtils.gerarBCrypt("joao.2018"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@fitness.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("admin.2018"));
			this.usuarioRepository.save(admin);
			
			Usuario parceiro = new Usuario();
			parceiro.setEmail("parceiro.portal@fitness.com");
			parceiro.setPerfil(PerfilEnum.ROLE_PARCEIRO);
			parceiro.setSenha(SenhaUtils.gerarBCrypt("parceiro.2018"));
			this.usuarioRepository.save(parceiro);
			
			
			
		};
	}
}
