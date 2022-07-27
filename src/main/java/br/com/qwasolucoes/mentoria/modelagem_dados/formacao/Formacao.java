package br.com.qwasolucoes.mentoria.modelagem_dados.formacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formacao {
	private String cpf;
	private Integer codigo;
	private String concluido;
	private LocalDate dataTermino;
	private Integer semestreAtual;

	public Formacao(String cpf, String codigo, String concluido) throws ParseException {
		super();
		this.cpf = cpf;
		this.codigo = Integer.parseInt(codigo);
		this.concluido = concluido;

	}

	public void setDataTermino(String dataTermino) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate dt1 = LocalDate.parse(dataTermino, formatter);
		this.dataTermino = dt1;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getConcluido() {
		return concluido;
	}

	public void setConcluido(String concluido) {
		this.concluido = concluido;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Integer getSemestreAtual() {
		return semestreAtual;
	}

	public void setSemestreAtual(Integer semestreAtual) {
		this.semestreAtual = semestreAtual;
	}

	public void setSemestreAtual(String semestreAtual) {
		this.semestreAtual = Integer.parseInt(semestreAtual);
	}

	@Override
	public String toString() {
		if (semestreAtual != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return "Formacao [cpf :" + cpf + ", codigo :" + codigo + ", concluido :" + concluido + ", dataTermino :"
					+ sdf.format(dataTermino) + ", semestreAtual :" + semestreAtual + "]";
		} else {
			return "Formacao [cpf :" + cpf + ", codigo :" + codigo + ", concluido :" + concluido;

		}
	}

}
