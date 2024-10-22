package br.com.DioBank.classes.conta;

import br.com.DioBank.classes.cliente.Cliente;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {

		super(cliente);
	}


	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
