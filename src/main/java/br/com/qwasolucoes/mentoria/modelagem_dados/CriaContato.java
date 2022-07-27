package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriaContato extends CriacaoDeObjetosCSV {
	public CriaContato() {
		super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Contato.csv";
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> criaObjetos() throws IOException {

		List<Contato> contatos = new ArrayList<>();
		BufferedReader bf = lendoArquivo();
		String line = bf.readLine();
		while (bf.readLine() != null) {
			line = bf.readLine();
			String[] arraySplit = line.split(",");
			contatos.add(new Contato(arraySplit[0], new TipoContato(arraySplit[1]), arraySplit[2]));
			

		}
		return (List<T>) contatos;
	}

}


