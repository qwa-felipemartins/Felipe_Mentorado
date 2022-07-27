package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formacao {
	private String cpf;
	private String codigo;
	private String concluido;
	private LocalDate dataTermino;
	private Integer semestreAtual;

	public Formacao(String cpf, String codigo, String concluido) throws ParseException {
		super();
		this.cpf = cpf;
		this.codigo = codigo;
		this.concluido = concluido;

	}

	public void setDataTermino(String dataTermino) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate dt1 = LocalDate.parse(dataTermino, formatter);
		this.dataTermino = dt1;
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
