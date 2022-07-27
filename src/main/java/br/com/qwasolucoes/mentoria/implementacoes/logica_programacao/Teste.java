package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		List<String> gg = new ArrayList<>();
		String[][] a = new String[7][8];
		int i = 0;
		int n = 0;
		while (i < 8) {
			for (int j = 0; j < a.length; j++) {
				a[j][i] = "a";
				gg.add(a[j][i]);

			}
			//return conversaoStringParaPessoa(gg);
			//
			i++;

		}
		System.out.println(n);

	}

}
