package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Ordenacao;

public class OdenacaoAlgoritmo implements Ordenacao {

	@Override
	public int[] ordenar(int[] elementos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] quicksort(int[] elementos) {
		int pivo  = (int) elementos.length / 2;
		for( int i = 0 ; i < elementos.length ; i++) {
			
		}
		return null;
	}

	@Override
	public int[] mergesort(int[] elementos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] bubbleSort(int[] elementos) {

		int aux = 0;

		for (int i = 0; i < elementos.length; i++) {
			for (int j = i + 1; j < (elementos.length); j++) {
				if (elementos[i] > elementos[j]) {
					aux = elementos[i];
					elementos[i] = elementos[j];
					elementos[j] = aux;
				}
			}
		}
		return elementos;
	}

	@Override
	public int[] particaoPositivosNegativos(int[] valores) {
		// TODO Auto-generated method stub
		return null;
	}

}
