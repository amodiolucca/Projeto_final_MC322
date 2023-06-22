package projeto.classes.Pessoa;

import projeto.classes.Area.Area;

public class Conselheiro extends Pessoa {
	
	private Area areaAnterior;
	
	//Construtor
	public Conselheiro(int ra, String nome, String telefone, String email, Area area) {
		super(ra, nome, telefone, email);
		this.areaAnterior = area;
	}
	
	//getters e setters
	public Area getAreaAnterior() {
		return areaAnterior;
	}
	public void setAreaAnterior(Area area) {
		this.areaAnterior = area;
	}
}