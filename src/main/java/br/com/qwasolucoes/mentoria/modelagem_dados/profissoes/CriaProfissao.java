package br.com.qwasolucoes.mentoria.modelagem_dados.profissoes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.CriacaoDeObjetosCSV;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.TipoContato;

public class CriaProfissao extends CriacaoDeObjetosCSV {
	public CriaProfissao() {
		super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Profissão.csv";
	}

	@Override
	public <T> List<T> criaObjetos() throws FileNotFoundException, IOException {

		List<Profissao> profissoes = new ArrayList<>();
		BufferedReader bf = lendoArquivo();
		while (bf.readLine() != null) {
			
			String line = bf.readLine();
			String[] arraySplit = line.split(",");
			profissoes.add(new Profissao(arraySplit[0], arraySplit[1], arraySplit[2], arraySplit[3]));

		}
		return (List<T>) profissoes;

	}

}
