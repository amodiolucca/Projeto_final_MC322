package projeto.classes;

import java.util.ArrayList;

public class Caixa {
	// TODO corrigir e mantenha sem ser static pfv
	private Double saldoAtual = 975.69;
	private Double saldoInicioGestao = 975.69;
	private Double balanco = saldoAtual - saldoInicioGestao;
	private ArrayList<Movimentacao> movimentacoes;
	
	public Double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(Double saldoAtual) {
		Caixa.saldoAtual = saldoAtual;
	}
	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		Caixa.movimentacoes = movimentacoes;
	}
	
	public static boolean gerarMovimentacao(Double valor, String descricao, Area area, Pessoa solicitante) {
		saldoAtual += valor;
		balanco += valor;
		return movimentacoes.add(new Movimentacao(valor, descricao, area, solicitante));
	}
}