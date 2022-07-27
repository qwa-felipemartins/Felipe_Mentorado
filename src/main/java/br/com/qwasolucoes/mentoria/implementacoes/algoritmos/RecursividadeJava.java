package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Recursao;

public class RecursividadeJava implements Recursao {

	@Override
	public int recursao(int valor, int limite) {
		if (valor < 0) {
			throw new IllegalArgumentException("O valor passado como inicio deve ser maior que 0");
		}
		System.out.print(valor + "  ");
		while (valor < limite) {
			valor++;
			return recursao(valor, limite);
		}

		return valor;
	}

	@Override
	public int recursaoSoma(int valor, int limite) {
		int soma = 0;
		if (valor < 0) {
			throw new IllegalArgumentException("O valor passado como inicio deve ser maior que 0");
		}
		while (valor < limite) {
		
			valor++;
			soma += recursaoSoma(valor, limite);
			
		}
		System.out.print(soma);
		return valor;

	}

	@Override
	public int recursaoFibonacci(int valor, int limite) {
		// TODO Auto-generated method stub
		return 0;
	}

}
