package Componentes;

import java.util.ArrayList;

public interface Chamadas {

	ArrayList<Contato> contatos = new ArrayList<Contato>();
	
	public boolean redeMOvel();
	
	public void ligar(Contato c);
	
	public void atender();
	
	public void correioDeVoz(Contato c);
}
