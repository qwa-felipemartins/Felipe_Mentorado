package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PessoaContato {

	private Pessoa pessoa;
	private Contato contato;

	public PessoaContato() {

	}

	public PessoaContato(Pessoa pessoa, Contato contato) {
		this.pessoa = pessoa;
		this.contato = contato;
	}

	public List<PessoaContato> pessoaContato() throws FileNotFoundException, IOException, ParseException {
		List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
		List<Contato> contatos = new CriaContato().criaObjetos();
		List<PessoaContato> pessoaContato = new ArrayList<>();
		for (int i = 0; i < pessoas.size(); i++) {
			for (int j = 0; j < contatos.size(); j++) {
				if (pessoas.get(i).getCpf().equalsIgnoreCase(contatos.get(j).getCpf())) {
					pessoaContato.add(new PessoaContato(pessoas.get(i), contatos.get(j)));

				}
			}

		}
		return pessoaContato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "" + pessoa.toString() + ", contato :" + contato.toString() + "";
	}

}



