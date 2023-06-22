package projeto.classes;

public abstract class Pessoa {
	
	private int ra;
	private String nome;
	private String telefone;
	private String email;
	
	//Construtor
	public Pessoa(int ra, String nome, String telefone, String email) {
		this.ra = ra;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	//getters e setters
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
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
	
	public String getEmail() {
		return email;
	}
	public void SetEmail(String email) {
		this.email = email;
	}
	
}
