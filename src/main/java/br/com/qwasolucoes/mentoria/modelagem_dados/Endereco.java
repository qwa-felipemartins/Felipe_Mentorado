package br.com.qwasolucoes.mentoria.modelagem_dados;

public class Endereco {
	private String cpf;
	private TipoEndereco tipo;
	private String pais;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;

	public Endereco(String cpf, TipoEndereco tipo, String pais, String rua, String numero, String bairro, String cidade,
			String estado, String cep, String complemento) {
		
		this.cpf = cpf;
		this.tipo = tipo;
		this.pais = pais;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;

	}

	@Override
	public String toString() {
		return "Endereco [cpf :" + cpf + ", tipo :" + tipo + ", pais :" + pais + ", rua :" + rua + ", numero :" + numero
				+ ", bairro :" + bairro + ", cidade :" + cidade + ", estado :" + estado + ", cep :" + cep
				+ ", complemento :" + complemento + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
