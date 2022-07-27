package br.com.qwasolucoes.mentoria.modelagem_dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.util.List;

public abstract class CriacaoDeObjetosCSV {
	protected String urlPath;
	

	public CriacaoDeObjetosCSV() {

	}

	public BufferedReader lendoArquivo() throws FileNotFoundException {
		InputStream fis = new FileInputStream(urlPath);
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

	public BufferedWriter escreveObjeto() throws FileNotFoundException {
		OutputStream fos = new FileOutputStream(urlPath);
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		return bw;

	}

	
	public abstract <T> List<T> criaObjetos() throws FileNotFoundException, IOException, ParseException;
	

}
