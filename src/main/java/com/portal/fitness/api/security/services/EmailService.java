package com.portal.fitness.api.security.services;

import org.springframework.mail.SimpleMailMessage;

import com.portal.fitness.api.security.dto.PedidoDto;

public interface EmailService {
	
   void sendOrderConfirmationEmail(PedidoDto pedidoDto );
   
   void sendEmail(SimpleMailMessage msg);
}
