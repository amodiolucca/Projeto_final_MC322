package projeto.classes;

public class Presidente extends Pessoa {
	
	private boolean cargo; //Presidente(true), Vice-presidente(false)
	
	//Construtor
	public Presidente(String ra, String nome, String telefone, boolean cargo) {
		super(ra, nome, telefone);
		this.cargo = cargo;
	}
	
	//getters e setters
	public boolean getCargo() {
		return cargo;
	}
	
	public void setCargo(boolean cargo) {
		this.cargo = cargo;
	}
}
