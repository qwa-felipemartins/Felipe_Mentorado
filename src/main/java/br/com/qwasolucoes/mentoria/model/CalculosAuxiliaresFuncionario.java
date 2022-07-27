package br.com.qwasolucoes.mentoria.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculosAuxiliaresFuncionario {
	public static Integer calculaIdade(Funcionario funcionario) {
		Date dataHoje = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int anoAtual = Integer.parseInt(sdf.format(dataHoje));
		int anoNascimento = Integer.parseInt(sdf.format(funcionario.getDataNascimento()));
		int idade = anoAtual - anoNascimento;
		if(idade >= 18) {
			funcionario.setMaiorIdade(true);
		}
		return idade;

	}

	public static String informarRisco(Funcionario funcionario) {
		
		if (funcionario.getIdade() < 18) {
			return "MENOR_IDADE: Para idade até 18 anos (Aplicar 20% na Taxa)";
		}
		if (funcionario.getIdade() >= 18 && funcionario.getIdade() <= 23) {
			return " RISCO_ALTO: Entre 18 e 23 anos. (Aplicar 15% na Taxa)";
		}
		if (funcionario.getIdade() > 24 && funcionario.getIdade() <= 31) {
			return "RISCO_MODERADO: Entre 24 e 31 anos. (Aplicar 10% na Taxa)";
		}
		if (funcionario.getIdade() > 32 && funcionario.getIdade() < 50) {
			return "RISCO_BAIXO: Entre 32 e 50 anos. (Aplicar 5% na Taxa)";
		}
		if (funcionario.getIdade() > 50) {
			return "ESPECIAL: Acima de 50 anos. (Aplicar 1% na Taxa)";
		}
		return null;
	}

	public static BigDecimal calculaTaxa(Funcionario funcionario) {
		
		if (funcionario.getIdade() < 18) {
			return funcionario.getSalario().multiply(new BigDecimal(0.2));
		} else if (funcionario.getIdade() >= 18 && funcionario.getIdade() <= 23) {
			return funcionario.getSalario().multiply(new BigDecimal(0.15));
		} else if (funcionario.getIdade() >= 24 && funcionario.getIdade() <= 31) {
			return funcionario.getSalario().multiply(new BigDecimal(0.1));
		} else if (funcionario.getIdade()>= 32 && funcionario.getIdade() <= 50) {
			return funcionario.getSalario().multiply(new BigDecimal(0.05));
		} else if (funcionario.getIdade() > 50) {
			return funcionario.getSalario().multiply(new BigDecimal(0.01));
		} else {
			return null;
		}
	}

}
