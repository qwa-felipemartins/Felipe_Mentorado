package br.com.qwasolucoes.mentoria.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Funcionario {

	private String nome;

	private String sobrenome;

	private Date dataNascimento;

	private Integer idade;

	private String sexo;

	private String profissao;

	private String cpfCnpj;

	private String escolaridade;

	private BigDecimal salario;

	private boolean maiorIdade;

	private BigDecimal taxa;

	// cria-se novo construtor
	public Funcionario(String nome, String sobrenome, String date, String sexo, String profissao, String cpfCnpj,
			String escolaridade, String salario) throws ParseException {
		this.nome = nome;
		this.sobrenome = sobrenome;
		SimpleDateFormat data = new SimpleDateFormat("ddMMyyyy");
		dataNascimento = data.parse(date);
		this.sexo = sexo;
		this.profissao = profissao;
		this.cpfCnpj = cpfCnpj;
		this.escolaridade = escolaridade;
		this.salario = new BigDecimal(salario);
		this.idade = CalculosAuxiliaresFuncionario.calculaIdade(this);
		this.taxa = CalculosAuxiliaresFuncionario.calculaTaxa(this);
	}

	@Override
	public String toString() {
		Locale.setDefault(Locale.US);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		return "Funcionario [nome:" + nome + ", sobrenome :" + sobrenome + ", dataNascimento :"
				+ data.format(dataNascimento) + ", idade :" + idade + ", sexo :" + sexo + ", profissao :" + profissao
				+ ", cpfCnpj :" + cpfCnpj + ", escolaridade :" + escolaridade + ", salario :"
				+ String.format("%.2f", salario) + ", maiorIdade :" + maiorIdade + ", taxa :"
				+ String.format("%.2f", taxa) + CalculosAuxiliaresFuncionario.informarRisco(this) + "]";
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getProfissao() {
		return profissao;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public boolean isMaiorIdade() {
		return maiorIdade;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public String dataFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String data = sdf.format(this.dataNascimento);
		return data;

	}

	// cria - se o método mostrar
	public String mostrar() {
		return "nome :" + this.nome + ", " + "sobrenome :" + this.sobrenome + ", " + "Data de Nascimento :"
				+ this.dataNascimento + ", " + "Sexo :" + this.sexo + ", " + "Profissão :" + this.profissao + ", "
				+ "CPF :" + this.cpfCnpj + ", " + "Escolaridade :" + this.escolaridade + ", " + "Salario "
				+ this.salario;
	}

	public void setMaiorIdade(boolean maiorIdade) {
		this.maiorIdade = maiorIdade;
	}
}
