package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import java.math.BigDecimal;
import java.rmi.UnexpectedException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import br.com.qwasolucoes.mentoria.exceptions.ValidacaoException;
import br.com.qwasolucoes.mentoria.interfaces.logica_programacao.LogicaProgramacao;
import br.com.qwasolucoes.mentoria.model.Funcionario;

public class LogicaProgramacaoProvider implements LogicaProgramacao {

	@Override
	public List<Funcionario> conversaoStringParaPessoa(List<String> lista) {

		List<Funcionario> listaFuncionario = new ArrayList<>();
		try {
			int i = 0;
			int j = 0;
			if (validaLista(lista, i)) {

				while (j < lista.size()) {
					if (j == 0 || j % 8 == 0) {

						listaFuncionario.add(
								// i+1?
								new Funcionario(lista.get(i), lista.get(1 + i), lista.get(2 + i), lista.get(3 + i),
										lista.get(4 + i), lista.get(5 + i), lista.get(6 + i), lista.get(7 + i)));
						i += 8;
					}
					j++;
					// lançar exceção
					// lancar exceção tambem caso a lista vinda não estiver completa com 8
					// informaçoes em cada, no minimo essa lista tem de ser de um multiplo de 8
				}
			}
			new ValidacaoException().validarPessoasSemCPF(listaFuncionario);
			new ValidacaoException().validarPessoasSemSalario(listaFuncionario);
		} catch (ValidacaoException e) {
			System.out.println(e.getMessage());

		} catch (ParseException e) {
			System.out.println(e.getMessage());

		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		} catch (NullPointerException e) {
			e.getMessage();
		}
		return listaFuncionario;

	}

	@Override
	public List<String> conversaoPessoaParaString(List<Funcionario> pessoas) {
		List<String> pessoaString = new ArrayList<>();
		try {
			new ValidacaoException().validarPessoasSemCPF(pessoas);
			new ValidacaoException().validarPessoasSemSalario(pessoas);
			if (validaFuncionario(pessoas)) {
				for (Funcionario funcionario : pessoas) {

					pessoaString.add(funcionario.mostrar());

				}
			}
		} catch (ValidacaoException e) {
			System.out.println(e.getMessage());

		}
		return pessoaString;
	}

	@Override
	public Funcionario conversaoArrayParaPessoa(String[] array) {

		try {
			validaArray(array);
			return new Funcionario(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
		} catch (ParseException e) {
			e.getMessage();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		} catch (NullPointerException e) {
			e.getMessage();

		}
		return null;
	}

	@Override
	public List<Funcionario> conversaoArrayMultidimensionalParaPessoa(String[][] arrayMultidimensional) {
		List<String> stringAdd = new ArrayList<>();
		for (int i = 0; i < arrayMultidimensional.length; i++) {
			for (int j = 0; j < arrayMultidimensional[i].length; j++) {
				if (arrayMultidimensional[i].length > 8) {
					throw new IllegalArgumentException("Sua matriz possui mnais colunas que o esperado para cadastro");
				}
				stringAdd.add(arrayMultidimensional[i][j]);
			}
		}

		return conversaoStringParaPessoa(stringAdd);
	}

	@Override
	public int[][] arrayMultidimensionalParesImparesPrimosResto(int[] array, int numeroDivisaoResto) {
		int matrizParesPrimosRestos[][] = new int[array.length][4];
		for (int i = 0; i < array.length; i++) {
			int n = 0;
			if (array[i] % 2 == 0) {
				matrizParesPrimosRestos[i][0] = array[i];
			} else {
				matrizParesPrimosRestos[i][1] = array[i];
			}
			for (int j = 1; j < array[i]; j++) {

				if (array[i] % j == 0) {
					n++;
				}
			}
			if (n > 2) {
				matrizParesPrimosRestos[i][2] = 0;

			} else {
				if (array[i] > 0) {
					matrizParesPrimosRestos[i][2] = array[i];
				}

			}

		}

		// interarSobreOArrayMultidimensionalPrimos(matrizParesPrimosRestos);
		for (int i = 0; i < array.length; i++) {
			int resto = array[i] % numeroDivisaoResto;
			matrizParesPrimosRestos[i][3] = resto;
		}

		return matrizParesPrimosRestos;
	}

	@Override
	public String[] arrayMultidimensionalPorPosicoes(String[][] arrayMultidimensional, int coluna, int linha) {
		String[] arrayString = new String[4];

		try {
			arrayString[0] = arrayMultidimensional[linha][coluna - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posição antecessora não existe na matriz");
		}
		try {
			arrayString[1] = arrayMultidimensional[linha][coluna + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posição sucessora não existe na matriz");
		}
		try {
			arrayString[2] = arrayMultidimensional[linha + 1][coluna];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posição acima da posição especificada,na matriz, não existe");
		}
		try {
			arrayString[3] = arrayMultidimensional[linha - 1][coluna];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("A posição abaixo da posição especificada,na matriz, não existe");

		}
		return arrayString;
	}

	@Override
	public String[] arrayMultidimensionalPorValor(String[][] arrayMultidimensional, String valor) {
		String[] arrayString = new String[4];

		try {
			boolean existeOElementoEspecificado = false;
			int linha = 0;
			int coluna = 0;
			int verificadorDeRepetencia = 0;
			for (int i = 0; i < arrayMultidimensional.length; i++) {
				for (int j = 0; j < arrayMultidimensional[i].length; j++) {
					if (arrayMultidimensional[i][j].equals(valor)) {
						verificadorDeRepetencia++;
						existeOElementoEspecificado = true;
						linha = i;
						coluna = j;
						if (verificadorDeRepetencia > 1) {
							throw new UnexpectedException(
									"Sua matriz possui elementos repetidos, não é possivel verificar a ocorrencia de antecessores e sucessores");
						}

					}
				}
			}
			if (existeOElementoEspecificado == false) {
				throw new IllegalArgumentException("O elemento especificado no parametro não existe");
			}

			try {
				arrayString[0] = arrayMultidimensional[linha][coluna - 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("A posição antecessora não existe na matriz");
			}
			try {
				arrayString[1] = arrayMultidimensional[linha][coluna + 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("A posição sucessora não existe na matriz");
			}
			try {
				arrayString[2] = arrayMultidimensional[linha + 1][coluna];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("A posição acima da posição especificada,na matriz, não existe");
			}
			try {
				arrayString[3] = arrayMultidimensional[linha - 1][coluna];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("A posição abaixo da posição especificada,na matriz, não existe");

			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (UnexpectedException e) {
			System.out.println(e.getMessage());
		}
		return arrayString;

	}

	@Override
	public String[] antecessorSucessorPor(String[] array, int posicao) {
		String[] antecessorSucessor = new String[2];
		try {
			boolean elementoRepetido = false;
			for (int i = 0; i < array.length; i++) {
				for (int j = i + 1; j < array.length - 1; j++) {
					if (array[i].equals(array[j])) {
						elementoRepetido = true;
					}
				}

			}
			if (elementoRepetido == true) {
				throw new IllegalArgumentException(
						"seu array possui elementos repetidos, não é possivel saber o sucessor e antecessor de elementos repetidos");
			}
			try {
				antecessorSucessor[0] = array[posicao - 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Antecessor inexistente");
			}
			try {
				antecessorSucessor[1] = array[posicao + 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Sucessor inexistente");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return antecessorSucessor;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, String valor) {
		int posicao = 0;
		String[] antecessorSucessor = new String[2];
		try {
			boolean existeEsseElemento = false;
			boolean elementoRepetido = false;
			for (int i = 0; i < array.length; i++) {
				for (int j = i + 1; j < array.length - 1; j++) {
					if (array[i].equals(array[j])) {
						elementoRepetido = true;
					}
					if (array[i].equals(valor) && elementoRepetido == false) {
						posicao = i;
						existeEsseElemento = true;
					}
				}

			}
			if (elementoRepetido == true) {
				throw new UnexpectedException(
						"seu array possui elementos repetidos, não é possivel saber o sucessor e antecessor de elementos repetidos");
			}
			if (existeEsseElemento == false) {
				throw new IllegalArgumentException(
						"seu array possui elementos repetidos, não é possivel saber o sucessor e antecessor de elementos repetidos");
			}
			try {
				antecessorSucessor[0] = array[posicao - 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Antecessor inexistente");
			}
			try {
				antecessorSucessor[1] = array[posicao + 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Sucessor inexistente");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (UnexpectedException e) {
			System.out.println(e.getMessage());
		}
		return antecessorSucessor;
	}

	@Override
	public List<Integer> numerosPares(Integer limite) {
		List<Integer> numerosPares = new ArrayList<>();
		if (limite < 0) {
			for (int i = limite; i <= 0; i++) {
				if (i % 2 == 0) {
					numerosPares.add(i);
				}
			}
		}
		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				numerosPares.add(i);
			}
		}
		return numerosPares;
	}

	@Override
	public List<Integer> numerosImpares(Integer limite) {
		List<Integer> numerosimPares = new ArrayList<>();
		if (limite < 0) {
			for (int i = limite; i <= 0; i++) {
				if (!(i % 2 == 0)) {
					numerosimPares.add(i);
				}
			}
		}

		for (int i = 0; i <= limite; i++) {
			if (!(i % 2 == 0)) {
				numerosimPares.add(i);
			}
		}
		return numerosimPares;
	}

	@Override
	public List<Integer> numerosPrimos(Integer limite) {
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não existe números primos negativos");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		List<Integer> numerosPrimos = new ArrayList<>();

		for (int i = 0; i <= limite; i++) {
			int numeroDeDivisores = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					numeroDeDivisores++;
				}
			}
			if (numeroDeDivisores == 2 || i == 1) {
				numerosPrimos.add(i);
			}
		}

		return numerosPrimos;
	}

	@Override
	public int[] numerosParesArray(Integer limite) {
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido número negativo");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		int contadorDePares = 0;
		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				contadorDePares++;
			}
		}
		int[] numerosParesArray = new int[contadorDePares];
		int indiceArray = 0;
		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				numerosParesArray[indiceArray] = i;
				indiceArray++;
			}
		}
		return numerosParesArray;

	}

	@Override
	public int[] numerosImparesArray(Integer limite) {
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido número negativo");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		int contadorDeImpares = 0;
		for (int i = 0; i <= limite; i++) {
			if (!(i % 2 == 0)) {
				contadorDeImpares++;
			}
		}
		int[] numerosImparesArray = new int[contadorDeImpares];
		int indiceArray = 0;
		for (int i = 0; i <= limite; i++) {
			if (!(i % 2 == 0)) {
				numerosImparesArray[indiceArray] = i;
				indiceArray++;
			}
		}
		return numerosImparesArray;
	}

	@Override
	public int[] numerosPrimosArray(Integer limite) {
		try {
			if (limite <= 0) {
				throw new IllegalArgumentException("Não é permitido número negativo ou zero");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		int contadorDePrimos = 0;
		for (int i = 1; i <= limite; i++) {
			int contDiv = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					contDiv++;
				}
			}
			if (contDiv == 2 || i == 1) {
				contadorDePrimos++;
			}
		}
		int primosArray[] = new int[contadorDePrimos];
		int indexArray = 0;
		for (int i = 1; i <= limite; i++) {
			int contDiv = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					contDiv++;
				}
			}
			if (contDiv == 2 || i == 1) {
				primosArray[indexArray] = i;
				indexArray++;
			}
		}
		return primosArray;
	}

	@Override
	public int[] primeiraUltimaPosicaoArray(Integer limite) {
		int[] array = new int[2];
		array[0] = 0;
		array[1] = limite;
		return array;
	}

	@Override
	public int[] quantidadeParesImparesPrimos(List<Integer> valores) {
		int[] quantidadeParesImparesPrimos = new int[3];
		int par = 0;
		int impar = 0;
		int primo = 0;
		for (Integer numero : valores) {
			if (numero % 2 == 0) {
				par++;
			} else {
				impar++;
			}
		}
		for (int i = 0; i < valores.size(); i++) {
			int validadorPrimo = 0;
			for (int j = 1; j <= valores.get(i); j++) {
				if (valores.get(i) % j == 0 && valores.get(i) > 0) {
					validadorPrimo += 1;
				}
			}
			if (validadorPrimo == 2 || valores.get(i) == 1) {
				primo++;
			}
		}

		quantidadeParesImparesPrimos[0] = par;
		quantidadeParesImparesPrimos[1] = impar;
		quantidadeParesImparesPrimos[2] = primo;
		return quantidadeParesImparesPrimos;
	}

	@Override
	public int[] primeiraUltimaMediaPosicaoArray(Integer limite) {
		int[] arrayInt = new int[3];
		int contador = 0;
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido números negativos");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		for (int i = 0; i < limite; i++) {
			contador += i;
		}
		arrayInt[0] = 0;
		arrayInt[1] = limite;
		arrayInt[2] = (int) contador / limite;
		return arrayInt;
	}

	@Override
	public List<Integer> removerInteirosDuplicados(List<Integer> numeros) {
		for (int i = 0; i < numeros.size(); i++) {
			for (int j = i + 1; j <= numeros.size() - 1; j++) {
				if (numeros.get(i).equals(numeros.get(j))) {
					numeros.remove(j);
					j--;
				}
			}

		}
		return numeros;
	}

	@Override
	public List<BigDecimal> removerValoresDuplicados(List<BigDecimal> numeros) {
		for (int i = 0; i < numeros.size(); i++) {
			for (int j = i + 1; j <= numeros.size() - 1; j++) {
				if (numeros.get(i).equals(numeros.get(j))) {
					numeros.remove(j);
					j--;
				}
			}

		}
		return numeros;
	}

	@Override
	public List<String> removerTextosDuplicados(List<String> textos) {

		for (int i = 0; i < textos.size(); i++) {
			for (int j = i + 1; j <= textos.size() - 1; j++) {
				if (textos.get(i).equals(textos.get(j))) {
					textos.remove(j);
					j--;
				}
			}

		}
		return textos;
	}

	@Override
	public Integer valorInteiroMaiorQtdDuplicados(List<Integer> numeros) {
		boolean existeNumeroRepetido = false;
		int numeroQueMaisSeRepetiu = 0;
		try {
			loop: for (int i = 0; i < numeros.size(); i++) {
				for (int j = (i + 1); j <= (numeros.size() - 1); j++) {
					if (numeros.get(i).equals(numeros.get(j))) {
						existeNumeroRepetido = true;
						break loop;
					}
				}
			}
			if (existeNumeroRepetido == true) {
				int vezesQueOmaiorNumeroRepetiu = 0;
				for (int i = 0; i < numeros.size(); i++) {
					int vezesRepetiu = 0;
					for (int j = i + 1; j <= numeros.size() - 1; j++) {
						if (numeros.get(i).equals(numeros.get(j))) {
							vezesRepetiu++;
						}
					}
					if (vezesQueOmaiorNumeroRepetiu < vezesRepetiu) {
						vezesQueOmaiorNumeroRepetiu = vezesRepetiu;
						numeroQueMaisSeRepetiu = numeros.get(i);
					}
				}
			} else {
				throw new IllegalArgumentException("Não há números repetidos na lista");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		return numeroQueMaisSeRepetiu;
	}

	@Override
	public String valorTextoMaiorQtdDuplicados(List<String> textos) {
		boolean existeTextoRepetido = false;
		String textoQueMaisSeRepetiu = "";
		try {
			loop: for (int i = 0; i < textos.size(); i++) {
				for (int j = (i + 1); j <= (textos.size() - 1); j++) {
					if (textos.get(i).equals(textos.get(j))) {
						existeTextoRepetido = true;
						break loop;
					}
				}
			}
			if (existeTextoRepetido == true) {
				int vezesQueOmaiortextoRepetiu = 0;
				for (int i = 0; i < textos.size(); i++) {
					int vezesRepetiu = 0;
					for (int j = i + 1; j <= textos.size() - 1; j++) {
						if (textos.get(i).equals(textos.get(j))) {
							vezesRepetiu++;
						}
					}
					if (vezesQueOmaiortextoRepetiu < vezesRepetiu) {
						vezesQueOmaiortextoRepetiu = vezesRepetiu;
						textoQueMaisSeRepetiu = textos.get(i);
					}
				}
			} else {
				throw new IllegalArgumentException("Não há textos repetidos na lista");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		return textoQueMaisSeRepetiu;
	}

	@Override
	public List<Integer> listaInteirosDuplicados(List<Integer> numeros) {
		List<Integer> numerosDuplicados = new ArrayList<>();
		boolean existeNumeroRepetido = false;
		try {
			loop: for (int i = 0; i < numeros.size(); i++) {
				for (int j = (i + 1); j <= (numeros.size() - 1); j++) {
					if (numeros.get(i).equals(numeros.get(j))) {
						existeNumeroRepetido = true;
						break loop;
					}
				}
			}
			if (existeNumeroRepetido == true) {
				for (int i = 0; i < numeros.size(); i++) {

					for (int j = i + 1; j <= numeros.size() - 1; j++) {
						if (numeros.get(i).equals(numeros.get(j))) {
							numerosDuplicados.add(numeros.get(i));
						}
					}

				}
			} else {
				throw new IllegalArgumentException("Não há números repetidos na lista");
			}
			removerInteirosDuplicados(numerosDuplicados);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		return numerosDuplicados;
	}

	@Override
	public List<BigDecimal> listaDecimalDuplicados(List<BigDecimal> textos) {
		List<BigDecimal> numerosDuplicados = new ArrayList<>();
		boolean existeNumeroRepetido = false;
		try {
			loop: for (int i = 0; i < textos.size(); i++) {
				for (int j = (i + 1); j <= (textos.size() - 1); j++) {
					if (textos.get(i).equals(textos.get(j))) {
						existeNumeroRepetido = true;
						break loop;
					}
				}
			}
			if (existeNumeroRepetido == true) {
				for (int i = 0; i < textos.size(); i++) {

					for (int j = i + 1; j <= textos.size() - 1; j++) {
						if (textos.get(i).equals(textos.get(j))) {
							numerosDuplicados.add(textos.get(i));
						}
					}

				}
			} else {
				throw new IllegalArgumentException("Não há números repetidos na lista");
			}
			removerValoresDuplicados(numerosDuplicados);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		return numerosDuplicados;
	}

	@Override
	public List<String> listaTextoDuplicados(List<String> textos) {
		List<String> numerosDuplicados = new ArrayList<>();
		boolean existeNumeroRepetido = false;
		try {
			loop: for (int i = 0; i < textos.size(); i++) {
				for (int j = (i + 1); j <= (textos.size() - 1); j++) {
					if (textos.get(i).equals(textos.get(j))) {
						existeNumeroRepetido = true;
						break loop;
					}
				}
			}
			if (existeNumeroRepetido == true) {
				for (int i = 0; i < textos.size(); i++) {

					for (int j = i + 1; j <= textos.size() - 1; j++) {
						if (textos.get(i).equals(textos.get(j))) {
							numerosDuplicados.add(textos.get(i));
						}
					}

				}
			} else {
				throw new IllegalArgumentException("Não há textos repetidos na lista");
			}
			removerTextosDuplicados(numerosDuplicados);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		return numerosDuplicados;
	}

	@Override
	public Integer somarValores(Integer limite) {
		int soma = 0;
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido número negativo");
			} else {
				for (int i = 0; i < limite; i++) {
					soma += i;
				}

			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresPares(Integer limite) {
		int soma = 0;
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido número negativo");
			} else {
				for (int i = 0; i <= limite; i++) {
					if (i % 2 == 0) {
						soma += i;
					}
				}

			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresImpares(Integer limite) {
		int soma = 0;
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido número negativo");
			} else {
				for (int i = 0; i <= limite; i++) {
					if (!(i % 2 == 0)) {
						soma += i;
					}
				}

			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresPrimos(Integer limite) {
		int soma = 0;
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido número negativo");
			} else {
				for (int i = 0; i < limite; i++) {
					int validadorPrimo = 0;
					for (int j = 1; j <= i; j++) {
						if (i % j == 0 && i > 0) {
							validadorPrimo += 1;
						}
					}
					if (validadorPrimo == 2 || i == 1) {
						soma += i;
					}
				}
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresPosicoes(int[] valores) {
		int soma = 0;
		try {
			if (!(valores.length != 0)) {
				throw new IllegalArgumentException("Seu array está vazio");
			} else {
				for (int i = 0; i < valores.length; i++) {
					soma += valores[i];
				}
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresParesPosicoes(int[] valores) {
		int soma = 0;
		try {
			if (!(valores.length != 0)) {
				throw new IllegalArgumentException("Seu array está vazio");
			} else {
				for (int i = 0; i < valores.length; i++) {
					if (valores[i] % 2 == 0) {
						soma += valores[i];
					}
				}
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresImparesPosicoes(int[] valores) {
		int soma = 0;
		try {
			if (!(valores.length != 0)) {
				throw new IllegalArgumentException("Seu array está vazio");
			} else {
				for (int i = 0; i < valores.length; i++) {
					if (!(valores[i] % 2 == 0)) {
						soma += valores[i];
					}
				}
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresPrimosPosicoes(int[] valores) {
		int soma = 0;
		try {
			if (!(valores.length != 0)) {
				throw new IllegalArgumentException("Seu array está vazio");
			} else {
				for (int i = 0; i < valores.length; i++) {
					int validadorPrimo = 0;
					for (int j = 1; j <= valores[i]; j++) {
						if (valores[i] % j == 0 && valores[i] > 0) {
							validadorPrimo += 1;
						}
					}
					if (validadorPrimo == 2 || i == 1) {
						soma += valores[i];
					}
				}
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public Integer somarValoresPosicoesParesMultiplosDe(Integer limite, Integer multiplo) {
		int soma = 0;
		try {
			if (limite < 0) {
				throw new IllegalArgumentException("Não é permitido como limite números negativos");
			} else {
				for (int i = 0; i < limite; i++) {
					if (i % 2 == 0) {
						soma += i * multiplo;
					}

				}
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return soma;
	}

	@Override
	public boolean multiploDeSete(int valor) {
		if (valor % 7 == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String parOuImpar(int valor) {
		if (valor % 2 == 0) {
			return "PAR";
		}
		return "IMPAR";
	}

	@Override
	public String parOuImparOuZero(int valor) {
		if (valor == 0) {
			return "ZERO";
		} else if (valor % 2 == 0 && valor != 2) {
			return "PAR";
		} else {
			return "IMPAR";
		}

	}

	@Override
	public int[] obterDobrosAteDobroInformado(int valor) {
		try {
			if (valor < 0) {
				throw new IllegalArgumentException("O número deve ser positivo");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		int[] arrayVerificador = new int[valor * 2];
		int tamanhoArray = 0;
		int i = 0;
		int dobro = valor * 2;
		int valorFinal = dobro * 2;
		while (dobro <= valorFinal) {
			arrayVerificador[tamanhoArray] = dobro;
			valor += 1;
			dobro = valor * 2;
			tamanhoArray++;
		}
		int[] arrayDeDobros = new int[tamanhoArray];
		while (i < arrayDeDobros.length) {
			arrayDeDobros[i] = arrayVerificador[i];
			i++;
		}

		return arrayDeDobros;
	}

	@Override
	public int[] obterDobrosAteDez(int valor) {
		try {
			if (valor < 0) {
				throw new IllegalArgumentException("O número deve ser positivo");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		if (valor > 10) {
			int[] arrayVazio = new int[0];
			System.out.println("[]");
			return arrayVazio;
		}
		int i = valor;
		int tamanhoArray = 0;
		while (i <= 10) {
			i++;
			tamanhoArray++;
		}
		int arrayDobroAteDez[] = new int[tamanhoArray];
		int index = 0;
		while (valor <= 10) {
			int dobro = valor * 2;
			arrayDobroAteDez[index] = dobro;
			index++;
			valor++;
		}
		return arrayDobroAteDez;
	}

	@Override
	public int[] obterDobrosAteMil(int valor) {
		try {
			if (valor < 0) {
				throw new IllegalArgumentException("O número passado como parametro não pode ser negativo");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		int tamanhoDoArray = 0;
		int dobro = valor * 2;
		int guardaValorParaverificarOtamanhoDoArray = 0;
		int numeroAentrarNoArray = 0;
		int valorInicial = valor * 2;

		do {
			guardaValorParaverificarOtamanhoDoArray = dobro;
			dobro = guardaValorParaverificarOtamanhoDoArray * 2;
			tamanhoDoArray++;

		} while (dobro <= 1000 || dobro > 1001 && dobro < 2000);

		int arrayDobros[] = new int[tamanhoDoArray];
		int i = 0;
		do {
			numeroAentrarNoArray = valorInicial;
			arrayDobros[i] = numeroAentrarNoArray;
			valorInicial = numeroAentrarNoArray * 2;

			i++;

		} while (i < arrayDobros.length);

		return arrayDobros;
	}

	@Override
	public int[][] tabuada(int valor) {
		try {
			if (valor < 0) {
				throw new IllegalArgumentException("O número passado como parametro não pode ser negativo");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		int numeroColuna = 0;
		int linha = 0;
		int coluna = 0;

		for (int i = 1; i <= valor; i++) {

			numeroColuna++;
		}
		int matriz[][] = new int[11][numeroColuna];
		for (int i = 1; i <= valor; i++) {
			for (int j = 0; j <= 10; j++) {
				int tabuada = i * j;
				matriz[linha][coluna] = tabuada;
				linha++;
				if (linha == matriz.length) {
					linha = 0;
				}
			}
			coluna++;
		}

		return matriz;

	}

	// cria-se o método valida lista
	private boolean validaLista(List<String> lista, int i) {
		try {

			if (lista.get(i).length() <= 20 && lista.get(1 + i).length() <= 20 && lista.get(2 + i).length() <= 8
					&& lista.get(3 + i).length() == 1 && lista.get(4 + i).length() <= 40
					&& lista.get(5 + i).length() <= 14 && lista.get(6 + i).length() <= 40
					&& lista.get(7 + i).length() <= 10) {
				return true;
			} else {
				throw new ValidacaoException();
			}
		} catch (ValidacaoException e) {
			e.caracterInvalido();
			return false;
		}

	}

// cria-se o método para ver se a lista comporta os arrays pedidos
	private boolean validaFuncionario(List<Funcionario> pessoas) {
		try {
			for (Funcionario funcionario : pessoas) {// 05031996
				String nome = String.valueOf(funcionario.getNome());
				String sobrenome = String.valueOf(funcionario.getSobrenome());
				String dataNascimento = String.valueOf(funcionario.dataFormatada());
				String sexo = String.valueOf(funcionario.getSexo());
				String profissao = String.valueOf(funcionario.getProfissao());
				String cpf = String.valueOf(funcionario.getCpfCnpj());
				String escolaridade = String.valueOf(funcionario.getEscolaridade());
				String salario = String.valueOf(funcionario.getSalario());

				if (nome.length() <= 20 && sobrenome.length() <= 20 && dataNascimento.length() <= 8
						&& sexo.length() == 1 && profissao.length() <= 40 && cpf.length() <= 14
						&& escolaridade.length() <= 40 && salario.length() <= 10) {
					return true;
				} else {
					throw new ValidacaoException();
				}

			}
		} catch (ValidacaoException e) {
			e.caracterInvalido();

		}
		return false;
	}

	private boolean validaArray(String[] array) {
		try {
			if (array[0].length() <= 20 && array[1].length() <= 20 && array[2].length() <= 8 && array[3].length() == 1
					&& array[4].length() <= 40 && array[5].length() <= 14 && array[6].length() <= 40
					&& array[7].length() <= 10) {
				return true;

			} else {

				throw new ValidacaoException();

			}
		} catch (ValidacaoException e) {
			e.caracterInvalido();
			return false;
		}
	}

}
