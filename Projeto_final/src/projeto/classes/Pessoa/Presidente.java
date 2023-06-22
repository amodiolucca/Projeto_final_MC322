package projeto.classes.Pessoa;

public class Presidente extends Pessoa {
	
	private boolean cargo; //Presidente(true), Vice-presidente(false)
	
	//Construtor
	public Presidente(int ra, String nome, String telefone, String email, boolean cargo) {
		super(ra, nome, telefone, email);
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
