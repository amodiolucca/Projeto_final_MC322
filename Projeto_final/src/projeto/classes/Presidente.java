package projeto.classes;

public class Presidente extends Pessoa {
	
	private boolean posicao; //Presidente(true), Vice-presidente(false)
	
	//Construtor
	public Presidente(String ra, String nome, String telefone, boolean posicao, String senha) {
		super(ra, nome, telefone, senha);
		this.posicao = posicao;
	}
	
	//getters e setters
	public boolean getPosicao() {
		return posicao;
	}
	
	public void setPosicao(boolean posicao) {
		this.posicao = posicao;
	}
}
