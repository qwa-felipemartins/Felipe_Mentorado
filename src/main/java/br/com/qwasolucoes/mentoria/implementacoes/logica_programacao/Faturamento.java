package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacaoFaturamento;

public class Faturamento implements LogicaProgramacaoFaturamento {

	private Integer valor[] = new Integer[16];
	int qtdFaturamento = 0;

	@Override
	public void adicionarFaturamentoSemanal(int faturamento) {
		try {
			if (qtdFaturamento >= valor.length) {
				throw new IllegalArgumentException(
						"Excedida a quantidade de semanas a se adicionar, o programa comporta apenas 16 semanas por objeto");
			}
			for (int i = 0; i < valor.length; i++) {
				if (valor[i] == null) {
					valor[i] = faturamento;
					qtdFaturamento++;
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int[] obterFaturamentosSemanais() {
		int[] faturamentoSemanal = new int[valor.length];
		for (int i = 0; i < valor.length; i++) {

			faturamentoSemanal[i] = valor[i];

		}
		return faturamentoSemanal;
	}

	@Override
	public int calcularFaturamentoTotal() {
		int faturamentoTotal = 0;
		for (int i = 0; i < valor.length; i++) {
			if (valor[i] != null) {
				faturamentoTotal += valor[i];
			}
		}
		return faturamentoTotal;
	}

	@Override
	public int[] calcularFaturamentoMensal() {
		int[] faturamentoMensal = new int[4];
		try {
			int mensal = 0;
			int div = 0;
			int indexFatMensal = 0;
			for (int i = 0; i < valor.length; i++) {
				if (valor[i] != null) {
					mensal += valor[i];
					div++;
				} else {
					throw new NullPointerException("Para calculo mensal , as semanas não podem ser nulas");
				}
				if (div % 4 == 0) {
					faturamentoMensal[indexFatMensal] = mensal;
					indexFatMensal++;
					mensal = 0;
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		return faturamentoMensal;
	}

	@Override
	public int[] calcularFaturamentoBimestral() {
		int[] faturamentoBimestral = new int[2];
		try {
			int bimestral = 0;
			int div = 0;
			int indexFatBimestral = 0;
			for (int i = 0; i < valor.length; i++) {
				if (valor[i] != null) {

					bimestral += valor[i];
					div++;
				} else {
					throw new NullPointerException("Para calculo mensal , as semanas não podem ser nulas");
				}

				if (div % 8 == 0) {
					faturamentoBimestral[indexFatBimestral] = bimestral;
					indexFatBimestral++;
					bimestral = 0;
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return faturamentoBimestral;
	}

	@Override
	public int calcularFaturamentoMedio() {
		int soma = 0;
		int media = 0;
		for (int i = 0; i < valor.length; i++) {
			if (valor[i] != null) {
				soma += valor[i];
			}
			if (i == (valor.length - 1)) {
				media = (int) soma / i;
			}
		}
		return media;
	}

	@Override
	public int[] calcularFaturamentoMedioDoMes() {
		int[] faturamentoMedioMensal = calcularFaturamentoMensal();
		for (int i = 0; i < faturamentoMedioMensal.length; i++) {
			faturamentoMedioMensal[i] = (int) faturamentoMedioMensal[i] / 4;

		}

		return faturamentoMedioMensal;
	}

	@Override
	public int[] calcularFaturamentoMedioPorSemanaDoMes() {
		int[] faturamentoMedio = new int[4];
		int contador = 0;
		int soma = 0;
		int somadorDeSemanas = 0;
		int indexFaturamentoMedio = 0;
		while (indexFaturamentoMedio < 4) {
			soma += valor[somadorDeSemanas];
			somadorDeSemanas += 4;
			contador++;
			if (contador == 3) {
				faturamentoMedio[indexFaturamentoMedio] = (int) soma / 4;
				indexFaturamentoMedio++;
				somadorDeSemanas = indexFaturamentoMedio;
				soma = 0;
				contador = 0;
			}

		}
		return faturamentoMedio;
	}

	@Override
	public int obterMesMaiorFaturamento() {
		int[] faturamentoMensal = organizaArrayMensal();
		return faturamentoMensal[3];

	}

	@Override
	public int obterMesMenorFaturamento() {
		int[] faturamentoMensal = organizaArrayMensal();
		return faturamentoMensal[0];
	}

	// cria - metodo que orgzaniza o array;
	private int[] organizaArrayMensal() {
		int aux = 0;
		int[] faturamentoMensal = calcularFaturamentoMensal();
		for (int i = 0; i < faturamentoMensal.length; i++) {
			for (int j = i + 1; j < (faturamentoMensal.length); j++) {
				if (faturamentoMensal[i] > faturamentoMensal[j]) {
					aux = faturamentoMensal[i];
					faturamentoMensal[i] = faturamentoMensal[j];
					faturamentoMensal[j] = aux;
				}
			}
		}
		return faturamentoMensal;
	}
}
