package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.math.BigDecimal;

public class Profissao {
	private Integer codProfissao;
	private String nomeProfissao;
	private String areaAtuacao;
	private BigDecimal salarioBase;
	public Profissao(String codProfissao, String nomeProfissao, String areaAtuacao, String salarioBase) {
		super();
		
		this.codProfissao = Integer.parseInt(codProfissao.substring(1, 2));
		this.nomeProfissao = nomeProfissao;
		this.areaAtuacao = areaAtuacao;
		this.salarioBase = new BigDecimal(Double.parseDouble(salarioBase.substring(2)) * 1000);
	}
	@Override
	public String toString() {
		return "Profissao [codProfissao :" + codProfissao + ", nomeProfissao :" + nomeProfissao + ", areaAtuacao : "
				+ areaAtuacao + ", salarioBase :" + salarioBase + "]";
	}
	public Integer getCodProfissao() {
		return codProfissao;
	}
	public void setCodProfissao(Integer codProfissao) {
		this.codProfissao = codProfissao;
	}
	public String getNomeProfissao() {
		return nomeProfissao;
	}
	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	public BigDecimal getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(BigDecimal salarioBase) {
		this.salarioBase = salarioBase;
	}

}
