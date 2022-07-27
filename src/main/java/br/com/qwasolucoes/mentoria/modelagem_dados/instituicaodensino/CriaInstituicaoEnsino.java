package br.com.qwasolucoes.mentoria.modelagem_dados.instituicaodensino;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.modelagem_dados.CriacaoDeObjetosCSV;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.TipoContato;

public class CriaInstituicaoEnsino extends CriacaoDeObjetosCSV {
	public CriaInstituicaoEnsino() {
		super.urlPath = super.urlPath = "src/main/resources/br/com/qwasolucoes/mentoria/modelagem_dados/Instituição de Ensino.csv";
	}

	@Override
	public <T> List<T> criaObjetos() throws FileNotFoundException, IOException {
		List<InstituicaoEnsino> instituicaoEnsino = new ArrayList<>();
		BufferedReader bf = lendoArquivo();

		while (bf.readLine() != null) {
			String line = bf.readLine();
			String[] arraySplit = line.split(",");
			instituicaoEnsino.add(new InstituicaoEnsino(arraySplit[0], arraySplit[1], arraySplit[2], arraySplit[3]));
		}
		return (List<T>) instituicaoEnsino;

	}

}
