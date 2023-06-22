package projeto.classes;


public class Diretor extends Pessoa {
	
	private Area area;
	
	//Construtor
	public Diretor(int ra, String nome, String telefone, String email, Area area) {
		super(ra, nome, telefone, email);
		this.area = area;
	}
	
	//getters e setters
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
}
