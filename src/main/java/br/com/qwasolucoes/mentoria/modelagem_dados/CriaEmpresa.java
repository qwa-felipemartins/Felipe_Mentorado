package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriaEmpresa extends CriacaoDeObjetosCSV {
	public CriaEmpresa() {
		super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Empresa.csv";
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> criaObjetos() throws FileNotFoundException, IOException {
		List<Empresa> empresas = new ArrayList<>();
		BufferedReader bf = lendoArquivo();
		String line = bf.readLine();
		while (bf.readLine() != null) {
			line = bf.readLine();
			String[] arraySplit = line.split(",");

			empresas.add(new Empresa(arraySplit[0], arraySplit[1], arraySplit[2]));
		}
		return (List<T>) empresas;
	}

}
