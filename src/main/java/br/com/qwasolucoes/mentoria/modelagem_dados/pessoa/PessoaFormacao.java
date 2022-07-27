package br.com.qwasolucoes.mentoria.modelagem_dados.pessoa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.contato.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.CriaContato;
import br.com.qwasolucoes.mentoria.modelagem_dados.formacao.CriaFormacao;
import br.com.qwasolucoes.mentoria.modelagem_dados.formacao.Formacao;

public class PessoaFormacao {
	private Pessoa pessoa;
	private Formacao formacao;
	public PessoaFormacao() {
	
	}
	public PessoaFormacao(Pessoa pessoa, Formacao formacao) {
		super();
		this.pessoa = pessoa;
		this.formacao = formacao;
	}
	
	public List<PessoaFormacao> pessoaFormacao() throws FileNotFoundException, IOException, ParseException {
		List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
		List<Formacao> formacao = new CriaFormacao().criaObjetos();
		List<PessoaFormacao> pessoaFormacao = new ArrayList<>();
		for (int i = 0; i < pessoas.size(); i++) {
			for (int j = 0; j < formacao.size(); j++) {
				if (pessoas.get(i).getCpf().equalsIgnoreCase(formacao.get(j).getCpf())) {
					pessoaFormacao.add(new PessoaFormacao(pessoas.get(i), formacao.get(j)));

				}
			}

		}
		return pessoaFormacao;
	}

	
	
	
	
	
	
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	

}
