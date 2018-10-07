package com.portal.fitness.api.security.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.portal.fitness.api.security.dto.PedidoDto;

@Service
public class PedidoService {

	private SmtpEmailSender smtpEmailSender;

	@Resource
	public void setSmtpEmailSender(SmtpEmailSender smtpEmailSender) {
		this.smtpEmailSender = smtpEmailSender;
	}

	public PedidoDto enviarPedido(PedidoDto obj) {
		obj.setStatusPagamento("Pendente");
		obj.setStatusPedido("Aguardando confirmacao do pagamento");
//		obj.setItem("Camiseta / Nike");
//		obj.setPreco("105.00");
		obj.setIdCliente("4001");

		this.smtpEmailSender.sendOrderConfirmationEmail(obj);
		return obj;
	}

}
