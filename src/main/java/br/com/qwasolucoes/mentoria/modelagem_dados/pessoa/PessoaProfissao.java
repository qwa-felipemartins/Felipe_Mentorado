package br.com.qwasolucoes.mentoria.modelagem_dados.pessoa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import br.com.qwasolucoes.mentoria.modelagem_dados.profissoes.CriaProfissao;
import br.com.qwasolucoes.mentoria.modelagem_dados.profissoes.Profissao;

public class PessoaProfissao {
	private Pessoa pessoa;
	private Profissao profissao;

	public PessoaProfissao() {

	}

	public PessoaProfissao(Pessoa pessoa, Profissao profissao) {
		this.pessoa = pessoa;
		this.profissao = profissao;
	}

	public List<PessoaProfissao> pessoaProfissao() throws FileNotFoundException, IOException, ParseException {
		List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
		List<Profissao> profissoes = new CriaProfissao().criaObjetos();
		List<PessoaProfissao> pessoaProfissao = new ArrayList<>();
		for (int i = 0; i < profissoes.size(); i++) {
			
			pessoaProfissao.add(new PessoaProfissao(pessoas.get(i), profissoes.get(i)));

		}

		return pessoaProfissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return   pessoa + ", " + profissao ;
	}

}
