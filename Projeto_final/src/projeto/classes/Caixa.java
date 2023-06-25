package projeto.classes;

import java.util.ArrayList;

public class Caixa {
	private Double saldoAtual;
	private Double saldoInicioGestao;
	private Double balanco = saldoAtual - saldoInicioGestao;
	private ArrayList<Movimentacao> movimentacoes;
	
	public Caixa(Double saldoInicioGestao) {
		this.saldoAtual = saldoInicioGestao;
		this.saldoInicioGestao = saldoInicioGestao;
		this.balanco = 0.0;
		this.movimentacoes = new ArrayList<>();
	}
	public Double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public Double getSaldoInicioGestao() {
		return saldoInicioGestao;
	}
	public void setSaldoInicioGestao(Double saldoInicioGestao) {
		this.saldoInicioGestao = saldoInicioGestao;
	}
	public Double getBalanco() {
		return balanco;
	}
	public void setBalanco(Double balanco) {
		this.balanco = balanco;
	}
	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public boolean gerarMovimentacao(Double valor, String descricao, Area area, Pessoa solicitante) {
		saldoAtual += valor;
		balanco += valor;
		return movimentacoes.add(new Movimentacao(valor, descricao, area, solicitante));
	}
	public void gerarRelatorio() {
		String saida = "";
		
	}
}