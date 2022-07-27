package br.com.qwasolucoes.mentoria.modelagem_dados.contato;

public enum ContatoTipo {
	TELEFONE(1),
	CELULAR(2),
	EMAIL(3);
	private int valor;
	 ContatoTipo(int valor) {
		this.valor = valor;
	}
	public int getValor() {
		return valor;
	}
}
