package br.com.qwasolucoes.mentoria.model;

import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.implementacoes.logica_programacao.LogicaProgramacaoProvider;

public class TesteMain {
	public static void main(String[] args) {
	LogicaProgramacaoProvider a = new LogicaProgramacaoProvider();
		int matriz[] = a.obterDobrosAteDez(11);
		for(int i= 0 ; i < matriz.length;i++) {
			System.out.println(matriz[0]);
		}
		
		
		
		
		
		
		
		
		
		
	}
}
