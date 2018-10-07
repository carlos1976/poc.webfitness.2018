package com.portal.fitness.api.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portal.fitness.api.response.Response;
import com.portal.fitness.api.security.dto.UsuarioDto;
import com.portal.fitness.api.security.entities.Usuario;
import com.portal.fitness.api.security.enums.PerfilEnum;
import com.portal.fitness.api.security.repositories.UsuarioRepository;
import com.portal.fitness.api.utils.SenhaUtils;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<UsuarioDto>> cadastrarLogin(@Valid @RequestBody UsuarioDto usuarioDto,
			BindingResult result) {
		Response<UsuarioDto> response = new Response<UsuarioDto>();

		Usuario admin = new Usuario();
		admin.setEmail(usuarioDto.getEmail());
		admin.setPerfil(PerfilEnum.ROLE_ADMIN);
		admin.setSenha(SenhaUtils.gerarBCrypt(usuarioDto.getSenha()));
		//usuarioDto.setSenha(admin.getSenha());
		this.usuarioRepository.save(admin);
		// result.getAllErrors().forEach(error ->
		// response.getErrors().add(error.getDefaultMessage()));
		// return ResponseEntity.badRequest().body(response);

		usuarioDto.setMensagem("Usuario cadastrado com sucesso");
		response.setData(usuarioDto);
		return ResponseEntity.ok(response);

	}

}
