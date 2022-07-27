package br.com.qwasolucoes.mentoria.modelagem_dados.formacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.CriacaoDeObjetosCSV;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.TipoContato;

public class CriaFormacao extends CriacaoDeObjetosCSV {

	public CriaFormacao() {
		super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Escolaridade.csv";
	}

	@Override
	public <T> List<T> criaObjetos() throws FileNotFoundException, IOException, ParseException {
		List<Formacao> formacao = new ArrayList<>();
		BufferedReader bf = lendoArquivo();
		String line = bf.readLine();
		while (bf.readLine() != null) {
			line = bf.readLine();
			System.out.println(line);
			String[] arraySplit = line.split(",");
			if (arraySplit[2].equalsIgnoreCase("Nao") && arraySplit.length == 5) {
				Formacao form = new Formacao(arraySplit[0], arraySplit[1], arraySplit[2]);
				form.setDataTermino(arraySplit[3]);
				form.setSemestreAtual(arraySplit[4]);
				formacao.add(form);
			} else {
				formacao.add(new Formacao(arraySplit[0], arraySplit[1], arraySplit[2]));
			}

		}
		return (List<T>) formacao;

	}

}
