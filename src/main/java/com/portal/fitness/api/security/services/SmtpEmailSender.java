package com.portal.fitness.api.security.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.portal.fitness.api.security.dto.PedidoDto;


@Service
public class SmtpEmailSender implements EmailService {

	@Autowired
	private MailSender mailSender;
	
	public static final String MSG_EMAIL = "Seu pedido foi recebido com sucesso. Aguarde a confirmação do pagamento";

	@Override
	public void sendOrderConfirmationEmail(PedidoDto pedidoDto) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(pedidoDto);
		sendEmail(sm);
	}

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		System.out.println("Enviando Email...");
		mailSender.send(msg);
		System.out.println("Sucesso...");
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(PedidoDto obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo("poc.portal.fitness@gmail.com");
		sm.setFrom("carlosalberto6791@gmail.com");
		sm.setSubject("Pedido Confirmado! Código do Pedido " + 2100);
		sm.setSentDate(new Date(System.currentTimeMillis()));
		
		StringBuilder sb = new StringBuilder();
		sb.append("Seu pedido foi recebido com sucesso. Aguarde a confirmação do pagamento.\n");		
		sb.append("\n" );
		sb.append("Código do Produto : " + obj.getCodigoProduto() + "\n");
		sb.append("Descrição do Produto :" + obj.getDescricao() + "\n");
		sb.append("Preço : R$ " + obj.getPreco() + "\n");
		sb.append("Status do Pagamento : "+ "Pendente \n" );
		sb.append("\n" );
		sb.append(" Atenciosamente \n");
		sb.append(" Portal Web Fintness ");
		sm.setText(sb.toString());

		return sm;
	}

}
