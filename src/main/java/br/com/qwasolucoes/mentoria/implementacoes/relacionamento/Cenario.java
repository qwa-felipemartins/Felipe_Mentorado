package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.profissoes.CriaProfissao;
import br.com.qwasolucoes.mentoria.modelagem_dados.profissoes.Profissao;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaContato;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaEndereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaProfissao;
public class Cenario {
	public static void main(String[] args) throws IOException, ParseException {
		// List<Contato> x = new CriaContato().criaObjetos();


		RelacionamentoBusca busca = new RelacionamentoBusca();
		
		List<Pessoa> aaa =  busca.buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao("casado", "Tecnologia da Informacao", null);
	
		System.out.println(aaa);
		

	}

}
