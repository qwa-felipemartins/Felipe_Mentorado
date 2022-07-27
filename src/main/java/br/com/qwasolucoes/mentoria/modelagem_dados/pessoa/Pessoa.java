package br.com.qwasolucoes.mentoria.modelagem_dados.pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.contato.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.empresa.Empresa;
import br.com.qwasolucoes.mentoria.modelagem_dados.formacao.Formacao;

public class Pessoa {
	private String nome;
	private String sobreNome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private String estadoCivil;
	private String conjuge;

	public Pessoa(String nome, String sobreNome, String dataNascimento, String sexo, String cpf, String estadoCivil)
			throws ParseException {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate dt1 = LocalDate.parse(dataNascimento, formatter);
		this.dataNascimento = dt1;
		this.sexo = sexo;
		this.cpf = cpf;
		this.estadoCivil = estadoCivil;
		this.conjuge = conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	@Override
	public String toString() {
		if (conjuge != null) {
			return "Pessoa [nome :" + nome + ", sobreNome :" + sobreNome + ", dataNascimento :" + dataNascimento
					+ ", sexo :" + sexo + ", cpf :" + cpf + ", estadoCivil :" + estadoCivil + ", conjuge :" + conjuge
					+ "]";
		} else {
			return "Pessoa [nome :" + nome + ", sobreNome :" + sobreNome + ", dataNascimento :" + dataNascimento
					+ ", sexo :" + sexo + ", cpf :" + cpf + ", estadoCivil :" + estadoCivil + "]";
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConjuge() {
		return conjuge;
	}

}
