package br.com.qwasolucoes.mentoria.implementacoes.algoritmos;

public class CelulaArvore {

	int element;
	private CelulaArvore left;
	private CelulaArvore right;
	private CelulaArvore before;

	public CelulaArvore() {

	}

	public CelulaArvore(int element) {
		this.element = element;
	}

	public int getElement() {
		return element;
	}

	public CelulaArvore getLeft() {
		return left;
	}

	public CelulaArvore getRight() {
		return right;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public void setLeft(CelulaArvore left) {
		this.left = left;
	}

	public void setRight(CelulaArvore right) {
		this.right = right;
	}
	public void setBefore(CelulaArvore before) {
		this.before = before;
	}
	public CelulaArvore getBefore() {
		return before;
	}

}
