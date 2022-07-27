package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.List;

import br.com.qwasolucoes.mentoria.implementacoes.logica_programacao.Faturamento;

public class Cenario {
	public static void main(String[] args) {

		ArvoreBinariaAlgoritmo x = new ArvoreBinariaAlgoritmo();
		x.adicionar(100);
		x.adicionar(8);
		x.adicionar(300);
		x.adicionar(555);
		x.adicionar(53);
		x.adicionar(566);
		x.adicionar(99999);
		x.adicionar(65);
		x.adicionar(5);
		x.adicionar(-9);
		x.adicionar(-22);
		x.adicionar(99);
		x.adicionar(8898565);
		System.out.println(x.maiorElemento());
		int[] array = x.todosOrdenado();
		for(int arvore : array) {
			System.out.print(arvore+" ");
		}
		
		

	}

}
