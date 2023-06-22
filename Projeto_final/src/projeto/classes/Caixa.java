package projeto.classes;

import java.util.ArrayList;


public class Caixa {
	private static Double saldoAtual = 975.69;
	private static ArrayList<Movimentacao> movimentacoes;
	private static Double saldoInicioGestao = 975.69;
	private static Double balanco = saldoAtual - saldoInicioGestao;
	
	public static Double getSaldoAtual() {
		return saldoAtual;
	}
	public static void setSaldoAtual(Double saldoAtual) {
		Caixa.saldoAtual = saldoAtual;
	}
	public static ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public static void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		Caixa.movimentacoes = movimentacoes;
	}
	
	public static boolean gerarMovimentacao(Double valor, String descricao, Area area, Pessoa solicitante) {
		saldoAtual += valor;
		balanco += valor;
		return movimentacoes.add(new Movimentacao(valor, descricao, area, solicitante));
	}
	
	
}
