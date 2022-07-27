package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PessoaEscolaridade {

	private Pessoa pessoa;
	private Formacao formacao;
	public PessoaEscolaridade() {
		
	}
	public PessoaEscolaridade(Pessoa pessoa, Formacao formacao) {
		this.pessoa = pessoa;
		this.formacao = formacao;
	}
	public List<PessoaEndereco> pessoaEndereco() throws FileNotFoundException, IOException, ParseException {
		List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
		List<Formacao> enderecos = new CriaEndereco().criaObjetos();
		List<PessoaEndereco> pessoaEndereco = new ArrayList<>();
		for (int i = 0; i < pessoas.size(); i++) {
			for (int j = 0; j < enderecos.size(); j++) {
				if (pessoas.get(i).getCpf().equals(enderecos.get(j).getCpf())) {
					pessoaEndereco.add(new PessoaEndereco(pessoas.get(i), enderecos.get(j)));

				}
			}

		}
		return pessoaEndereco;
	}
}
