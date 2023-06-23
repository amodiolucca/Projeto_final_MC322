package projeto.classes;


public class Diretor extends Pessoa {
	
	private String area;
	
	//Construtor
	public Diretor(String ra, String nome, String telefone, String area) {
		super(ra, nome, telefone);
		this.area = area;
	}
	
	//getters e setters
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
}
