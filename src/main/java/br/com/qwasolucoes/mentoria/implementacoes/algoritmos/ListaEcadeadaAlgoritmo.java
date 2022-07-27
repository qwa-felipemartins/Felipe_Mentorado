package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.ListaEncadeada;

public class ListaEcadeadaAlgoritmo<T> implements ListaEncadeada<T>{
	private No<T> begin;
	private int length;

	@Override
	public void remover() {
		begin = begin.getNext();
		length--;

	}

	@Override
	public void adicionar(T elemento) {
		No<T> cell = new No<T>(elemento, begin);
		this.begin = cell;
		length++;

	}

	@Override
	public List<T> todos() {
		List<T> all = new ArrayList<>();
		No<T> cell = begin;
		for (int i = 0; i < length; i++) {
			all.add(cell.getElement());
			cell = cell.getNext();
		}
		return all;
	}

	@Override
	public T obter(int indice) {
		if (!(indice >= 0 && indice < length)) {
			throw new IllegalArgumentException("Invalid position");
		}
		No<T> atual = begin;

		for (int i = 0; i < indice; i++) {

			atual = atual.getNext();
		}
		return  atual.getElement();
	}

	@Override
	public String toString() {
		if (this.length == 0) {
			return "[]";
		}

		No<T> atual = begin;

		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < length; i++) {
			builder.append(atual.getElement());
			builder.append(",");

			atual = atual.getNext();
		}

		builder.append("]");
		return builder.toString();
	}

	public void removerInicio() {
		No<T> ultimoDaLista = begin;
		for (int i = 0; i < length; i++) {
			ultimoDaLista = ultimoDaLista.getNext();
			if (ultimoDaLista.getNext() == null) {
				length--;
			}

		}
	}

}
