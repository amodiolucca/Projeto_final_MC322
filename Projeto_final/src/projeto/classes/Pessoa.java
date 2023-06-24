package projeto.classes;

public abstract class Pessoa {
	
	private String ra;
	private String nome;
	private String telefone;
	private final String senha;
	
	//Construtor
	public Pessoa(String ra, String nome, String telefone) {
		this.ra = ra;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
	}
	
	//getters e setters
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	public void SetNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void SetTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
