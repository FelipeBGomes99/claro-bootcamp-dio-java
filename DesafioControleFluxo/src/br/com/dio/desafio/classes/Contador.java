package br.com.dio.desafio.classes;

import java.util.Scanner;


public class Contador {
	
	public static void main(String[] args) {
		
		Scanner terminal = new Scanner(System.in);
		
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();
		
		try {	
			contar(parametroUm, parametroDois);
		}catch(ParametrosInvalidosException e) {
			System.out.println("n1 maior que n2");
		}
		
		terminal.close();
	}
	
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		
		ParametrosInvalidosException.verificarParametros(parametroUm, parametroDois);
		int total = parametroDois - parametroUm;
		
		for(int cont = 1; cont<= total; cont++) {
			System.out.println("Imprimindo o numero " + cont);
		}
	}
	
	
	
	
}
