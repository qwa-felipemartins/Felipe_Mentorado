package br.com.qwasolucoes.mentoria.modelagem_dados.contato;

public class Contato {
	private String cpf;
	private TipoContato tipo;
	private String valor;
	public Contato(String cpf, TipoContato tipo, String valor) {
		super();
		this.cpf = cpf;
		this.tipo = tipo;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Contato [cpf : " + cpf + ", tipo :" + tipo.getTipo() + ", valor :" + valor + "]";
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TipoContato getTipo() {
		return tipo;
	}
	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
