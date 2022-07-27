package br.com.qwasolucoes.mentoria.modelagem_dados.empresa;

public class Empresa {
	private String nome;
	private Integer codProfissao;
	private String cnpj;

	public Empresa(String nome, String codProfissao, String cnpj) {
		super();
		this.nome = nome;
		this.codProfissao = Integer.parseInt(codProfissao);
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Empresa [nome :" + nome + ", codProfissao :" + codProfissao + ", cnpj :" + cnpj + "]";
	}

}
