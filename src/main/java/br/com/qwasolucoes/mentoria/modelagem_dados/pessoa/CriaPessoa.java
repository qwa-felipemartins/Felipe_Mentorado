package br.com.qwasolucoes.mentoria.modelagem_dados.pessoa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.CriacaoDeObjetosCSV;
import br.com.qwasolucoes.mentoria.modelagem_dados.instituicaodensino.InstituicaoEnsino;

public class CriaPessoa extends CriacaoDeObjetosCSV {
	public CriaPessoa() {
		super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Pessoa.csv";
	}

	@Override
	public <T> List<T> criaObjetos() throws FileNotFoundException, IOException, ParseException {
		boolean flag = true;
		List<Pessoa> pessoas = new ArrayList<>();
		BufferedReader bf = lendoArquivo();
		String line = bf.readLine();
		while (line != null) {
			line = bf.readLine();
			if (line == null) {
				break;
			}
			String[] arraySplit = line.split(",");
			if (arraySplit[5].equalsIgnoreCase("SOLTEIRO")) {
				pessoas.add(new Pessoa(arraySplit[0], arraySplit[1], arraySplit[2], arraySplit[3], arraySplit[4],
						arraySplit[5]));
			} else {
				Pessoa pessoa = new Pessoa(arraySplit[0], arraySplit[1], arraySplit[2], arraySplit[3], arraySplit[4],
						arraySplit[5]);
				pessoa.setConjuge(arraySplit[6]);
				pessoas.add(pessoa);
			}

		}
		return (List<T>) pessoas;
	}
}
