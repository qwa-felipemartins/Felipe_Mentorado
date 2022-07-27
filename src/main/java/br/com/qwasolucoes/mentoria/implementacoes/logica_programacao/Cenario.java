package br.com.qwasolucoes.mentoria.implementacoes.logica_programacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.qwasolucoes.mentoria.model.Funcionario;

public class Cenario {
	public static void main(String[] args) {
	
			Faturamento fat = new Faturamento();
			fat.adicionarFaturamentoSemanal(454);
			fat.adicionarFaturamentoSemanal(500);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(454);
			fat.adicionarFaturamentoSemanal(500);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(454);
			fat.adicionarFaturamentoSemanal(500);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(454);
			fat.adicionarFaturamentoSemanal(500);
			fat.adicionarFaturamentoSemanal(900);
			fat.adicionarFaturamentoSemanal(900);
			int [] a =  fat.obterFaturamentosSemanais();
			for( Integer x : a) {
				System.out.println(x);
				
			}
				
			
			
		

	}

}
