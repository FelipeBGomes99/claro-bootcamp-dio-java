package Componentes;

import java.util.ArrayList;

public class iphone implements Ipod, Chamadas, NavegadorInternet {
	
	ArrayList<Musica> musicas = new ArrayList<Musica>();
	ArrayList<ArrayList<Musica>> playlists = new ArrayList<>();

	@Override
	public void play() {
		System.out.println("tocando...");
		
	}

	@Override
	public void tocarMusica(Musica m) {
		System.out.println("tocando musica pedida...");
		
	}

	@Override
	public void pausar() {
		System.out.println("pausado...");
		
	}

	@Override
	public ArrayList<Musica> listarMusicas() {
		System.out.println("Sua lista de musicas...");
		return null;
	}

	@Override
	public ArrayList<ArrayList<Musica>> listarPlaylist() {
		System.out.println("Mostrando playlist...");
		return null;
	}

	@Override
	public boolean redeMOvel() {
		System.out.println("Checando rede...");
		return false;
	}

	@Override
	public void ligar(Contato c) {
		System.out.println("ligando...");
		
	}

	@Override
	public void atender() {
		System.out.println("atendendo chamada...");
		
	}

	@Override
	public void correioDeVoz(Contato c) {
		System.out.println("correio de voz de...");
		
	}

	@Override
	public boolean conexaoInternet() {
		System.out.println("Checando conexao com a internet...");
		return false;
	}

	@Override
	public void exibirPagina() {
		System.out.println("exibindo pagine web...");
		
	}

	@Override
	public void novaAba() {
		System.out.println("nova aba web...");
		
	}

	@Override
	public void atualizarAba() {
		System.out.println("atualizando aba...");
		
	}

}
