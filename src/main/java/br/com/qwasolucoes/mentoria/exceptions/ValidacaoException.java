package br.com.qwasolucoes.mentoria.exceptions;

import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.Excecoes;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class ValidacaoException extends Exception implements Excecoes {

	private static final long serialVersionUID = 1L;

	public ValidacaoException(String msg) {
		super(msg);
	}
	public ValidacaoException() {

	}

	@Override
	public List<Funcionario> validarPessoasSemCPF(List<Funcionario> pessoas) throws ValidacaoException {
		
		
		List<Funcionario> listaFuncionarioInvalido = new ArrayList<>();
		for (Funcionario func : pessoas) {

			if (func.getCpfCnpj() == null) {
				listaFuncionarioInvalido.add(func);
				
			}
		}
		if(!listaFuncionarioInvalido.isEmpty()) {
			String mensagemException = "Funcionario sem cpf \n";
			for (Funcionario funcionario : listaFuncionarioInvalido) {
				
			  mensagemException += funcionario.getNome()+"\n";
			}
			throw new ValidacaoException(mensagemException);
		}
		return pessoas;

		
	}

	@Override
	public List<Funcionario> validarPessoasSemSalario(List<Funcionario> pessoas) throws ValidacaoException {
		
		List<Funcionario> listaFuncionarioInvalido = new ArrayList<>();
		for (Funcionario func : pessoas) {

			if (func.getSalario() == null) {
				listaFuncionarioInvalido.add(func);
				
			}
		}
		if(!listaFuncionarioInvalido.isEmpty()) {
			String mensagemException = "Funcionario sem salario \n";
			for (Funcionario funcionario : listaFuncionarioInvalido) {
				
			  mensagemException += funcionario.getNome()+"\n";
			}
			throw new ValidacaoException(mensagemException);
		}
		return pessoas;

	
	}

	public void caracterInvalido() {
		System.out.println("Quantidade de caracteres por campo excedida \n[Nome] - 20 posições\r\n"
				+ "	 * [Sobrenome] - 20 posições\r\n" + "	 * [Data de Nascimento] - 8 posições \r\n"
				+ "	 * [SEXO] - 1 posição\r\n" + "	 * [Profissao] - 40 posições\r\n"
				+ "	 * [CPF OU CNPJ] - 14 posições\r\n" + "	 * [Escolaridade] - 40 posições\r\n"
				+ "	 * [Salario] - 10 posições ");
	}
}
