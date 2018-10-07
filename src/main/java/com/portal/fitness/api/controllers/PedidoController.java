package com.portal.fitness.api.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portal.fitness.api.response.Response;
import com.portal.fitness.api.security.dto.PedidoDto;
import com.portal.fitness.api.security.services.PedidoService;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	private PedidoService pedidoService;

	@Resource
	public void setPedidoService(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping(value = "/{ordem}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String enviar(@PathVariable("ordem") String ordem) {
		PedidoDto pedidoDto = new PedidoDto();
		pedidoDto.setCodigoProduto("9999");
		return "ordem do pedido : " + ordem;
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('CLIENTE')")
	public ResponseEntity<Response<PedidoDto>> enviarPedido(@Valid @RequestBody PedidoDto pedidoDto,
			BindingResult result) {
		Response<PedidoDto> response = new Response<PedidoDto>();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		pedidoDto = this.pedidoService.enviarPedido(pedidoDto);
		response.setData(pedidoDto);

		return ResponseEntity.ok(response);

	}


}
