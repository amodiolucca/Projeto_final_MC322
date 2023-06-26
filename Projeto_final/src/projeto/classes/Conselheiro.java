package projeto.classes;

public class Conselheiro extends Pessoa {
	
	private String areaAnterior;
	
	//Construtor
	public Conselheiro(String ra, String nome, String telefone, String area, String senha) {
		super(ra, nome, telefone, senha);
		this.areaAnterior = area;
	}
	
	//getters e setters
	public String getAreaAnterior() {
		return areaAnterior;
	}
	public void setAreaAnterior(String area) {
		this.areaAnterior = area;
	}
}