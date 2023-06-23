package projeto.classes;

import java.time.LocalDate;

public class Evento {
	private String nome;
	private LocalDate data;
	private Pessoa responsavel;
	
	public Evento(String nome, String data, Pessoa responsavel) {
		this.nome = nome;
		this.data = LocalDate.parse(data);
		this.responsavel = responsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}
	
	
}
