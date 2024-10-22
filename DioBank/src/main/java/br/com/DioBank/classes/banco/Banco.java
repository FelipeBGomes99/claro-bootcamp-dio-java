package br.com.DioBank.classes.banco;



import br.com.DioBank.classes.conta.Conta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome){
		this.nome = nome;
		this.contas = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void addConta(Conta conta){
		this.contas.add(conta);

	}

	public void listaContas(){
		for (Conta conta : contas) {
			conta.imprimirInfosComuns();
		}
	}

	public void deletarConta(int numero){
		Optional<Conta> contaParaRemover = contas.stream().filter(conta -> conta.getNumero() == numero).findFirst();

		contaParaRemover.ifPresentOrElse(
				conta -> {
					JOptionPane.showMessageDialog(null,"Conta removida.\n" +
							"nome: " + conta.getCliente().getNome()
							+ "\nnumero: " + conta.getNumero());
					contas.remove(conta);
				},
				() -> JOptionPane.showMessageDialog(null,"Conta não encontrada.")
		);
	}

	public Conta buscarConta(int numero){
		Optional<Conta> contaEncontrada = contas.stream().filter(conta -> conta.getNumero() == numero).findFirst();

		return contaEncontrada.orElse(null);
	}

}
