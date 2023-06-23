package projeto.classes;

import java.util.ArrayList;

public class Eventos extends Area {
	private static ArrayList<Evento> listaEventos;
	
	public boolean registrarEvento(String nome, String data, Pessoa responsavel) {
		for(Evento e: listaEventos) {
			if(e.getNome().equals(nome)) {
				return false;
			}
		}
		listaEventos.add(new Evento(nome, data, responsavel));
		return true;
	}
}
