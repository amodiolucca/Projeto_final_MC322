package projeto.classes;


public class Conselheiro extends Pessoa {
	
	private Area areaAnterior;
	
	//Construtor
	public Conselheiro(String ra, String nome, String telefone, String email, Area area) {
		super(ra, nome, telefone);
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