package br.com.qwasolucoes.mentoria.modelagem_dados.endereco;

public class TipoEndereco {
	private String tipo;

	public TipoEndereco(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "" + tipo ;
	}
	
	public String getTipo() {
		return tipo;
	}

}
