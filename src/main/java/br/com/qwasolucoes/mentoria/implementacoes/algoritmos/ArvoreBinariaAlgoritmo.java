package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ArvoreBinaria;

public class ArvoreBinariaAlgoritmo implements ArvoreBinaria {

	CelulaArvore raiz;
	int length = 0;

	public ArvoreBinariaAlgoritmo() {
		raiz = null;
	}

	@Override
	public int[] todosOrdenado() {
		int[] array = new int[length];
		CelulaArvore now = raiz;
		int i = 0;
		while (now.getLeft() != null) {
			array[i] = now.getElement();
			now = now.getLeft();
			i++;
		}

		return array;

	}
	
	@Override
	public int primeiro() {
		// TODO Auto-generated method stub
		return 0; 
	}

	@Override
	public int ultimo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionar(int elemento) {
		CelulaArvore elementNew = new CelulaArvore(elemento);
		if (raiz == null) {
			this.raiz = elementNew;
			length++;
		} else {
			CelulaArvore begin = this.raiz;
			while (true) {
				if (elementNew.getElement() < begin.getElement()) {
					if (begin.getLeft() != null) {
						begin = begin.getLeft();
					} else {
						begin.setLeft(elementNew);
						begin.getLeft().setBefore(begin);
						;
						length++;
						break;
					}
				} else {
					if (begin.getRight() != null) {
						begin = begin.getRight();
					} else {
						begin.setRight(elementNew);
						begin.getRight().setBefore(begin);
						length++;
						break;
					}
				}
			}

		}

	}

	public int menorElmento() {
		CelulaArvore menor = raiz;
		while (menor.getLeft() != null) {
			menor = menor.getLeft();
		}
		return menor.getElement();
	}

	public int maiorElemento() {
		CelulaArvore maior = raiz;
		while (maior.getRight() != null) {
			maior = maior.getRight();
		}
		return maior.getElement();
	}

}
