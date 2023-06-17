package projeto.classes;

import java.util.ArrayList;

public class Membro extends Pessoa {
	
	private ArrayList<Area> areasDeInteresse;
	
	//Construtor
	public Membro(int ra, String nome, String telefone, String email) {
		super(ra, nome, telefone, email);
		this.areasDeInteresse = new ArrayList<>();
	}
	
	//getters e setters
	public ArrayList<Area> getAreasDeInteresse(){
		return areasDeInteresse;
	}
	public void setAreasDeInteresse(ArrayList<Area> lista) {
		this.areasDeInteresse = lista;
	}
}
