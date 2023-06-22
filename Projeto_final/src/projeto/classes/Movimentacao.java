package projeto.classes;


public class Movimentacao {
	private double valor;
	private String descricao;
	private Area area;
	private Pessoa solicitante;
	
	public Movimentacao(Double valor, String descricao, Area area, Pessoa solicitante) {
		this.valor = valor;
		this.descricao = descricao;
		this.area = area;
		this.solicitante = solicitante;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Pessoa getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}
	
	
}
