
package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.algoritmos.Pilha;

public class PilhaAlgoritmo<T> implements Pilha<T> {

	private T[] elements;
	private int length;

	@SuppressWarnings("unchecked")
	public PilhaAlgoritmo(int capacity) {
		elements = (T[]) new Object[capacity];
		length = 0;
	}

	public int length() {
		return this.length;
	}

	public boolean add(T element) {
		this.aumentaCapacidade();
		if (this.length < this.elements.length) {
			this.elements[this.length] = element;
			this.length++;
			return true;
		}
		return false;
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

	public void remove(int position) {
		if (!(position >= 0 && position < length)) {

			throw new IllegalArgumentException("Posicao Invalida");
		}
		for (int i = position; i < this.length - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.length--;
	}

	public boolean isEmpty() {

		return this.length == 0;
	}

	public T topStack() {
		if (isEmpty()) {
			return null;
		}
		return this.elements[length - 1];
	}

	@Override
	public void empilhar(T elemento) {
		elements[length] = elemento;
		length++;

	}

	@Override
	public T desempilhar() {
		if (this.isEmpty()) {
			return null;
		}
		T element = this.elements[length - 1];
		length--;
		return element;
	}

	@Override
	public List<T> obterTodos() {
		List<T> stack = new ArrayList<>();
		stack = Arrays.asList(elements);
		return stack;
	}
	public T[] getElements() {
		return elements;
	}

}
