package projeto.classes;

public class Item {
	
	private String tamanho;
	private int quantidadeDisponivel;
	
	public Item(String tamanho) {
		this.tamanho = tamanho;
		this.quantidadeDisponivel = 0;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	
	
}
