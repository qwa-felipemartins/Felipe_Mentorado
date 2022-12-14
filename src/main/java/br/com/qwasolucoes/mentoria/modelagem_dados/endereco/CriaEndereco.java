package br.com.qwasolucoes.mentoria.modelagem_dados.endereco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.CriacaoDeObjetosCSV;
import br.com.qwasolucoes.mentoria.modelagem_dados.profissoes.Profissao;

public class CriaEndereco extends CriacaoDeObjetosCSV {
	public CriaEndereco() {
		super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Endereço.csv";
	}

	@Override
	public <T> List<T> criaObjetos() throws FileNotFoundException, IOException, ParseException {

		List<Contato> enderecos = new ArrayList<>();
		BufferedReader bf = lendoArquivo();
		String line = bf.readLine();
		while (bf.readLine() != null) {

			line = bf.readLine();
			String[] arraySplit = line.split(",");
			enderecos.add(new Contato(arraySplit[0], new TipoEndereco(arraySplit[1]), arraySplit[2], arraySplit[3],
					arraySplit[4], arraySplit[5], arraySplit[6], arraySplit[7], arraySplit[8], arraySplit[9]));

		}
		return (List<T>) enderecos;

	}

}
