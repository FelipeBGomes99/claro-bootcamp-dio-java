package Componentes;

import java.util.ArrayList;

public interface Ipod {
	
	ArrayList<Musica> musicas = new ArrayList<Musica>();
	ArrayList<ArrayList<Musica>> playlists = new ArrayList<>();
	
	
	public void play();
	public void tocarMusica(Musica m);
	public void pausar();
	public ArrayList<Musica> listarMusicas();
	public ArrayList<ArrayList<Musica>> listarPlaylist();
}
