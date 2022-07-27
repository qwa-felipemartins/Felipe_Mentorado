package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Fila;

public class FilaAlgoritmo<T> implements Fila<T> {
	T[] elements;
	int length;

	@SuppressWarnings("unchecked")
	public FilaAlgoritmo(int capacity) {
		this.elements = (T[]) new Object[capacity];
		this.length = 0;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void remover() {
		length--;
		T[] queueNew = (T[]) new Object[length];
		for (int i = 0; i < queueNew.length; i++) {
			queueNew[i] = elements[i + 1];
		}
		elements = queueNew;

	}

	@Override
	public void adicionar(T elemento) {
		this.elements[length] = elemento;
		length++;

	}

	@Override
	public List<T> todos() {
		List<T> queue = new ArrayList<>();
		queue = Arrays.asList(elements);
		return queue;
	}

	@Override
	public T obter(int indice) {
		if (indice > 0 && indice < length) {
			return elements[indice];
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	private void aumentaCapacidade() {
		if (this.length == this.elements.length) {
			T[] elementsNew = (T[]) new Object[this.elements.length * 2];
			for (int i = 0; i < this.elements.length; i++) {
				elementsNew[i] = this.elements[i];
			}
			this.elements = elementsNew;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
