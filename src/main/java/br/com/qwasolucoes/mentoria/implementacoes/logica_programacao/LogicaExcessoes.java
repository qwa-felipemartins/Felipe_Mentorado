package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.exceptions.ValidacaoException;
import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.Excecoes;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class LogicaExcessoes extends RuntimeException implements Excecoes {
	LogicaExcessoes(List<Funcionario> funcionario) throws ValidacaoException{
		validarPessoasSemCPF(funcionario);
	}
	
	LogicaExcessoes(){
		System.out.println("Quantidade de caracteres por campo excedida \n[Nome] - 20 posições\r\n"
				+ "	 * [Sobrenome] - 20 posições\r\n"
				+ "	 * [Data de Nascimento] - 8 posições \r\n"
				+ "	 * [SEXO] - 1 posição\r\n"
				+ "	 * [Profissao] - 40 posições\r\n"
				+ "	 * [CPF OU CNPJ] - 14 posições\r\n"
				+ "	 * [Escolaridade] - 40 posições\r\n"
				+ "	 * [Salario] - 10 posições ");
	}
	@Override
	public List<Funcionario> validarPessoasSemCPF(List<Funcionario> pessoas) throws ValidacaoException {
		for (Funcionario func : pessoas) {
			List<Funcionario> invalido = new ArrayList<>();
			if (func.getCpfCnpj() == null) {
				invalido.add(func);
				return invalido;
			}
		}
		return pessoas;
	}
	

	@Override
	public List<Funcionario> validarPessoasSemSalario(List<Funcionario> pessoas) throws ValidacaoException {
		for (Funcionario func : pessoas) {
			List<Funcionario> invalido = new ArrayList<>();
			if (func.getSalario() == null) {
				invalido.add(func);
				return invalido;
			}
		}
		return pessoas;
	}
}
