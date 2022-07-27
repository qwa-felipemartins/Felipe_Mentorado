package br.com.qwasolucoes.mentoria.modelagem_dados;

public class InstituicaoEnsino {

	
	
	private Integer codigo;
	private String nome;
	private String area;
	private Integer quantidadeDeSemestre;

	public InstituicaoEnsino(String codigo, String nome, String area, String quantidadeDeSemestre) {
		super();
		this.codigo = Integer.parseInt(codigo);
		this.nome = nome;
		this.area = area;
		this.quantidadeDeSemestre = Integer.parseInt(quantidadeDeSemestre);
	}

	@Override
	public String toString() {
		return "InstituicaoEnsino [codigo :" + codigo + ", nome :" + nome + ", area :" + area + ", quantidadeDeSemestre :"
				+ quantidadeDeSemestre + "]";
	}

	
}
