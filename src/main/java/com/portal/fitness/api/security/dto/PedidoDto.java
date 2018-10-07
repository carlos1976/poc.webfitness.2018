package com.portal.fitness.api.security.dto;


public class PedidoDto {
		
	private Long idPedido;
	private String statusPedido;
	private String CPF;
	
	private String idCliente;
	private String codigoProduto;
	private String item;
	private String descricao;
	private String quantidade;
	private String marca;	
	
	private String preco;
	private String cep; 	
	
	private String statusPagamento;
	private String tipoPagamento;
	private String numeroCartaoCredito;
	private String bandeiraCartaoCredito;
	


	public Long getIdPedido() {
	    idPedido = (long) 1+1;
		return idPedido;
	}
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
		
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNumeroCartaoCredito() {
		return numeroCartaoCredito;
	}

	public void setNumeroCartaoCredito(String numeroCartaoCredito) {
		this.numeroCartaoCredito = numeroCartaoCredito;
	}

	public String getBandeiraCartaoCredito() {
		return bandeiraCartaoCredito;
	}

	public void setBandeiraCartaoCredito(String bandeiraCartaoCredito) {
		this.bandeiraCartaoCredito = bandeiraCartaoCredito;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	
	
     
}
