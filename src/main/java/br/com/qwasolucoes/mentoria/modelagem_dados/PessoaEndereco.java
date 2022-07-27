package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PessoaEndereco {
	private Pessoa pessoa;
	private Endereco endereco;

	public PessoaEndereco() {

	}

	public PessoaEndereco(Pessoa pessoa, Endereco endereco) {
		this.pessoa = pessoa;
		this.endereco = endereco;
	}

	public List<PessoaEndereco> pessoaEndereco() throws FileNotFoundException, IOException, ParseException {
		List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
		List<Endereco> enderecos = new CriaEndereco().criaObjetos();
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa :" + pessoa.toString() + " \n\r Endereço :" + endereco.toString();
	}

}
