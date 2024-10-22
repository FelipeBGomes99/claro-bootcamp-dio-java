package br.com.dio.contabanco;

import java.util.Scanner;

public class ContaTerminal {

	public static void main(String[] args) {
		ContaBanco cliente = new ContaBanco();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Seja bem vindo");
		
		System.out.println("Nome:");
		cliente.setNome(entrada.nextLine());
		
		System.out.println("Agencia:");
		cliente.setAgencia(entrada.nextInt());
		
		System.out.println("Numero:");
		cliente.setNumero(entrada.nextInt());
		
		System.out.println("Saldo:");
		cliente.setSaldo(entrada.nextFloat());
		
		System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %d, conta %d e seu saldo %.2f já está disponível para saque"
				, cliente.getNome(), cliente.getAgencia(), cliente.getNumero(), cliente.getSaldo());
		
		entrada.close();
	}

}
